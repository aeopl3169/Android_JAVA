package com.shiva.a8postrequestretrofit;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JSONHolderInterface {

    @POST("posts")
    Call<PostClass> createPost1(@Body PostClass postClass);

    @FormUrlEncoded
    @POST("posts")
    Call<PostClass> createPost2(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String text
    );

    // java.lang.IllegalArgumentException: @FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).
    @FormUrlEncoded
    @POST("posts")
    Call<PostClass> createPost3(@FieldMap Map<String, String> fields); //java.lang.IllegalArgumentException: @FieldMap parameters can only be used with form encoding. (parameter #1)

    @GET("posts")
    Call<List<PostClass>> createPost4();

    // Doesn't work
    @FormUrlEncoded
    @POST("posts")
    Call<List<PostClass>> createPost5(@FieldMap Map<String, String> fields);
}
