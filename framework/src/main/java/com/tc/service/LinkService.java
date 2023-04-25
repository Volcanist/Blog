package com.tc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tc.domain.ResponseResult;
import com.tc.domain.entity.Link;


/**
 * 友链(Link)表服务接口
 *
 * @author Volcano
 * @since 2023-04-20 13:43:28
 */
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();
}

