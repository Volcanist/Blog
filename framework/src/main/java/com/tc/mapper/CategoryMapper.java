package com.tc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tc.domain.entity.Category;
import org.apache.ibatis.annotations.Mapper;


/**
 * 分类表(Category)表数据库访问层
 *
 * @author Volcano
 * @since 2023-04-17 10:58:31
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}

