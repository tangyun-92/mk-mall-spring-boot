package com.tang.mk_mall.service.impl;

import com.tang.mk_mall.exception.MallException;
import com.tang.mk_mall.exception.MallExceptionEnum;
import com.tang.mk_mall.model.dao.ProductMapper;
import com.tang.mk_mall.model.pojo.Product;
import com.tang.mk_mall.model.request.AddProductReq;
import com.tang.mk_mall.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品实现类
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public void add(AddProductReq addProductReq) {
        Product product = new Product();
        BeanUtils.copyProperties(addProductReq, product);

        Product productOld = productMapper.selectByName(addProductReq.getName());
        if (productOld != null) {
            throw new MallException(MallExceptionEnum.NAME_EXISTED);
        }
        int count = productMapper.insertSelective(product);
        if (count == 0) {
            throw new MallException(MallExceptionEnum.CREATE_FAILED);
        }
    }
}
