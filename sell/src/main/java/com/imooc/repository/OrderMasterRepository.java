package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.hibernate.criterion.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @InterfaceName: OrderMasterRepository
 * @Description:
 * @Author: 壁垒
 * @Date: 2020/12/9/20:53
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
