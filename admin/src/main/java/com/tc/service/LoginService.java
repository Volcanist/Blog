package com.tc.service;

import com.tc.domain.ResponseResult;
import com.tc.domain.entity.User;

public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
