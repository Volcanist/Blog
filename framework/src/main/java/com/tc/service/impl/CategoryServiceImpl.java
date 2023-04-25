package com.tc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tc.common.SystemConstants;
import com.tc.domain.ResponseResult;
import com.tc.domain.entity.Article;
import com.tc.domain.entity.Category;
import com.tc.domain.vo.CategoryVo;
import com.tc.mapper.CategoryMapper;
import com.tc.service.ArticleService;
import com.tc.service.CategoryService;
import com.tc.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



/**
 * 分类表(Category)表服务实现类
 *
 * @author Volcano
 * @since 2023-04-17 10:58:29
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private ArticleService articleService;
    @Override
    public ResponseResult getCategoryList() {
        //查询出状态为已发布的文章列表
        LambdaQueryWrapper<Article> articleQW= new LambdaQueryWrapper<>();
        articleQW.eq(Article::getStatus,SystemConstants.ARTICLE_STATUS_NORMAL);

        //获取文章分类id并去重
        List<Article> articleList=articleService.list(articleQW);
        Set<Long> categoryIds = articleList.stream()
                .map(article -> article.getCategoryId())
                .collect(Collectors.toSet());

        //查询分类表
        List<Category> categories = listByIds(categoryIds);
        categories = categories.stream()
                .filter(category -> SystemConstants.STATUS_NORMAL.equals(category.getStatus()))
                .collect(Collectors.toList());

        //封装VO
        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(categories,CategoryVo.class);

        return ResponseResult.okResult(categoryVos);
    }
}

