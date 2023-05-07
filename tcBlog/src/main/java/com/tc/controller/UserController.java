package com.tc.controller;

import com.tc.annotation.SystemLog;
import com.tc.domain.ResponseResult;
import com.tc.domain.entity.User;
import com.tc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查看用户个人信息
     * @return
     */
    @GetMapping("/userInfo")
    @SystemLog(BusinessName = "查看用户个人信息")
    public ResponseResult userInfo(){
        return userService.userInfo();
    }


    /**
     * 修改并保存用户个人信息
     * @param user
     * @return
     */
    @PutMapping("/userInfo")
    @SystemLog(BusinessName = "修改并保存用户个人信息")
    public ResponseResult updateUserInfo(@RequestBody User user){
        return userService.updateUserInfo(user);
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    @SystemLog(BusinessName = "用户注册")
    public ResponseResult register(@RequestBody User user){
        return userService.register(user);
    }
}
