package com.tang.mk_mall.model.request;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class ProductListReq {

    @ApiModelProperty(value = "搜索关键字", name = "keyword", dataType = "String")
    private String keyword;

    @ApiModelProperty(value = "分类id", name = "categoryId", dataType = "Integer")
    private Integer categoryId;

    @ApiModelProperty(value = "价格排序：desc-倒序 asc-升序（例：price desc）", name = "orderBy", dataType = "String")
    private String orderBy;

    @ApiModelProperty(value = "当前第几页", name = "pageNum", dataType = "Integer")
    private Integer pageNum=1;

    @ApiModelProperty(value = "每页显示条数", name = "pageSize", dataType = "Integer")
    private Integer pageSize=10;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

}