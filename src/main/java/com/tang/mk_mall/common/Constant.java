package com.tang.mk_mall.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 常量值
 */
@Component
public class Constant {

    // 盐值，用于MD5
    public static final String SALT = "Sdafdf_/fds32.``}df";

    // session中存放用户信息的字段
    public static final String MALL_USER = "mall_user";

    // 图片上传
    public static String FILE_UPLOAD_FIR;
    @Value("${file.upload.dir}")
    public void setFileUploadDir(String fileUploadDir) {
        FILE_UPLOAD_FIR = fileUploadDir;
    }
}
