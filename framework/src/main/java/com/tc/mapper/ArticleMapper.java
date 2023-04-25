package com.tc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tc.domain.entity.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
