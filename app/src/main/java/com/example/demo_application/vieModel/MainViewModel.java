package com.example.demo_application.vieModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.demo_application.model.MovieModel;
import com.example.demo_application.repository.MovieRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private MovieRepository movieRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        movieRepository = new MovieRepository();
    }

    public LiveData<List<MovieModel>> getAllEmployee() {
        return movieRepository.getMutableLiveData();
    }
}
