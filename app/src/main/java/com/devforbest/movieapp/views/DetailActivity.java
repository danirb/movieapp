package com.devforbest.movieapp.views;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.devforbest.movieapp.R;
import com.devforbest.movieapp.databinding.ActivityDetailBinding;
import com.devforbest.movieapp.network.AsynTaskCallMovie;
import com.devforbest.movieapp.network.responses.ResponseMovieDetail;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    public static final String MOVIE_ID = "movieID";
    private ActivityDetailBinding binding;
    private Context mContext;
    private ArrayList<Integer> favs;
    private SharedPreferences sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setTitle("");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        Bundle extras = getIntent().getExtras();
        final int idMovie = extras.getInt(MOVIE_ID);

        sharedPrefs = getSharedPreferences(getString(R.string.shared_prefs), Context.MODE_PRIVATE);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getFavoritesFromSP();
        setViews(idMovie);

        getData(idMovie);
    }

    private void getData(int idMovie) {
        AsynTaskCallMovie call = new AsynTaskCallMovie(idMovie);
        call.delegate = new AsynTaskCallMovie.CallBackMovie() {
            @Override
            public void onErrorCallUpdateReport(String err) {
                Toast.makeText(mContext, err, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFinishCallUpdateOK(ResponseMovieDetail res) {
                binding.setData(res);
                Picasso.with(mContext).load("https://image.tmdb.org/t/p/w500" + res.getBackdropPath()).fit().into(binding.back);
                Picasso.with(mContext).load("https://image.tmdb.org/t/p/w500" + res.getPosterPath()).into(binding.poster);
                setTitle(res.getTitle());
                binding.executePendingBindings();
            }
        };

        call.execute();
    }

    private void setViews(final int idMovie) {
        if (favs.contains(idMovie))
            binding.fab.setImageResource(R.drawable.ic_favorite_black_48dp);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!favs.contains(idMovie)) {
                    favs.add(idMovie);
                    binding.fab.setImageResource(R.drawable.ic_favorite_black_48dp);
                    sharedPrefs.edit().putString(view.getContext().getString(R.string.shaved_favs), new Gson().toJson(favs)).commit();

                } else {
                    favs.remove(favs.indexOf(idMovie));
                    binding.fab.setImageResource(R.drawable.ic_favorite_border_black_48dp);

                }
            }
        });
    }

    private void getFavoritesFromSP() {
        favs = new ArrayList<Integer>();
        Gson g = new Gson();
        String s = sharedPrefs.getString(getString(R.string.shaved_favs), "");
        Log.d("DRB", s);
        if (!s.equals("")) {
            Type type = new TypeToken<ArrayList<Integer>>() {
            }.getType();
            favs = g.fromJson(s, type);
        }
    }

}
