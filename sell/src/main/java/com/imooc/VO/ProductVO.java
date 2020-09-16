package com.imooc.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/*
 * Descriptions:商品（包含类目）
 * creat-time:2020/9/4--14:53
 */
@Data
public class ProductVO<T> {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private T productInfoVO;

}
