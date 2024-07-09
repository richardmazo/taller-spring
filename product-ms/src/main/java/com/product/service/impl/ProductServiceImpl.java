package com.product.service.impl;

import com.product.model.ProductEntity;
import com.product.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductServiceImpl implements IProductService {

    public List<ProductEntity> productEntities = new ArrayList<>();

    @Override
    public ResponseEntity<ProductEntity> save(ProductEntity productEntity) {

        var existProduct = productEntities
                .stream()
                .anyMatch(
                        p -> p.getName().equalsIgnoreCase(productEntity.getName())
                );

        if(existProduct){
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(null);
        }

        productEntity.setId(productEntities.size() + 1);
        this.productEntities.add(productEntity);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productEntity);

    }

    @Override
    public ResponseEntity<?> delete(int id) {

        boolean flag = false;

        for (int i = 0; i < productEntities.size(); i++){
            if(productEntities.get(i).getId() == id){
                productEntities.remove(i);
                flag=true;
            }
        }
        String message = flag?"deleted":"product does not exist";
        return ResponseEntity.ok(message);
    }

    @Override
    public ResponseEntity<?> update(ProductEntity productEntity, String name) {

        for (int i = 0; i < productEntities.size(); i++){
            if(productEntities.get(i).getName().equalsIgnoreCase(name)){
                productEntity.setId(productEntities.get(i).getId());
                productEntities.set(i, productEntity);
                return ResponseEntity.ok(productEntity);
            }
        }

        return ResponseEntity.badRequest().body("product does not exists");

    }

    @Override
    public ResponseEntity<?> findById(int id) {
        return null;
    }

    @Override
    public ResponseEntity<?> findByName(String name) {
        return null;
    }

    @Override
    public ResponseEntity<?> findAll() {
        return null;
    }
}
