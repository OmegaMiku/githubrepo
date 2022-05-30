package com.geekbrains;

import com.geekbrains.db.dao.ProductsMapper;
import com.geekbrains.db.model.Products;
import com.geekbrains.db.model.ProductsExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

public class MyBatisExample {

    public static void main(String[] args) throws IOException {

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("myBatisConfig.xml"));

        try (SqlSession session = sessionFactory.openSession()) {
            ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
            Products product = productsMapper.selectByPrimaryKey(448L);
            System.out.println(product);

            ProductsExample example = new ProductsExample();
            example.createCriteria()
                    .andTitleLike("Pizza")
                    .andPriceGreaterThan(7);

            List<Products> products = productsMapper.selectByExample(example);
            System.out.println(products);

            example.clear();
            example.createCriteria()
                    .andCategoryIdEqualTo(1L);

            products = productsMapper.selectByExample(example);
            System.out.println(products);

            productsMapper.deleteByPrimaryKey(448L);
            example.clear();

            example.createCriteria()
                    .andTitleLike("Pizza")
                    .andPriceGreaterThan(7);

            products = productsMapper.selectByExample(example);
            System.out.println(products);
        }


    }

}
