package com.imooc.service.impl;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "1101110";

    private final String ORDER_ID = "1607598311016119344";
    @Test
    void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("创新港");
        orderDTO.setBuyerName("张佳磊");
        orderDTO.setBuyerPhone("13722414288");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123456");
        o1.setProductQuantity(5);
        orderDetailList.add(o1);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);

        log.info("【创建订单】result={}", result);

        Assert.assertNotNull(result);
    }

    @Test
    void findOne() {

        OrderDTO result = orderService.findOne(ORDER_ID);

        log.info("【查询单个订单】 result={}", result);

        Assert.assertEquals(ORDER_ID, result.getOrderId());

    }

    @Test
    void findList() {

        PageRequest pageRequest =  PageRequest.of(0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID,pageRequest);

        Assert.assertNotEquals(0, orderDTOPage.getTotalElements());

    }

    @Test
    void cancel() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    void finish() {
        OrderDTO orderDTO = orderService.findOne("1607598383889122555");
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(orderDTO.getOrderStatus(),OrderStatusEnum.FINISH.getCode());

    }

    @Test
    void paid() {
        OrderDTO orderDTO = orderService.findOne("1607598383889122555");
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(orderDTO.getPayStatus(), PayStatusEnum.SUCCESS.getCode());
    }
}