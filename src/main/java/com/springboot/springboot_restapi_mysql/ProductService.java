package com.springboot.springboot_restapi_mysql;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProduct();
    Product getProductById(Long id);
    Product updateProductById(Long id,Product product);
    void deleteProduct(Long id);
}
