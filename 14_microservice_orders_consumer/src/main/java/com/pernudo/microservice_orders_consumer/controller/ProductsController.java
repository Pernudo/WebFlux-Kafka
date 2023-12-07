package com.pernudo.microservice_orders_consumer.controller;

import com.pernudo.microservice_orders_consumer.model.Product;
import com.pernudo.microservice_orders_consumer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin("*")
@RestController
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "products", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<Flux<Product>> getProducts(){
        return new ResponseEntity<>(productService.listProducts(), HttpStatus.OK);
    }
    @GetMapping(value = "products/{category}")
    public ResponseEntity<Flux<Product>> productsCategory (@PathVariable("category") String category){
        return new ResponseEntity<>(productService.listProductsByCategory(category), HttpStatus.OK);
    }

    @GetMapping(value = "product")
    public ResponseEntity<Mono<Product>> productId(@RequestParam("id") int id){
        return new ResponseEntity<>(productService.productById(id), HttpStatus.OK);
    }

    @PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<Void>> saveProduct(@RequestBody Product product){
        product.setNewProduct(true);
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);
    }

    @PutMapping(value = "update")
    public Mono<ResponseEntity<Product>> updateProduct(@RequestParam("id") int id, @RequestParam("price") double price){
        return productService.updatePrice(id, price)//Mono<Product>
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK))//Mono<ResponseEntity<Product>>
                .switchIfEmpty(Mono.just(new ResponseEntity<>(HttpStatus.NOT_FOUND)));//Mono<ResponseEntity<Product>>
    }

    @DeleteMapping(value = "delete")
    public Mono<ResponseEntity<Product>> deleteProduct(@RequestParam("id") int id) {
        return productService.deleteProduct(id)//Mono<Product>
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK))//Mono<ResponseEntity<Product>>
                .switchIfEmpty(Mono.just(new ResponseEntity<>(HttpStatus.NOT_FOUND)));//Mono<ResponseEntity<Product>>
    }

}
