package com.shiva.a6getreadrequestretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET("posts")
    Call<List<PostGettors>> getPost();
}
