package com.devforbest.movieapp.network;

import android.os.AsyncTask;

import com.devforbest.movieapp.BuildConfig;
import com.devforbest.movieapp.network.responses.ResponseMovieDetail;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AsynTaskCallMovie extends AsyncTask<Void, Void, Void> {
    public CallBackMovie delegate = null;
    private int id;

    public AsynTaskCallMovie(int id) {
        this.id = id;
    }


    @Override
    protected Void doInBackground(Void... voids) {
        Service api = ApiPro.createService(Service.class);
        api.movieDetail(id, BuildConfig.API_KEY)
                .enqueue(new Callback<ResponseMovieDetail>() {
                    @Override
                    public void onResponse(Call<ResponseMovieDetail> call, Response<ResponseMovieDetail> response) {
                        delegate.onFinishCallUpdateOK(response.body());

                    }

                    @Override
                    public void onFailure(Call<ResponseMovieDetail> call, Throwable t) {
                        delegate.onErrorCallUpdateReport(t.getLocalizedMessage());
                    }
                });

        return null;
    }

    public interface CallBackMovie {
        void onErrorCallUpdateReport(String err);

        void onFinishCallUpdateOK(ResponseMovieDetail res);
    }

}

