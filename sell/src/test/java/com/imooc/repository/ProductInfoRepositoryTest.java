package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductInfoRepositoryTest {

    @Autowired
    private  ProductInfoRepository repository;

    @Test
    void save(){
        ProductInfo productInfo = new ProductInfo("123456","台湾卤肉饭",new BigDecimal("18.99"),15,"美味无极限","http://xxxx.jpg",0,3);

        ProductInfo result = repository.save(productInfo);

        Assert.assertNotNull(result);
    }


    @Test
    void findProductInfoByProductStatus() {
        List<ProductInfo> productInfoList = repository.findProductInfoByProductStatus(0);
        Assert.assertNotEquals(0,productInfoList.size());
    }
}