package com.tang.mk_mall.model.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateCategoryReq {

    @NotNull(message = "id不能为null")
    private Integer id;

    @Size(min = 2, max = 5, message = "name必须在 {min} 至 {max} 之间")
    @ApiModelProperty(value = "分类名称", name = "name", dataType = "String")
    private String name;

    @Max(value = 3, message = "type最大值不能超过3")
    @ApiModelProperty(value = "分类目录级别：1-一级 2-二级 3-三级", name = "type", dataType = "Integer")
    private Integer type;

    @ApiModelProperty(value = "父级id：如果是一级目录，父id为0", name = "parentId", dataType = "Integer")
    private Integer parentId;

    @ApiModelProperty(value = "目录排序", name = "orderNum", dataType = "Integer")
    private Integer orderNum;

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
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}
