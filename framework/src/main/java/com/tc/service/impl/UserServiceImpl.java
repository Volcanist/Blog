package com.tc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tc.domain.ResponseResult;
import com.tc.domain.entity.User;
import com.tc.domain.vo.UserInfoVo;
import com.tc.mapper.UserMapper;
import com.tc.service.UserService;
import com.tc.utils.BeanCopyUtils;
import com.tc.utils.SecurityUtils;
import org.springframework.stereotype.Service;

/**
 * 用户表(User)表服务实现类
 *
 * @author Volcano
 * @since 2023-04-20 14:27:11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 返回用户详细信息
     * @return
     */
    @Override
    public ResponseResult userInfo() {
        //查询用户id
        Long userId = SecurityUtils.getUserId();
        //根据id查询用户信息
        User user = getById(userId);
        //封装成UserInfoVo
        UserInfoVo vo = BeanCopyUtils.copyBean(user,UserInfoVo.class);
        return ResponseResult.okResult(vo);
    }
}

