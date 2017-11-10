package com.devforbest.movieapp.views;

import android.content.Intent;
import android.view.View;

/**
 * Created by daniel on 09/11/2017.
 */

public class HandlerEvent {
    public void goDetail(View view, int movieId) {
        Intent intent = new Intent(view.getContext(), DetailActivity.class);
        intent.putExtra(DetailActivity.MOVIE_ID, movieId);

        view.getContext().startActivity(intent);


    }


}
