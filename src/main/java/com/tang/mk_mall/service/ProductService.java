package com.tang.mk_mall.service;

import com.github.pagehelper.PageInfo;
import com.tang.mk_mall.model.pojo.Product;
import com.tang.mk_mall.model.request.AddProductReq;
import com.tang.mk_mall.model.request.ProductListReq;
import org.springframework.stereotype.Service;

/**
 * 商品 Service
 */
public interface ProductService {
    void add(AddProductReq addProductReq);

    void update(Product updateProduct);

    void delete(Integer id);

    void batchUpdateSellStatus(Integer[] ids, Integer sellStatus);

    PageInfo listForAdmin(Integer pageNum, Integer pageSize);

    Product detail(Integer id);

    PageInfo list(ProductListReq productListReq);
}
