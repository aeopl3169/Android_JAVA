package com.shiva.a9putpatchdeleteretrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.PATCH;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface JsonHolderInterface {
    @PUT("posts/{id}")
    Call<PostClass> putPost(@Path("id") int id, @Body PostClass post);

    @PATCH("posts/{id}")
    Call<PostClass> patchPost(@Path("id") int id, @Body PostClass post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);
}
