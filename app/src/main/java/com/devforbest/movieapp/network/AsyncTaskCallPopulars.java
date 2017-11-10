package com.devforbest.movieapp.network;

import android.os.AsyncTask;

import com.devforbest.movieapp.BuildConfig;
import com.devforbest.movieapp.network.responses.ResponsePopularMovies;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AsyncTaskCallPopulars extends AsyncTask<Void, Void, Void> {
    public CallBackPopulars delegate = null;

    public AsyncTaskCallPopulars() {
    }


    @Override
    protected Void doInBackground(Void... voids) {
        Service api = ApiPro.createService(Service.class);
        api.getPopularMovies(BuildConfig.API_KEY)
                .enqueue(new Callback<ResponsePopularMovies>() {
                    @Override
                    public void onResponse(Call<ResponsePopularMovies> call, Response<ResponsePopularMovies> response) {
                        delegate.onFinishCallUpdateOK(response.body());

                    }

                    @Override
                    public void onFailure(Call<ResponsePopularMovies> call, Throwable t) {
                        delegate.onErrorCallUpdateReport(t.getLocalizedMessage());
                    }
                });

        return null;
    }

    public interface CallBackPopulars {
        void onErrorCallUpdateReport(String err);

        void onFinishCallUpdateOK(ResponsePopularMovies res);
    }

}

