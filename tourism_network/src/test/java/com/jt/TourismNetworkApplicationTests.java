package com.jt;

import com.jt.domain.Orders;
import com.jt.domain.Product;
import com.jt.service.OrdersService;
import com.jt.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TourismNetworkApplicationTests {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrdersService ordersService;
    @Test
    public void contextLoads() {
        List<Product> list = productService.findAll();
        System.out.println(list);
    }

    @Test
    public void testOrdersFindAll(){
       List<Orders> list = ordersService.findAll();
        System.out.println(list);
    }

    @Test
    public void testPageOrders(){
        Page<Orders> page = ordersService.findAllByPage(1, 4);
        page.getTotalPages();page.getTotalElements();
        System.out.println(page.getNumber());
        System.out.println(page.getSize());
        System.out.println(page.getNumberOfElements());
        System.out.println(page.getSort());
        System.out.println(page.getContent());
    }

    @Test
    public void testDetailToOrders(){
        Orders orders = ordersService.findById("0E7231DC797C486290E8713CA3C6ECCC");
        System.out.println(orders.getMember());
        System.out.println(orders.getTravellers());
        System.out.println(orders.getProduct());
    }

}
