package com.tc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tc.domain.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import com.tc.domain.entity.Comment;


/**
 * 评论表(Comment)表数据库访问层
 *
 * @author Volcano
 * @since 2023-04-22 19:26:42
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}

