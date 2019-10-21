package com.fancyliu.springcloud.demo.provider.controller;

import com.fancyliu.springcloud.demo.provider.model.Product;
import com.fancyliu.springcloud.demo.provider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 类描述:
 * 商品 Controller,提供 rest API 接口
 *
 * @author : Liu Fan
 * @date : 2019/10/21 11:49
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/list")
    public List<Product> list() {
        return this.productService.list();
    }

    @GetMapping("find")
    public Product find(int id) {
        Product product = this.productService.find(id);
        return product;
    }

    @PostMapping("add")
    public int add(String name) {
        Product product = new Product();
        product.setName(name);
        int insert = this.productService.insert(product);
        return insert;
    }

    @PutMapping("update")
    public int update(int id, String name) {
        Product product = new Product();
        product.setName(name);
        product.setId(id);
        int update = this.productService.update(product);
        return update;
    }

    @DeleteMapping("delete")
    public int delelte(int id) {
        int delete = this.productService.delete(id);
        return delete;
    }

}
