package com.tang.mk_mall.service;

import com.github.pagehelper.PageInfo;
import com.tang.mk_mall.model.request.CreateOrderReq;
import com.tang.mk_mall.model.vo.OrderVO;

/**
 * 订单Service
 */
public interface OrderService {

    String create(CreateOrderReq createOrderReq);

    OrderVO detail(String orderNo);

    PageInfo listForCustomer(Integer pageNum, Integer pageSize);

    void cancel(String orderNo);

    String qrcode(String orderNo);

    PageInfo listForAdmin(Integer pageNum, Integer pageSize);
}
