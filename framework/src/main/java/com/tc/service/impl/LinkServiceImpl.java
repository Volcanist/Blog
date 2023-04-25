package com.tc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tc.common.SystemConstants;
import com.tc.domain.ResponseResult;
import com.tc.domain.entity.Link;
import com.tc.domain.vo.LinkVo;
import com.tc.mapper.LinkMapper;
import com.tc.service.LinkService;
import com.tc.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 友链(Link)表服务实现类
 *
 * @author Volcano
 * @since 2023-04-20 13:43:28
 */
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    @Override
    public ResponseResult getAllLink() {
        //查询通过状态的友联
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Link::getStatus, SystemConstants.LINK_STATUS_NORMAL);

        //转换成Vo
        List<Link> linkList=list(queryWrapper);
        List<LinkVo> linkVoList= BeanCopyUtils.copyBeanList(linkList,LinkVo.class);

        return ResponseResult.okResult(linkVoList);
    }
}

