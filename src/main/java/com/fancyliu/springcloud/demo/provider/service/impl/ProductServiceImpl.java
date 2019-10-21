package com.fancyliu.springcloud.demo.provider.service.impl;

import com.fancyliu.springcloud.demo.provider.dao.ProductMapper;
import com.fancyliu.springcloud.demo.provider.model.Product;
import com.fancyliu.springcloud.demo.provider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述:
 * 商品 Service 实现类
 *
 * @author : Liu Fan
 * @date : 2019/10/21 11:46
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper mapper;


    @Override
    public Product find(int id) {
        return this.mapper.find(id);
    }

    @Override
    public List<Product> list() {
        return this.mapper.list();
    }

    @Override
    public int insert(Product product) {
        return this.mapper.insert(product);
    }

    @Override
    public int update(Product product) {
        return this.mapper.update(product);
    }

    @Override
    public int delete(int id) {
        return this.mapper.delete(id);
    }
}
