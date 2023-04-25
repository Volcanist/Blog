package com.tc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tc.common.AppHttpCodeEnum;
import com.tc.common.SystemException;
import com.tc.domain.ResponseResult;
import com.tc.domain.entity.Comment;
import com.tc.domain.vo.CommentVo;
import com.tc.domain.vo.PageVo;
import com.tc.mapper.CommentMapper;
import com.tc.service.CommentService;
import com.tc.service.UserService;
import com.tc.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.tc.common.SystemConstants.LINK_COMMENT;

/**
 * 评论表(Comment)表服务实现类
 *
 * @author Volcano
 * @since 2023-04-22 19:26:42
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    private UserService userService;

    /**
     * 显示友联评论
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ResponseResult linkCommentList(Integer pageNum, Integer pageSize) {
        //查询友联根评论
        LambdaQueryWrapper<Comment> queryWrapper=new LambdaQueryWrapper<>();
        //选择类型为“1”的评论（友联评论）
        queryWrapper.eq(Comment::getType,LINK_COMMENT);
        //根评论root为-1
        queryWrapper.eq(Comment::getRootId,-1);
        //分页查询
        Page<Comment> page = new Page(pageNum,pageSize);
        page(page,queryWrapper);

        List<CommentVo> commentVoList = toCommentVoList(page.getRecords());
        //查询所有根评论对应的子评论集合，并且赋值给对应的属性
        for (CommentVo commentVo:commentVoList){
            //查询所有根评论对应的子评论集合
            List<CommentVo> childrenVos=getChildren(commentVo.getId());
            //给children赋值
            commentVo.setChildren(childrenVos);
        }
        return ResponseResult.okResult(new PageVo(commentVoList,page.getTotal()));
    }

    /**
     * 显示文章评论
     * @param articleId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize) {
        //查询对应文章的根评论
        LambdaQueryWrapper<Comment> queryWrapper=new LambdaQueryWrapper<>();
        //对articleId进行判断
        queryWrapper.eq(Comment::getArticleId,articleId);
        //根评论root为-1
        queryWrapper.eq(Comment::getRootId,-1);
        //分页查询
        Page<Comment> page = new Page(pageNum,pageSize);
        page(page,queryWrapper);

        List<CommentVo> commentVoList = toCommentVoList(page.getRecords());
        //查询所有根评论对应的子评论集合，并且赋值给对应的属性
        for (CommentVo commentVo:commentVoList){
            //查询所有根评论对应的子评论集合
            List<CommentVo> childrenVos=getChildren(commentVo.getId());
            //给children赋值
            commentVo.setChildren(childrenVos);
        }
        return ResponseResult.okResult(new PageVo(commentVoList,page.getTotal()));
    }

    @Override
    public ResponseResult addComment(Comment comment) {
        //评论内容不能为空
        if(!StringUtils.hasText(comment.getContent())){
            throw new SystemException(AppHttpCodeEnum.CONTENT_NOT_NULL);
        }
        //如果是友联评论，设置article_id为0
        if(comment.getType().equals("1")) comment.setArticleId(0L);
        save(comment);
        return ResponseResult.okResult();
    }

    private List<CommentVo> getChildren(Long id){
        //查询对应id的子评论
        LambdaQueryWrapper<Comment> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getRootId,id);
        queryWrapper.orderByAsc(Comment::getCreateTime);
        //封装所有子评论
        List<Comment> commentList=list(queryWrapper);
        List<CommentVo> commentVos = toCommentVoList(commentList);
        return commentVos;
    }

    private List<CommentVo> toCommentVoList(List<Comment> list){
        List<CommentVo> commentVos = BeanCopyUtils.copyBeanList(list, CommentVo.class);
        //遍历vo集合
        for (CommentVo commentVo : commentVos) {
            //通过creatyBy查询用户的昵称并赋值
            String nickName = userService.getById(commentVo.getCreateBy()).getNickName();
            commentVo.setUsername(nickName);
            //通过toCommentUserId查询用户的昵称并赋值
            //如果toCommentUserId不为-1才进行查询
            if(commentVo.getToCommentUserId()!=-1){
                String toCommentUserName = userService.getById(commentVo.getToCommentUserId()).getNickName();
                commentVo.setToCommentUserName(toCommentUserName);
            }
        }
        return commentVos;
    }
}

