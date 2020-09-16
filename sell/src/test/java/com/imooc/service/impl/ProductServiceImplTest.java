package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.repository.ProductInfoRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    void findById() {
        ProductInfo productInfo = productService.findById("123456");
        Assert.assertEquals("123456",productInfo.getProductId());
    }

    @Test
    void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    void findAll() {
        PageRequest pageRequest = PageRequest.of(0,2);
        Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);
        long totalElements = productInfoPage.getTotalElements();
//        System.out.println(totalElements);
        Assert.assertNotNull(productInfoPage);
    }

    @Test
    void save() {
        ProductInfo productInfo = new ProductInfo("123457","可口可乐",new BigDecimal("4.99"),
                999,"透心凉心飞扬","http://xxxx.jpg",0,1);
        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }
}