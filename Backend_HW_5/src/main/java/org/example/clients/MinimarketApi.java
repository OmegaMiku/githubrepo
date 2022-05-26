package org.example.clients;

import retrofit2.Call;
import retrofit2.http.*;

import java.awt.*;

public class MinimarketApi {

    @GET("products")
    Call<List<Product>> getProducts();

    @GET("products/{id}")
    Call<Product> getProduct(@Path("id") Long id);

    @POST("products")
    Call<Product> postProduct(@Body Product product);

    @PUT("products")
    Call<Product> putProduct(@Body Product product);

    @DELETE("products/{id}")
    Call<Product> deleteProduct(@Path("id") Long id);

}
