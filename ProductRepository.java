package com.jsp.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jsp.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}