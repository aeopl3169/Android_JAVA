package com.shiva.a10loghttprequestjson;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface JsonHolderInterface {
    @PUT("posts/{id}")
    Call<PostClass> putPost(@Path("id") int id, @Body PostClass post);
}
