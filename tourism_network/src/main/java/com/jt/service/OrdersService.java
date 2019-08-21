package com.jt.service;

import com.jt.dao.OrdersDao;
import com.jt.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrdersService {
    @Autowired
    private OrdersDao ordersDao;
    public List<Orders> findAll() {
        return ordersDao.findAll();
    }

    public Page<Orders> findAllByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page-1,size);
        Page<Orders> orders = ordersDao.findAll(pageable);
        return orders;
    }

    public Orders findById(String id){
        return ordersDao.getOne(id);
    }
}
