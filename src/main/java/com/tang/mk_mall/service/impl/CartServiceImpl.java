package com.tang.mk_mall.service.impl;

import com.tang.mk_mall.common.Constant;
import com.tang.mk_mall.exception.MallException;
import com.tang.mk_mall.exception.MallExceptionEnum;
import com.tang.mk_mall.model.dao.CartMapper;
import com.tang.mk_mall.model.dao.ProductMapper;
import com.tang.mk_mall.model.pojo.Cart;
import com.tang.mk_mall.model.pojo.Product;
import com.tang.mk_mall.model.vo.CartVO;
import com.tang.mk_mall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 购物车Service实现类
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    CartMapper cartMapper;

    @Override
    public List<CartVO> list(Integer userId) {
        List<CartVO> cartVOS = cartMapper.selectList(userId);
        for (int i = 0; i < cartVOS.size(); i++) {
            CartVO cartVO =  cartVOS.get(i);
            cartVO.setTotalPrice(cartVO.getPrice() * cartVO.getQuantity());
        }
        return cartVOS;
    }

    @Override
    public List<CartVO> add(Integer userId, Integer productId, Integer count) {
        validProduct(productId, count);

        Cart cart = cartMapper.selectCartByUserIdAndProductId(userId, productId);
        if (cart == null) {
            // 这个商品之前不在购物车里，需要新增一条记录
           cart = new Cart();
           cart.setProductId(productId);
           cart.setUserId(userId);
           cart.setQuantity(count);
           cart.setSelected(Constant.Cart.CHECKED);
           cartMapper.insertSelective(cart);
        } else {
            // 这个商品已经在购物车了，则数量相加
            count = cart.getQuantity() + count;
            Cart cartNew = new Cart();
            cartNew.setQuantity(count);
            cartNew.setId(cart.getId());
            cartNew.setUserId(cart.getUserId());
            cartNew.setProductId(cart.getProductId());
            cartNew.setSelected(Constant.Cart.CHECKED);
            cartMapper.updateByPrimaryKeySelective(cartNew);
        }
        return this.list(userId);
    }

    private void validProduct(Integer productId, Integer count) {
        Product product = productMapper.selectByPrimaryKey(productId);
        // 判断商品是否存在，是否上架
        if (product == null || product.getStatus().equals(Constant.SaleStatus.NOT_SALE)) {
            throw new MallException(MallExceptionEnum.NOT_SALE);
        }
        // 判断商品库存
        if (count > product.getStock()) {
            throw new MallException(MallExceptionEnum.NOT_ENOUGH);
        }
    }

    @Override
    public List<CartVO> update(Integer userId, Integer productId, Integer count) {
        validProduct(productId, count);

        Cart cart = cartMapper.selectCartByUserIdAndProductId(userId, productId);
        if (cart == null) {
            // 如果商品不在购物车里，无法更新
            throw new MallException(MallExceptionEnum.UPDATE_FAILED);
        } else {
            // 这个商品已经在购物车，更新数量
            Cart cartNew = new Cart();
            cartNew.setQuantity(count);
            cartNew.setId(cart.getId());
            cartNew.setUserId(cart.getUserId());
            cartNew.setProductId(cart.getProductId());
            cartNew.setSelected(Constant.Cart.CHECKED);
            cartMapper.updateByPrimaryKeySelective(cartNew);
        }
        return this.list(userId);
    }

    @Override
    public List<CartVO> delete(Integer userId, Integer productId) {
        Cart cart = cartMapper.selectCartByUserIdAndProductId(userId, productId);
        if (cart == null) {
            // 如果商品不在购物车里，无法删除
            throw new MallException(MallExceptionEnum.DELETE_FAILED);
        } else {
            // 这个商品已经在购物车，可以删除
            cartMapper.deleteByPrimaryKey(cart.getId());
        }
        return this.list(userId);
    }

}
