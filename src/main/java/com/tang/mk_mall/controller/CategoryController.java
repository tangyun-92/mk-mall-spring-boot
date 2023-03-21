package com.tang.mk_mall.controller;

import com.github.pagehelper.PageInfo;
import com.tang.mk_mall.common.ApiRestResponse;
import com.tang.mk_mall.common.Constant;
import com.tang.mk_mall.exception.MallExceptionEnum;
import com.tang.mk_mall.model.pojo.Category;
import com.tang.mk_mall.model.pojo.User;
import com.tang.mk_mall.model.request.AddCategoryReq;
import com.tang.mk_mall.model.request.UpdateCategoryReq;
import com.tang.mk_mall.service.CategoryService;
import com.tang.mk_mall.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * 目录 Controller
 */
@Api(tags = "分类管理")
@Controller
public class CategoryController {

    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;

    /**
     * 后台添加商品分类
     * @param httpSession
     * @param addCategoryReq
     * @return
     */
    @ApiOperation(value = "后台添加商品分类")
    @PostMapping("admin/category/add")
    @ResponseBody
    public ApiRestResponse addCategory(HttpSession httpSession, @Valid @RequestBody AddCategoryReq addCategoryReq) {
        categoryService.add(addCategoryReq);
        return ApiRestResponse.success();
    }

    /**
     * 更新商品分类
     * @param httpSession
     * @param updateCategoryReq
     * @return
     */
    @ApiOperation(value = "后台更新商品分类")
    @PostMapping("admin/category/update")
    @ResponseBody
    public ApiRestResponse updateCategory(HttpSession httpSession, @Valid @RequestBody UpdateCategoryReq updateCategoryReq) {
        Category category = new Category();
        BeanUtils.copyProperties(updateCategoryReq, category);
        categoryService.update(category);
        return ApiRestResponse.success();
    }

    @ApiOperation(value = "后台删除商品分类")
    @PostMapping("admin/category/delete")
    @ResponseBody
    public ApiRestResponse deleteCategory(@RequestParam Integer id) {
        categoryService.delete(id);
        return ApiRestResponse.success();
    }

    @ApiOperation(value = "后台商品分类列表")
    @PostMapping("admin/category/list")
    @ResponseBody
    public ApiRestResponse listCategoryForAdmin(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageInfo pageInfo = categoryService.listForAdmin(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation(value = "前台商品分类列表")
    @PostMapping("category/list")
    @ResponseBody
    public ApiRestResponse listCategoryForAdmin(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageInfo pageInfo = categoryService.listForAdmin(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }

}
