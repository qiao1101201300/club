package com.graduate.club.filter;

import com.alibaba.fastjson.JSON;
import com.graduate.club.entity.User;
import com.graduate.club.service.UserService;
import com.graduate.club.util.*;
import com.graduate.club.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

public class CheckLoginFilter implements Filter {
    /**
     * 检查用户登录状态
     */
    private Logger log = LoggerFactory.getLogger(this.getClass());
    //排除需要过滤的请求
    private String excludeURL = "";
    private String default_excludeURL = "login,upload,register";
    private String[] url_array = null;
    private String forward = "system.html";
    @Value("${filter.exclude.url}")
    private String filterExcludeUrl;
    @Autowired
    UserService userService;

    /**
     * 初始化
     *
     * @param filterConfig
     * @throws ServletException
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("");
        //设置过滤请求路径
        String url = StringUtils.trim(filterExcludeUrl);
        if (StringUtils.isBlank(url)) {
            excludeURL = default_excludeURL;
        } else {
            excludeURL = url;
        }
        url_array = excludeURL.split(",");
        log.info("CheckLoginFilter init 初始化.......");
    }

    /**
     * 拦截实现
     *
     * @param servletRequest
     * @param servletResponse
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        ResultVO jsonView = new ResultVO();
        String token = request.getHeader("token");


        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, token");


        String url = request.getRequestURI();
        log.debug("CheckLoginFilter method：" + request.getMethod() + ", url: " + url);
        String lastUrl = StringUtils.substringAfterLast(url, "/");

        if (request.getMethod().equalsIgnoreCase("options")) {
            response.setStatus(204);
            PrintWriter out = response.getWriter();
            out.close();
            return;
        }

        if (StringUtils.isNotBlank(token) && !token.equals("undefined")) {
            try {
                String jwtStr = token;

                Map<String, Object> jwtMap = JwtUtils.verifyToken(jwtStr);
                String userId = jwtMap.get("userid").toString();
                Date expireAt = (Date) jwtMap.get("expiresAt");

                if (expireAt.compareTo(new Date()) < 0) {
                    log.warn("token expired: " + expireAt);
                    errorResp(response, "token expired", Constants.ResCode.TOKEN_EXPIRED);
                }

                User user = userService.selectByPrimaryKey(userId);
                if (user != null && user.getStatus() == Constants.UserStatus.NORMAL) {
                    session.setAttribute(Constants.User.COOKIE_USER, user);
                    chain.doFilter(request, response);
                } else {
                    if (user == null) {
                        log.warn("No user found");
                        errorResp(response, "No user found", Constants.ResCode.USER_NOT_FOUND);
                    } else if (user != null && user.getStatus() == Constants.UserStatus.FORBID) {
                        log.warn("JwUser is forbid");
                        errorResp(response, "JwUser is forbid", Constants.ResCode.USER_FORBID);
                    } else {
                        log.warn("unknown error");
                        errorResp(response, "unknown error", Constants.ResCode.USER_FORBID);
                    }
                }
            } catch (Exception e) {
                log.info(e.getMessage());
            }

        } else {
            if (!StringUtils.isBlank(lastUrl) && checkNoneLoginUrl(lastUrl)) {
                chain.doFilter(request, response);
            } else {
                errorResp(response, "you are not login, please login first", Constants.ResCode.NOT_LOGIN);
                log.info("用户未登陆，请登陆!");
            }
        }
    }

    private void errorResp(HttpServletResponse response, String message, Integer code) throws IOException {
        PrintWriter out = response.getWriter();
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            ResultVO jsonView = ResultUtils.fail(code, message);
            out.append(JSON.toJSONString(jsonView));
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            out.close();
        }
    }

    /**
     * 判断当前URL是否需要拦截
     *
     * @param url
     * @return
     */
    private boolean checkNoneLoginUrl(String url) {
        boolean flag = false;
        for (String location : url_array) {
            if (location.equals(url.trim())) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 注销filter
     */
    public void destroy() {
        log.error("CheckLoginFilter destroy......");
    }
}
