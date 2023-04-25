package com.tc.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tc.domain.ResponseResult;
import com.tc.domain.entity.Category;
import com.tc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 分类表(Category)表控制层
 *
 * @author Volcano
 * @since 2023-04-17 11:04:08
 */
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getCategoryList")
    public ResponseResult getCategoryList(){
        return categoryService.getCategoryList();
    }
}

