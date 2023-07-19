package com.tc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tc.domain.entity.Role;

import java.util.List;


/**
 * 角色信息表(Role)表服务接口
 *
 * @author makejava
 * @since 2023-05-17 23:22:00
 */
public interface RoleService extends IService<Role> {

    List<String> selectRoleKeyByUserId(Long id);
}

