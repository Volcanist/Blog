package com.tc.controller;


import com.tc.domain.ResponseResult;
import com.tc.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 标签(Tag)表控制层
 *
 * @author Volcano
 * @since 2023-05-16 23:31:48
 */
@RestController
@RequestMapping("/content/tag")
public class TagController{
    /**
     * 服务对象
     */
    @Autowired
    private TagService tagService;

    @GetMapping("/list")
    public ResponseResult list(){
        return ResponseResult.okResult(tagService.list());
    }


}

