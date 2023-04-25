package com.tc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tc.domain.ResponseResult;
import com.tc.domain.entity.Comment;


/**
 * 评论表(Comment)表服务接口
 *
 * @author Volcano
 * @since 2023-04-22 19:26:42
 */
public interface CommentService extends IService<Comment> {
    ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize);

    ResponseResult addComment(Comment comment);

    ResponseResult linkCommentList(Integer pageNum, Integer pageSize);
}

