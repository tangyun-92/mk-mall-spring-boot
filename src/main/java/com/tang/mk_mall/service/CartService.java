package com.tang.mk_mall.service;


import com.tang.mk_mall.model.vo.CartVO;

import java.util.List;

/**
 * CartService
 */
public interface CartService {


    List<CartVO> list(Integer userId);

    List<CartVO> add(Integer userId, Integer productId, Integer count);
}
