package com.example.demo_application.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.demo_application.model.MovieModel;
import com.example.demo_application.network.APIInterface;
import com.example.demo_application.network.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieRepository {

    private static final String TAG = "MovieRepository";
    private List<MovieModel> movies = new ArrayList<>();
    private MutableLiveData<List<MovieModel>> mutableLiveData = new MutableLiveData<>();

    public MovieRepository() {
    }

    public MutableLiveData<List<MovieModel>> getMutableLiveData() {

        final APIInterface userDataService = ApiClient.getService();

        Call<List<MovieModel>> call = userDataService.getMovieList();
        call.enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
                List<MovieModel> movieListResponse = response.body();
                if (movieListResponse != null) {
                    movies = movieListResponse;
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<List<MovieModel>> call, Throwable t) {
                Log.e(TAG, "onFailure: failed to fetch data", t);
            }
        });

        return mutableLiveData;
    }
}
