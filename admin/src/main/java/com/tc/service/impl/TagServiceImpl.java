package com.tc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tc.domain.entity.Tag;
import com.tc.mapper.TagMapper;
import com.tc.service.TagService;
import org.springframework.stereotype.Service;

/**
 * 标签(Tag)表服务实现类
 *
 * @author makejava
 * @since 2023-05-16 23:44:30
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}

