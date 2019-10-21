package com.fancyliu.springcloud.demo.provider.dao;

import com.fancyliu.springcloud.demo.provider.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 类描述:
 * 商品 Mapper
 *
 * @author : Liu Fan
 * @date : 2019/10/21 11:24
 */
@Mapper
public interface ProductMapper {

    Product find(@Param("id") int id);

    List<Product> list();

    int insert(@Param("entity") Product product);

    int update(@Param("entity") Product product);

    int delete(@Param("id") int id);

}
