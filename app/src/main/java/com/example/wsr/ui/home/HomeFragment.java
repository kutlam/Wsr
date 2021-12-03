package com.example.wsr.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wsr.DBhelper;
import com.example.wsr.FilmInfo;
import com.example.wsr.R;
import com.example.wsr.databinding.FragmentHomeBinding;
import com.example.wsr.filmsAdapter;
import com.squareup.picasso.Picasso;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        DBhelper.ForU();
        DBhelper.News();
        DBhelper.Trends();


        Picasso.get().load("http://cinema.areas.su/up/images/magicians.png").placeholder(R.drawable.icon).fit ().into(binding.imageView6);

        RecyclerView recyclerViewTrend = binding.scroll.findViewById(R.id.trend);
        filmsAdapter adapterTrend = new filmsAdapter(getLayoutInflater(),DBhelper.Trend);
        recyclerViewTrend.setAdapter(adapterTrend);

        RecyclerView recyclerViewNew = binding.scroll.findViewById(R.id.rec);
        filmsAdapter adapterNew = new filmsAdapter(getLayoutInflater(), DBhelper.New);
        recyclerViewNew.setAdapter(adapterNew);

        RecyclerView recyclerViewForyou = binding.scroll.findViewById(R.id.forYou);
        filmsAdapter adapterForyou = new filmsAdapter(getLayoutInflater(), DBhelper.ForYou);
        recyclerViewForyou.setAdapter(adapterForyou);

        binding.editTextTextPersonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( getContext (), FilmInfo.class);
                startActivity (intent);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}