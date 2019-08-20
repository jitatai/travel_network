package com.jt.controller;

import com.jt.domain.Product;
import com.jt.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService service;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Product> findAll(){
        return service.findAll();
    }
    @RequestMapping("productlist")
    public String productList(){
        return "product-list";
    }
}
