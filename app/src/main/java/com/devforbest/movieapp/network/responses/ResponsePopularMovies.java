package com.devforbest.movieapp.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by daniel on 09/11/2017.
 */

public class ResponsePopularMovies {
    @SerializedName("page")
    private int page;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("results")
    private ArrayList<ResponseMovie> movies;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public ArrayList<ResponseMovie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<ResponseMovie> movies) {
        this.movies = movies;
    }
}
