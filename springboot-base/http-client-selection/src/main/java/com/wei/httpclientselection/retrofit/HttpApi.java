package com.wei.httpclientselection.retrofit;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import retrofit2.http.GET;
import retrofit2.http.Query;

@RetrofitClient(baseUrl = "http://127.0.0.1:81")
public interface HttpApi {

    @GET("echo")
    String getPerson(@Query("name") String name);
}