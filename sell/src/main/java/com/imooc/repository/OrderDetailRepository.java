package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @InterfaceName: OrderDetailRepository
 * @Description:
 * @Author: 壁垒
 * @Date: 2020/12/9/20:56
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {


}
