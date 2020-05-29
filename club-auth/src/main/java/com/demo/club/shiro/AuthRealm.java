package com.demo.club.shiro;

import com.demo.club.entity.Menu;
import com.demo.club.entity.Role;
import com.demo.club.entity.User;
import com.demo.club.entity.UserProfile;
import com.demo.club.service.RoleService;
import com.demo.club.service.UserProfileService;
import com.demo.club.service.UserService;
import com.demo.club.util.JwtUtils;
import com.demo.club.util.RedisUtils;
import com.demo.club.util.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AuthRealm extends AuthorizingRealm {
    @Value("${aes.key}")
    private String aesKey;
    @Autowired
    UserProfileService userProfileService;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    /**
     * 认证 判断token的有效性
     *
     * @param token
     * @return org.apache.shiro.authc.AuthenticationInfo
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取token，既前端传入的token
        String accessToken = (String) token.getPrincipal();
        //1. 根据accessToken，查询用户信息
        Map<String, Object> jwtMap = JwtUtils.verifyToken(accessToken);
        String userId = jwtMap.get("userid").toString();
        String redisToken = (String) RedisUtils.get(userId);
        //2. token失效
        if (StringUtils.isBlank(redisToken) || !redisToken.equals(accessToken)) {
            throw new ExpiredCredentialsException ("token失效，请重新登录");
        }
        //3. 调用数据库的方法, 从数据库中查询 username 对应的用户记录
        User user = userService.selectByPrimaryKey(userId);
        //4. 若用户不存在, 则可以抛出 UnknownAccountException 异常
        if (user == null) {
            throw new UnknownAccountException("用户不存在!");
        }
        //5. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, accessToken, this.getName());
        return info;
    }

    @Override
    /**
     * 授权 获取用户的角色和权限
     *@param  [principals]
     *@return org.apache.shiro.authz.AuthorizationInfo
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //1. 从 PrincipalCollection 中来获取登录用户的信息
        User user = (User) principals.getPrimaryPrincipal();
        UserProfile userProfile = new UserProfile();
        userProfile.setUserid(user.getId());
        userProfile = userProfileService.selectOne(userProfile);

        //Integer userId = user.getUserId();
        //2.添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Role role = roleService.selectAllMenu(userProfile.getLevel());
        //2.1添加角色
        simpleAuthorizationInfo.addRole(role.getRoleName());
        for (Menu menu : role.getMenuList()) {
            //2.1.1添加权限
            simpleAuthorizationInfo.addStringPermission(menu.getPerms());
        }
        return simpleAuthorizationInfo;
    }
}
