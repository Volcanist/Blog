package com.tc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tc.domain.ResponseResult;
import com.tc.domain.entity.User;


/**
 * 用户表(User)表服务接口
 *
 * @author Volcano
 * @since 2023-04-20 14:27:11
 */
public interface UserService extends IService<User> {

    ResponseResult userInfo();
}

