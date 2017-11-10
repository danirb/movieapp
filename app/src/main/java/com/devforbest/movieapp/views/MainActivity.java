package com.devforbest.movieapp.views;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.devforbest.movieapp.R;
import com.devforbest.movieapp.databinding.ActivityMainBinding;
import com.devforbest.movieapp.network.AsyncTaskCallPopulars;
import com.devforbest.movieapp.network.responses.ResponsePopularMovies;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AsyncTaskCallPopulars.CallBackPopulars {
    private ActivityMainBinding binding;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.recycler.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
        //TODO: extract shared to controller
        sharedPref = getSharedPreferences(getString(R.string.shared_prefs), Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        getMovies();


    }


    public SharedPreferences getSharedPref() {
        return sharedPref;
    }

    public SharedPreferences.Editor getEditor() {
        return editor;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    private void getMovies() {
        AsyncTaskCallPopulars asynTaskCall = new AsyncTaskCallPopulars();
        asynTaskCall.delegate = this;
        asynTaskCall.execute();
    }

    @Override
    public void onErrorCallUpdateReport(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFinishCallUpdateOK(ResponsePopularMovies res) {
        ArrayList<Integer> favs = new ArrayList<Integer>();
        Gson g = new Gson();
        String s = sharedPref.getString(getString(R.string.shaved_favs), "");
        Log.d("DRB", s);
        if (!s.equals("")) {
            Type type = new TypeToken<ArrayList<Integer>>() {
            }.getType();
            favs = g.fromJson(s, type);
        }
        binding.recycler.setAdapter(new MoviesAdapter(res.getMovies(), favs));

    }
}
