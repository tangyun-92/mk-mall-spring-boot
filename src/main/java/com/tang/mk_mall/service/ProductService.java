package com.tang.mk_mall.service;

import com.tang.mk_mall.model.pojo.Product;
import com.tang.mk_mall.model.request.AddProductReq;
import org.springframework.stereotype.Service;

/**
 * 商品 Service
 */
public interface ProductService {
    void add(AddProductReq addProductReq);

    void update(Product updateProduct);

    void delete(Integer id);
}
