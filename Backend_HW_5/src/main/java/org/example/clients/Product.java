package org.example.clients;

import lombok.Data;

@Data
public class Product {

    private Long id;
    private String title;
    private Integer price;
    private String categoryTitle;

}
