package com.tc.controller;




import com.tc.domain.ResponseResult;
import com.tc.domain.entity.Comment;
import com.tc.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 评论表(Comment)表控制层
 *
 * @author Volcano
 * @since 2023-04-22 19:25:55
 */
@RestController
@RequestMapping("comment")
public class CommentController{
    /**
     * 服务对象
     */
    @Resource
    private CommentService commentService;

    /**
     * 显示文章评论
     * @param articleId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/commentList")
    public ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize){
        return commentService.commentList(articleId,pageNum,pageSize);
    }

    /**
     * 发表文章评论
     * @param comment
     * @return
     */
    @PostMapping
    public ResponseResult addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

    @GetMapping("/linkCommentList")
    public ResponseResult linkCommentList(Integer pageNum, Integer pageSize){
        return commentService.linkCommentList(pageNum,pageSize);
    }


}

