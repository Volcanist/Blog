package com.tc.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDetailVo {
    private Long categoryId;

    //分类名
    private String categoryName;

    //文章内容
    private String content;

    private Date createTime;

    private Long id;

    //是否允许评论 1是，0否
    private String isComment;

    //标题
    private String title;

    //访问量
    private Long viewCount;


}
