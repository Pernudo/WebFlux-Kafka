package com.pernudo.microservice_crud_products.service;

import com.pernudo.microservice_crud_products.model.Product;
import com.pernudo.microservice_crud_products.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final List<Product> lstProducts=new ArrayList<>(List.of(
            new Product(100,"Azúcar","Alimentación",1.10,20),
            new Product(101,"Leche","Alimentación",1.20,15),
            new Product(102,"Jabón","Limpieza",0.89,30),
            new Product(103,"Mesa","Hogar",125,4),
            new Product(104,"Televisión","Hogar",650,10),
            new Product(105,"Huevos","Alimentación",2.20,30),
            new Product(106,"Fregona","Limpieza",3.40,6),
            new Product(107,"Detergente","Limpieza",8.7,12)));

    @Override
    public List<Product> listProducts() {
        return lstProducts;
    }

    @Override
    public List<Product> listProductsByCategory(String category) {
        return lstProducts.stream()
                .filter(p -> p.getCategory().equals(category))
                .toList();
    }

    @Override
    public Product productById(int id) {
        return lstProducts.stream()
                .filter(p -> p.getIdProduct() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void saveProduct(Product product) {
        if(productById(product.getIdProduct()) == null){
            lstProducts.add(product);
        }
    }

    @Override
    public Product deleteProduct(int id) {
        Product product = productById(id);
        if(product != null){
            lstProducts.removeIf(p -> p.getIdProduct() == id);
        }
        return product;
    }

    @Override
    public Product updatePrice(int id, double price) {
        Product product = productById(id);
        if(product != null){
            product.setPrice(price);
        }
        return product;
    }
}
