package com.tc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tc.domain.ResponseResult;
import com.tc.domain.entity.Article;
import com.tc.domain.entity.User;

public interface BlogLoginService  {
    ResponseResult login(User user);

    ResponseResult logout();
}
