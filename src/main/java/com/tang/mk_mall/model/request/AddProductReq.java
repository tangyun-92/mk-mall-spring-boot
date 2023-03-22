package com.tang.mk_mall.model.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AddProductReq {

    @NotNull(message = "name不能为null")
    @ApiModelProperty(value = "商品名称", name = "name", dataType = "String", required = true)
    private String name;

    @NotNull(message = "image不能为null")
    @ApiModelProperty(value = "商品图片", name = "image", dataType = "String", required = true)
    private String image;

    @ApiModelProperty(value = "商品描述", name = "detail", dataType = "String")
    private String detail;

    @NotNull(message = "categoryId不能为null")
    @ApiModelProperty(value = "分类id", name = "categoryId", dataType = "Integer", required = true)
    private Integer categoryId;

    @NotNull(message = "price不能为null")
    @Min(value = 1, message = "price不能小于1")
    @ApiModelProperty(value = "商品价格", name = "price", dataType = "Integer", required = true)
    private Integer price;

    @NotNull(message = "stock不能为null")
    @Max(value = 10000, message = "stock不能大于10000")
    @ApiModelProperty(value = "商品库存", name = "stock", dataType = "Integer", required = true)
    private Integer stock;

    @ApiModelProperty(value = "上架状态：0-下架 1-上架（如不传默认为1）", name = "status", dataType = "Integer")
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}