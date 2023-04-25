package com.tc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tc.domain.ResponseResult;
import com.tc.domain.entity.Category;


/**
 * 分类表(Category)表服务接口
 *
 * @author Volcano
 * @since 2023-04-17 10:58:29
 */
public interface CategoryService extends IService<Category> {


    ResponseResult getCategoryList();
}

