package com.jt.dao;

import com.jt.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrdersDao extends JpaRepository<Orders,String>,
        JpaSpecificationExecutor<Orders> {
}
