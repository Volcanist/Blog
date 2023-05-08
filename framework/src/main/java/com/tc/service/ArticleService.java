package com.tc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tc.domain.ResponseResult;
import com.tc.domain.entity.Article;

/**
 * 文章表(Article)表服务接口
 *
 * @author Volcano
 * @since 2023-04-13 00:03:16
 */
public interface ArticleService extends IService<Article> {

    ResponseResult hotArticleList();

    ResponseResult ArticleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long id);

    ResponseResult updateViewCount(Long id);
}

