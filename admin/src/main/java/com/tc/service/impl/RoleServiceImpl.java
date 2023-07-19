package com.tc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tc.domain.entity.Role;
import com.tc.mapper.RoleMapper;
import com.tc.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色信息表(Role)表服务实现类
 *
 * @author makejava
 * @since 2023-05-17 23:22:00
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public List<String> selectRoleKeyByUserId(Long id) {
        return null;
    }
}

