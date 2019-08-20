package com.jt.dao;

import com.jt.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductDao extends JpaRepository<Product,Integer>,
        JpaSpecificationExecutor<Product> {
}
