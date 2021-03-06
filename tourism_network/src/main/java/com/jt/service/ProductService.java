package com.jt.service;

import com.jt.dao.ProductDao;
import com.jt.domain.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductService {
    @Resource(name = "productDao")
    private ProductDao productDao;

    public List<Product> findAll(){
        return productDao.findAll();
    }

    public void save(Product product) {
        productDao.save(product);
    }
}
