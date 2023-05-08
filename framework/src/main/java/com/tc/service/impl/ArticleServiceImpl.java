package com.tc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tc.common.SystemConstants;
import com.tc.domain.ResponseResult;
import com.tc.domain.entity.Category;
import com.tc.domain.vo.ArticleDetailVo;
import com.tc.domain.vo.ArticleListVo;
import com.tc.domain.vo.PageVo;
import com.tc.mapper.ArticleMapper;
import com.tc.domain.entity.Article;
import com.tc.service.ArticleService;
import com.tc.service.CategoryService;
import com.tc.utils.BeanCopyUtils;
import com.tc.domain.vo.HotArticleVo;
import com.tc.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.tc.common.SystemConstants.ARTICLE_STATUS_NORMAL;

/**
 * 文章表(Article)表服务实现类
 *
 * @author Volcano
 * @since 2023-04-13 00:03:17
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private RedisCache redisCache;


    @Override
    public ResponseResult hotArticleList() {
        //查询热门文章 封装成ResponseResult返回
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //必须是正式文章
        queryWrapper.eq(Article::getStatus,ARTICLE_STATUS_NORMAL);
        //按照浏览量进行排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //最多只查询10条
        Page<Article> page = new Page(1,10);
        page(page,queryWrapper);

        List<Article> articles = page.getRecords();
        //bean拷贝
        List<HotArticleVo> articleVos =
                BeanCopyUtils.copyBeanList(articles,HotArticleVo.class);

        return ResponseResult.okResult(articleVos);
    }

    @Override
    public ResponseResult ArticleList(Integer pageNum, Integer pageSize, Long categoryId) {
        //查询文章 封装成ResponseResult返回
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //必须是正式文章,如果有分类要求，按照分类要求排除

        queryWrapper.eq(Objects.nonNull(categoryId)&&categoryId>0 ,Article::getCategoryId,categoryId);
        queryWrapper.eq(Article::getStatus, ARTICLE_STATUS_NORMAL);

        // 对isTop进行降序
        queryWrapper.orderByDesc(Article::getIsTop);
        //按照页面大小封装
        Page<Article> page = new Page(pageNum,pageSize);
        page(page,queryWrapper);

        List<Article> articles = page.getRecords();

        //查询categoryName
//        articles.stream()
//                .map(article -> article.setCategoryName(categoryService.getById(article.getCategoryId()).getName()))
//                .collect(Collectors.toList());

        //articleId去查询articleName进行设置
        for (Article article : articles) {
            Category category = categoryService.getById(article.getCategoryId());
            article.setCategoryName(category.getName());
        }


        //bean拷贝
        List<ArticleListVo> articleListVos = BeanCopyUtils.copyBeanList(page.getRecords(), ArticleListVo.class);
        //封装查询结果
        PageVo pageVo = new PageVo(articleListVos,page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult getArticleDetail(Long id) {
        //根据id查询文章
        Article article = getById(id);
        //从redis中获取viewCount
        Integer viewCount = redisCache.getCacheMapValue("article:viewCount", id.toString());
        article.setViewCount(viewCount.longValue());
        //转换成VO
        ArticleDetailVo articleDetailVo=BeanCopyUtils.copyBean(article,ArticleDetailVo.class);
        //根据分类id查询分类名
        Category category=categoryService.getById(article.getCategoryId());
        if(category!=null) articleDetailVo.setCategoryName(category.getName());

        //封装响应返回

        return ResponseResult.okResult(articleDetailVo);
    }

    @Override
    public ResponseResult updateViewCount(Long id) {
        redisCache.incrementCacheMapValue("article:viewCount", id.toString(),1);
        return ResponseResult.okResult();
    }


}

