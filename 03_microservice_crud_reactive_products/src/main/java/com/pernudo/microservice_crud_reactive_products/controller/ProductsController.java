package com.pernudo.microservice_crud_reactive_products.controller;

import com.pernudo.microservice_crud_reactive_products.model.Product;
import com.pernudo.microservice_crud_reactive_products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "products")
    public Flux<Product> getProducts(){
        return productService.listProducts();
    }
    @GetMapping(value = "products/{category}")
    public Flux<Product> productsCategory (@PathVariable("category") String category){
        return productService.listProductsByCategory(category);
    }

    @GetMapping(value = "product")
    public Mono<Product> productId(@RequestParam("id") int id){
        return productService.productById(id);
    }

    @PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Void> saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PutMapping(value = "update")
    public Mono<Product> updateProduct(@RequestParam("id") int id, @RequestParam("price") double price){
        return productService.updatePrice(id, price);
    }

    @DeleteMapping(value = "delete")
    public Mono<Product> deleteProduct(@RequestParam("id") int id) {
        return productService.deleteProduct(id);
    }

}
