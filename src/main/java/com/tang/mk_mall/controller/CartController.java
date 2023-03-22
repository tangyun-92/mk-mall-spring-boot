package com.tang.mk_mall.controller;

import com.tang.mk_mall.common.ApiRestResponse;
import com.tang.mk_mall.filter.UserFilter;
import com.tang.mk_mall.model.vo.CartVO;
import com.tang.mk_mall.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 购物车 Controller
 */
@RestController
@RequestMapping("/cart")
@Api(tags = "购物车")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/list")
    @ApiOperation("购物车列表")
    public ApiRestResponse list() {
        // 内部获取用户ID，防止横向越权
        Integer userId = UserFilter.currentUser.getId();
        List<CartVO> cartList = cartService.list(userId);
        return ApiRestResponse.success(cartList);
    }

    @PostMapping("/add")
    @ApiOperation("添加商品到购物车")
    public ApiRestResponse add(@RequestParam Integer productId, @RequestParam Integer count) {
        Integer userId = UserFilter.currentUser.getId();
        List<CartVO> cartVOList = cartService.add(userId, productId, count);
        return ApiRestResponse.success(cartVOList);
    }

    @PostMapping("/update")
    @ApiOperation("更新购物车")
    public ApiRestResponse update(@RequestParam Integer productId, @RequestParam Integer count) {
        Integer userId = UserFilter.currentUser.getId();
        List<CartVO> cartVOList = cartService.update(userId, productId, count);
        return ApiRestResponse.success(cartVOList);
    }

    @PostMapping("/delete")
    @ApiOperation("删除购物车")
    public ApiRestResponse delete(@RequestParam Integer productId) {
        Integer userId = UserFilter.currentUser.getId();
        List<CartVO> cartVOList = cartService.delete(userId, productId);
        return ApiRestResponse.success(cartVOList);
    }

}
