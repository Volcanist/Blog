package com.tc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tc.domain.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService{
    public ResponseResult uploadImg(MultipartFile img);
}
