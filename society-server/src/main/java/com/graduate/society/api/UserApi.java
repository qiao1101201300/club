package com.graduate.society.api;

import com.graduate.society.entity.User;
import com.graduate.society.enums.ResultEnum;
import com.graduate.society.exception.ServerException;
import com.graduate.society.service.UserService;
import com.graduate.society.util.*;
import com.graduate.society.vo.ResultVO;
import com.graduate.society.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api/user/")
public class UserApi {
    @Autowired
    UserService userService;

    @PostMapping("login")
    public ResultVO findUser(@RequestBody @Valid UserVO userVO) {
        Map<String, String> m = new HashMap<>();
        try {
            User user1 = userService.getUserByUserName(userVO.getUsername());
            if (user1 == null) {
                ResultUtils.error(ResultEnum.USER_NOT_FOUND);
            }
            String password = AesUtils.Decrypt(user1.getPassword(), ConfigHelper.getString("aes.key"));
            password = MD5Utils.hmacMd5(password, userVO.getRandom());
            if (!userVO.getPassword().equals(password)) {
                ResultUtils.error(ResultEnum.PASSWORD_ERROR);
            }
            m.put("userid", user1.getId());
            String token = JwtUtils.genToken(m);
            m.clear();
            m.put("userProfile",user1.getUsername());
            m.put("token",token);
        } catch (Exception e) {
            throw new ServerException(ResultEnum.INTERNAL_SERVER_ERROR);
        }
        return ResultUtils.success(m);
    }

    @PostMapping("save")
    public ResultVO save(@RequestBody @Valid User user) {
        user.setStatus(Constants.UserStatus.NORMAL);
        try {
            User user1 = userService.getUserByUserName(user.getUsername());
            if (user1 != null){
                return ResultUtils.error(ResultEnum.USERNAME_EXISTS);
            }
            user.setPassword(AesUtils.Encrypt(user.getPassword(), ConfigHelper.getString("aes.key")));
        } catch (Exception e) {
            throw new ServerException(ResultEnum.INTERNAL_SERVER_ERROR);
        }
        boolean flag = userService.insert(user);
        return flag ? ResultUtils.success() : ResultUtils.error(ResultEnum.DB_SAVE_FAILED);
    }
}
