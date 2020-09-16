package com.imooc.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/*
 * Descriptions:
 * creat-time:2020/9/4--14:57
 */
@Data
public class ProductInfoVO {

    @JsonProperty("id")
    private String productId;

    //    名称
    @JsonProperty("name")
    private String productName;

    //    价格
    @JsonProperty("price")
    private BigDecimal productPrice;

    //    描述
    @JsonProperty("description")
    private String productDescription;

    //    小图
    @JsonProperty("icon")
    private String productIcon;

}
