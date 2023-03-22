package com.tang.mk_mall.common;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Set;

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

    public interface ProductListOrderBy {
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price desc", "price asc");
    }

    // 商品是否上架的枚举
    public interface SaleStatus {
        int NOT_SALE = 0; // 商品下架状态
        int SALE = 1; // 商品上架状态
    }

    // 购物车中商品是否选中的枚举
    public interface Cart {
        int UN_CHECKED = 0; // 未选中
        int CHECKED = 1; // 选中
    }
}
