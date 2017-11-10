package com.devforbest.movieapp.views;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devforbest.movieapp.R;
import com.devforbest.movieapp.databinding.ItemMainBinding;
import com.devforbest.movieapp.network.responses.ResponseMovie;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by daniel on 09/11/2017.
 */

class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MainViewHolder> {
    private ArrayList<Integer> favs = new ArrayList<>();
    private ArrayList<ResponseMovie> movies;

    public MoviesAdapter(ArrayList<ResponseMovie> movies, ArrayList<Integer> favs) {
        this.movies = movies;
        this.favs = favs;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemMainBinding binding = ItemMainBinding.inflate(layoutInflater, parent, false);
        return new MainViewHolder(binding.getRoot(), binding, favs);

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.bind(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        private final ArrayList<Integer> favs;
        private ItemMainBinding binding;

        public MainViewHolder(View parent, ItemMainBinding binding, ArrayList<Integer> favs) {
            super(parent);
            this.binding = binding;
            if (favs == null) this.favs = new ArrayList<Integer>();
            else
                this.favs = favs;
        }

        public void bind(ResponseMovie item) {
            binding.setMovie(item);
            final int id = item.getId();
            Picasso.with(binding.getRoot().getContext()).load("https://image.tmdb.org/t/p/w500" + item.getBackdropPath()).fit().into(binding.back);
            HandlerEvent handlers = new HandlerEvent();
            binding.setHandlers(handlers);
            if (favs.contains(movies.get(getAdapterPosition()).getId()))
                binding.fab.setImageResource(R.drawable.ic_favorite_black_48dp);

            binding.fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    favorite(view, id);
                }
            });
            binding.executePendingBindings();
        }

        public void favorite(View view, int movieId) {
            Intent intent = new Intent(view.getContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.MOVIE_ID, movieId);
            if (!favs.contains(movieId)) {
                favs.add(movieId);
                binding.fab.setImageResource(R.drawable.ic_favorite_black_48dp);
                ((MainActivity) (view.getContext())).getEditor().putString(view.getContext().getString(R.string.shaved_favs), new Gson().toJson(favs)).commit();

            } else {
                favs.remove(favs.indexOf(movieId));
                binding.fab.setImageResource(R.drawable.ic_favorite_border_black_48dp);

            }

        }


    }
}
