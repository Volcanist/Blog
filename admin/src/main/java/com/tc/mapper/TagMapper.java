package com.tc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tc.domain.entity.Tag;
import org.apache.ibatis.annotations.Mapper;


/**
 * 标签(Tag)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-16 23:31:48
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

}

