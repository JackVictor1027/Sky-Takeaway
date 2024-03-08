package com.sky.controller.admin;/*

 */

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * 通用接口
 * @projectName: sky-take-out
 * @package: com.sky.controller.admin
 * @className: CommonController
 * @author: JackVictor
 * @description: TODO
 * @date: 2024/3/8 9:49
 * @version: 1.0
 */
@RestController
@RequestMapping("/admin/common")
@Api(tags="通用接口")
@Slf4j
public class CommonController {
    @Autowired
    private AliOssUtil aliOssUtil;
    @PostMapping("/upload")
    @ApiOperation("文件上传")
    /**
     * 文件上传
    * @param [file]
    * @return com.sky.result.Result<java.lang.String>
    */
    public Result<String> upload(MultipartFile file){
        log.info("文件上传：{}",file);
        try {
            String originalFileName=file.getOriginalFilename();//原始文件名
            //截取原始文件名
            String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String objectName = UUID.randomUUID().toString()+extension;
            //文件的访问路径
            String filePath = aliOssUtil.upload(file.getBytes(), objectName);
            return Result.success(filePath);
        } catch (IOException e) {
            log.error("文件上传失败:{}",e);
        }
        return Result.error(MessageConstant.UPLOAD_FAILED);
    }
}
