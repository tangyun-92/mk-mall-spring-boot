package com.tang.mk_mall.controller;

import com.github.pagehelper.PageInfo;
import com.tang.mk_mall.common.ApiRestResponse;
import com.tang.mk_mall.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后台订单 Controller
 */
@RestController
@Api(tags = "后台订单管理")
public class OrderAdminController {

    @Autowired
    OrderService orderService;

    @PostMapping("/admin/order/list")
    @ApiOperation("后台订单列表")
    public ApiRestResponse listForAdmin(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageInfo pageInfo = orderService.listForAdmin(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    /**
     * 发货：订单状态流程：0-用户已取消 10-未付款 20-已付款 30-已发货 40-交易完成
     * @return
     */
    @PostMapping("/admin/order/delivered")
    @ApiOperation("后台发货")
    public ApiRestResponse delivered(@RequestParam String orderNo) {
        orderService.deliver(orderNo);
        return ApiRestResponse.success();
    }

    /**
     * 完结订单：订单状态流程：0-用户已取消 10-未付款 20-已付款 30-已发货 40-交易完成
     * 用户与管理员都可以完结订单
     * @return
     */
    @PostMapping("/order/finish")
    @ApiOperation("完结订单")
    public ApiRestResponse finish(@RequestParam String orderNo) {
        orderService.finish(orderNo);
        return ApiRestResponse.success();
    }
}
