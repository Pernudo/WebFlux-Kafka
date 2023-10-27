package com.pernudo.microservice_crud_products.controller;

import com.pernudo.microservice_crud_products.model.Product;
import com.pernudo.microservice_crud_products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping(value="products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> products(){
        return productService.listProducts();
    }

    @GetMapping(value = "products/{category}")
    public List<Product> productsCategory (@PathVariable("category") String category){
        return productService.listProductsByCategory(category);
    }

    @GetMapping(value = "product")
    public Product productId(@RequestParam("id") int id){
        return productService.productById(id);
    }

    @PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
    }

    @PutMapping(value = "update")
    public Product updateProduct(@RequestParam("id") int id, @RequestParam("price") double price){
        return productService.updatePrice(id, price);
    }

    @DeleteMapping(value = "delete")
    public Product deleteProduct(@RequestParam("id") int id) {
        return productService.deleteProduct(id);
    }

}
