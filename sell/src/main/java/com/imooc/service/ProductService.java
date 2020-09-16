package com.imooc.service;

/*
        商品
 */

import com.imooc.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductInfo findById(String productId);

    /*
        查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /*
        查询所有商品列表
     */
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存

    //减库存


}
