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
}
