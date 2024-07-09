package com.product.service;

import com.product.model.ProductEntity;
import org.springframework.http.ResponseEntity;

public interface IProductService {

    ResponseEntity<ProductEntity> save(ProductEntity productEntity);

    ResponseEntity<?> delete(int id);

    ResponseEntity<?> update(ProductEntity productEntity, String name);

    ResponseEntity<?> findById(int id);

    ResponseEntity<?> findByName(String name);

    ResponseEntity<?> findAll();

}
