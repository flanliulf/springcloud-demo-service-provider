package com.fancyliu.springcloud.demo.provider.service;

import com.fancyliu.springcloud.demo.provider.model.Product;

import java.util.List;


public interface ProductService {

    Product find(int id);

    List<Product> list();

    int insert(Product product);

    int update(Product product);

    int delete(int id);
}
