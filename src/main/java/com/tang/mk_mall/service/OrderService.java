package com.tang.mk_mall.service;

import com.tang.mk_mall.model.request.CreateOrderReq;

/**
 * 订单Service
 */
public interface OrderService {

    String create(CreateOrderReq createOrderReq);
}
