package com.tang.mk_mall.model.request;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UpdateProductReq {

    @NotNull(message = "name不能为null")
    @ApiModelProperty(value = "商品id", name = "id", dataType = "Integer", required = true)
    private Integer id;

    @ApiModelProperty(value = "商品名称", name = "name", dataType = "String")
    private String name;

    @ApiModelProperty(value = "商品图片", name = "image", dataType = "String")
    private String image;

    @ApiModelProperty(value = "商品描述", name = "detail", dataType = "String")
    private String detail;

    @ApiModelProperty(value = "分类id", name = "categoryId", dataType = "Integer")
    private Integer categoryId;

    @Min(value = 1, message = "price不能小于1")
    @ApiModelProperty(value = "商品价格", name = "price", dataType = "Integer")
    private Integer price;

    @Max(value = 10000, message = "stock不能大于10000")
    @ApiModelProperty(value = "商品库存", name = "stock", dataType = "Integer")
    private Integer stock;

    @ApiModelProperty(value = "上架状态：0-下架 1-上架（如不传默认为1）", name = "status", dataType = "Integer")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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