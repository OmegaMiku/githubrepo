package org.example;

import org.example.clients.MinimarketService;
import org.example.clients.Product;

public class Main {

    public static void main(String[] args) {
        MinimarketService minimarketService = new MinimarketService();
        System.out.println(minimarketService.getProduct(7));

        Product product = new Product();
        product.setTitle("Pizza");
        product.setPrice(100);
        product.setCategoryTitle("Food");

        Product createdProduct = minimarketService.createProduct(product);
        System.out.println(createdProduct);

        Product product = new Product();
        product.setTitle("Pizza");
        product.setPrice(70);
        product.setCategoryTitle("Food");

        Product modifiedProduct = minimarketService.modifyProduct(product);
        System.out.println(modifiedProduct);

        MinimarketService minimarketService = new MinimarketService();
        System.out.println(minimarketService.deleteProduct(448));





    }

}
