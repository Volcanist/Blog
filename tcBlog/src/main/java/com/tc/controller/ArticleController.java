package com.tc.controller;

import com.tc.domain.ResponseResult;
import com.tc.domain.entity.Article;
import com.tc.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/list")
    public List<Article> test(){
        return articleService.list();
    }

    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList(){
        ResponseResult result=articleService.hotArticleList();
        return result;
    }

    @GetMapping("/articleList")
    public ResponseResult ArticleList(Integer pageNum, Integer pageSize, Long categoryId){
        ResponseResult result=articleService.ArticleList(pageNum, pageSize, categoryId);
        return result;
    }

    @GetMapping("/{id}")
    public ResponseResult getArticleDetails(@PathVariable("id") Long id){
        return articleService.getArticleDetail(id);
    }
}
