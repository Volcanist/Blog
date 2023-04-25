package com.tc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tc.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * 用户表(User)表数据库访问层
 *
 * @author Volcano
 * @since 2023-04-20 14:27:11
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

