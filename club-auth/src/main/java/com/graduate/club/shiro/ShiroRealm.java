package com.graduate.club.shiro;

import com.graduate.club.entity.User;
import com.graduate.club.enums.ResultEnum;
import com.graduate.club.exception.ServerException;
import com.graduate.club.service.UserService;
import com.graduate.club.util.AesUtils;
import com.graduate.club.util.ConfigHelper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 根据用户名获取用户密码
        User user = userService.getUserByUserName(token.getUsername());

        if (user == null) {
            throw new AuthenticationException(String.valueOf(ResultEnum.USER_NOT_FOUND));
        }

        String password = user.getPassword();
        String saltPassword = null;
        try {
            saltPassword = AesUtils.Encrypt(user.getPassword(), ConfigHelper.getString("aes.key"));
        } catch (Exception e) {
            throw new ServerException(ResultEnum.INTERNAL_SERVER_ERROR);
        }

        if (null == password) {
            throw new AuthenticationException(String.valueOf(ResultEnum.INTERNAL_SERVER_ERROR));
        } else if (!password.equals(saltPassword)) {
            throw new AuthenticationException(String.valueOf(ResultEnum.PASSWORD_ERROR));
        }
        return new SimpleAuthenticationInfo(token.getPrincipal(), token.getPassword(), getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        // 根据 用户名称 获取用户的 角色信息
        Set<String> roles = userService.findUserRolesByUserName(username);
        // 设置该用户拥有的角色 @RequiresRoles
        if (roles.size() > 0) {
            simpleAuthorizationInfo.setRoles(roles);
        }

        // 设置用户的权限列表 @RequiresPermissions
        Set<String> userPermissions = userService.findUserPermissionsByUserName(username);
        if (userPermissions.size() > 0) {
            simpleAuthorizationInfo.setStringPermissions(userPermissions);
        }

        return simpleAuthorizationInfo;
    }
}
