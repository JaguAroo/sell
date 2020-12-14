package com.imooc.dto;

import lombok.Data;

/**
 * @ClassName: CartDTO
 * @Description:
 * @Author: 壁垒
 * @Date: 2020/12/10/18:13
 */
@Data
public class CartDTO {

    /*商品ID*/
    private String productId;

    /*商品数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
