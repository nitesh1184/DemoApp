package com.example.demo_application.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo_application.R;
import com.example.demo_application.databinding.ItemsBinding;
import com.example.demo_application.model.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.EmployeeViewHolder> {

    private List<MovieModel> movies;

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemsBinding movieListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.items, viewGroup, false);
        return new EmployeeViewHolder(movieListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder employeeViewHolder, int i) {
        MovieModel currentMovie = movies.get(i);
        employeeViewHolder.movieListItemBinding.setMovie(currentMovie);
    }

    @Override
    public int getItemCount() {
        if (movies != null) {
            return movies.size();
        } else {
            return 0;
        }
    }

    public void setMovieList(List<MovieModel> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        private ItemsBinding movieListItemBinding;

        public EmployeeViewHolder(@NonNull ItemsBinding movieListItemBinding) {
            super(movieListItemBinding.getRoot());

            this.movieListItemBinding = movieListItemBinding;
        }
    }

}
