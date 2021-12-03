package com.example.wsr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class filmsAdapter extends RecyclerView.Adapter<filmsAdapter.ViewHolder>{
    private final LayoutInflater inflater;
    private final List<String> urls;


    public filmsAdapter(LayoutInflater inflater, List<String> urls) {
        this.inflater = inflater;
        this.urls = urls;
    }

    @Override
    public filmsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.films, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(filmsAdapter.ViewHolder holder, int position) {
        String url = urls.get(position);
        Picasso.get().load(url).placeholder(R.drawable.icon).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        ViewHolder(View view){
            super(view);
            imageView = view.findViewById(R.id.imageView4);
        }
    }
}
