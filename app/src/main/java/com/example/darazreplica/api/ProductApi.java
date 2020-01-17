package com.example.darazreplica.api;

import com.example.darazreplica.model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductApi {
    @GET("product/list")
    Call<List<Item>> getProduct();
}
