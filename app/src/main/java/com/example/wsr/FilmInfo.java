package com.example.wsr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class FilmInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_info);
        getSupportActionBar().hide();

        RecyclerView recyclerView = findViewById(R.id.recyclerView1);
        filmsAdapter adapter = new filmsAdapter(getLayoutInflater(), DBhelper.New);
        recyclerView.setAdapter(adapter);
        Picasso.get().load("http://cinema.areas.su/up/images/magicians.png").placeholder(R.drawable.icon).fit().into((ImageView)findViewById(R.id.imageView));
    }
}