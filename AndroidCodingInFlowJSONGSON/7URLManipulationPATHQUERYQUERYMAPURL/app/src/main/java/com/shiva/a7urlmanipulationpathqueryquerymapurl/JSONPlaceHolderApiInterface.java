package com.shiva.a7urlmanipulationpathqueryquerymapurl;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JSONPlaceHolderApiInterface {
    @GET("posts/2/comments")
    Call<List<CommentsGetters>> getComments();

    @GET("posts/{id}/comments")
    Call<List<CommentsGetters>> getComments(@Path("id") int postId);

    @GET
    Call<List<CommentsGetters>> getComments(@Url String url);

    @GET("posts")
    Call<List<PostsGettors>> getPosts();

    @GET("posts")
    Call<List<PostsGettors>> getPosts(
            @Query("userId") int userI,
            @Query("userId") Integer userId,
            @Query("_sort") String sor,
            @Query("_order") String orde
    );

    @GET("posts")
    Call<List<PostsGettors>> getPosts(
            @Query("userId") Integer[] userIdValue,
            @Query("_sort") String sortKey,
            @Query("_order") String orderOfSorting
    );

    @GET("posts")
    Call<List<PostsGettors>> getPosts(@QueryMap Map<String , String> parameters);
}
