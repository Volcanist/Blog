package com.tc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tc.domain.entity.Link;
import org.apache.ibatis.annotations.Mapper;
import com.tc.domain.entity.Link;


/**
 * 友链(Link)表数据库访问层
 *
 * @author Volcano
 * @since 2023-04-20 13:43:28
 */
@Mapper
public interface LinkMapper extends BaseMapper<Link> {

}

