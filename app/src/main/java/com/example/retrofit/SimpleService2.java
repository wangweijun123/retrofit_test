package com.example.retrofit;

import android.util.Log;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by wangweijun1 on 2017/4/9.
 */

public class SimpleService2 {
    public static final String API_URL = "https://api.github.com";

    public interface GitHub {
        // https://api.github.com/repos/square/retrofit/contributors
        @GET("/repos/{owner}/{repo}/contributors")
        Call<String> contributors(
                @Path("owner") String owner,
                @Path("repo") String repo);
    }


    public static class Contributor {
        public  String login;
        public  int contributions;
    }

    public static void syncRequestString() throws IOException {
        // Create a very simple REST adapter which points the GitHub API.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .build();

        // Create an instance of our GitHub API interface.
        GitHub github = retrofit.create(GitHub.class);

        // Create a call instance for looking up Retrofit contributors.
        Call<String> call = github.contributors("square", "retrofit");

        // Fetch and print a list of the contributors to the library.
        String contributors = call.execute().body();
        Log.i("wang",  "contributors:" + contributors);
    }

}
