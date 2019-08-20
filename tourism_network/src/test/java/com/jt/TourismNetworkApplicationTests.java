package com.jt;

import com.jt.domain.Product;
import com.jt.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TourismNetworkApplicationTests {

    @Autowired
    private ProductService productService;
    @Test
    public void contextLoads() {
        List<Product> list = productService.findAll();
        System.out.println(list);
    }

}
