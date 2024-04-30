package com.konovalov.retrofit;

import com.konovalov.retrofit.request.PostCreateRequest;
import com.konovalov.retrofit.request.PostUpdateRequest;
import com.konovalov.retrofit.response.PostResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface JsonPlaceholderApi {

    @GET("/posts")
    Call<List<PostResponse>> posts(@Query("userId") Integer userId);

    @POST("/posts")
    Call<PostResponse> create(@Body PostCreateRequest request);

    @PUT("/posts/{id}")
    Call<PostResponse> update(@Path("id") Integer id, @Body PostUpdateRequest request);

    @DELETE("/posts/{id}")
    Call<Void> delete(@Path("id") Integer id);

}
