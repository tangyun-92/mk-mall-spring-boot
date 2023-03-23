package com.tang.mk_mall.service;

import com.tang.mk_mall.model.request.CreateOrderReq;
import com.tang.mk_mall.model.vo.OrderVO;

/**
 * 订单Service
 */
public interface OrderService {

    String create(CreateOrderReq createOrderReq);

    OrderVO detail(String orderNo);
}
