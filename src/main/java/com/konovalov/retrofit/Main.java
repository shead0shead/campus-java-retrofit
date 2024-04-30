package com.konovalov.retrofit;

import com.konovalov.retrofit.request.PostCreateRequest;
import com.konovalov.retrofit.request.PostUpdateRequest;
import com.konovalov.retrofit.response.PostResponse;
import retrofit2.Response;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Started");

        JsonPlaceholderApi api = JsonPlaceholderService.getInstance().api();

        System.out.println("GET: /posts");
        Response<List<PostResponse>> postsResponse = api.posts(null).execute();
        System.out.println(postsResponse.isSuccessful());
        System.out.println(postsResponse.headers());
        System.out.println(postsResponse.code());
        List<PostResponse> body = postsResponse.body();
        System.out.println(body);

        System.out.println("POST: /posts");
        PostCreateRequest createRequest = new PostCreateRequest();
        createRequest.setBody("Body");
        createRequest.setTitle("Title");
        createRequest.setUserId(1);
        Response<PostResponse> createResponse = api.create(createRequest).execute();
        System.out.println(createResponse.body());

        System.out.println("PUT: /posts/{id}");
        PostUpdateRequest updateRequest = new PostUpdateRequest();
        updateRequest.setBody("Body");
        updateRequest.setTitle("Title");
        updateRequest.setUserId(1);
        updateRequest.setId(1);
        Response<PostResponse> updateResponse = api.update(1, updateRequest).execute();
        System.out.println(updateResponse.body());

        System.out.println("DELETE: /posts/{id}");
        Integer statusCode = api.delete(1).execute().code();
        System.out.println(statusCode);

    }

}
