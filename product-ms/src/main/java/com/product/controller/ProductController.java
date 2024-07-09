package com.product.controller;

import com.product.model.ProductEntity;
import com.product.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @PostMapping
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity productEntity){
        return this.iProductService.save(productEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return this.iProductService.delete(id);
    }

    @PutMapping("/{name}")
    public ResponseEntity<?> update(@RequestBody ProductEntity productEntity,@PathVariable("name") String name){
        return this.iProductService.update(productEntity, name);
    }

    //TODO: Listar todos los productos, buscar por ID, buscar por name

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id){
        //return this.iProductService.findById(id);
        return null;
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable("name") String name){
        //return this.iProductService.findByName(name);
        return null;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        //return this.iProductService.findAll();
        return null;
    }


}
