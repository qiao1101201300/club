package com.demo.club.api;

import com.demo.club.entity.User;
import com.demo.club.enums.ResultEnum;
import com.demo.club.service.UserService;
import com.demo.club.util.JwtUtil;
import com.demo.club.util.ResultUtils;
import com.demo.club.vo.ResultVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserApi {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public ResultVO login(@RequestBody User user) {

        String password = user.getPassword();
        String token = "";
        //用户信息
        user = userService.selectOne(user);
        //账号不存在、密码错误
        if (user == null || !user.getPassword().equals(password)) {
            return ResultUtils.error(ResultEnum.ERROR.getCode(), "登陆失败！");
        } else {
            //生成token，并保存到数据库
            Map<String, String> m = new HashMap<String, String>();
            m.put("userid", user.getId());
            token = "Bear " + JwtUtil.genToken(m);
        }
        return ResultUtils.success(token);
    }

    @RequiresPermissions({"select"})
    @PostMapping("selectAll")
    public ResultVO selectAll() {
        List<User> users = userService.selectAll();
        return ResultUtils.success(users);
    }
}
