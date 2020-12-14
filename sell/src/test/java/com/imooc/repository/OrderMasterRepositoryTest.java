package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "abcdef";

    @Test
    public void saveTest(){

        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("13113113111");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setBuyerAddress("创新港");
        orderMaster.setOrderStatus(0);
        orderMaster.setPayStatus(0);
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }
    @Test
    void findByBuyerOpenid() {
        PageRequest request = PageRequest.of(0,2);
        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, request);
//        System.out.println(result.getTotalElements());
        Assert.assertNotNull(result.getTotalElements());
    }
}