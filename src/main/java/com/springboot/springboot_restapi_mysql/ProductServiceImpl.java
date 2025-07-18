package com.springboot.springboot_restapi_mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product updateProductById(Long id, Product newProduct) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if(existingProduct != null)
        {
            existingProduct.setName(newProduct.getName());
            existingProduct.setCategory(newProduct.getCategory());
            existingProduct.setPrice(newProduct.getPrice());
            existingProduct.setQuantity(newProduct.getQuantity());
            return productRepository.save(existingProduct);
        }
        return  null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
