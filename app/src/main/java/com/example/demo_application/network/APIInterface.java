package com.example.demo_application.network;

import com.example.demo_application.model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("/course-apis/recyclerview/movies")

    Call<List<MovieModel>> getMovieList();

}
