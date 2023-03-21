package com.tang.mk_mall.service;

import com.github.pagehelper.PageInfo;
import com.tang.mk_mall.model.pojo.Category;
import com.tang.mk_mall.model.request.AddCategoryReq;

public interface CategoryService {
    void add(AddCategoryReq addCategoryReq);

    void update(Category updateCategory);

    void delete(Integer id);

    PageInfo listForAdmin(Integer pageNum, Integer pageSize);
}
