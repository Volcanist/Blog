package com.tc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tc.domain.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import com.tc.domain.entity.Role;


/**
 * 角色信息表(Role)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-17 23:22:00
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

}

