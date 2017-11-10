package com.devforbest.movieapp.network;


import com.devforbest.movieapp.network.responses.ResponseMovieDetail;
import com.devforbest.movieapp.network.responses.ResponsePopularMovies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface Service {

    @GET("{movie_id}")
    Call<ResponseMovieDetail> movieDetail(@Path("movie_id") int movieId, @Query("api_key") String apiKey);

    //getTareas
    @GET("popular")
    Call<ResponsePopularMovies> getPopularMovies(@Query("api_key") String apiKey);

}