package com.example.myuts.ui.gallery;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myuts.R;
import com.example.myuts.ui.gallery.Hero; // Pastikan Anda mengimport class Hero
import com.example.myuts.ui.gallery.ListHeroAdapter; // Pastikan Anda mengimport class ListHeroAdapter

import com.example.myuts.databinding.FragmentPraktikum62Binding;

import java.util.ArrayList;

public class praktikum6_2 extends Fragment {

    private FragmentPraktikum62Binding binding;
    private RecyclerView rvHeroes; // Deklarasi rvHeroes
    private ArrayList<Hero> list = new ArrayList<>(); // Deklarasi dan inisialisasi list

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPraktikum62Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        rvHeroes = root.findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true);
        list.addAll(getListHeroes()); // Ambil data hero terlebih dahulu

        showRecyclerList(); // Panggil showRecyclerList() setelah data hero diambil

        return root;
    }

    // Metode getListHeroes() (adaptasi dari MainActivity)
    public ArrayList<Hero> getListHeroes() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[]dataDescription = getResources().getStringArray(R.array.data_description);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);

        ArrayList<Hero> listHero = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Hero hero = new Hero();
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            listHero.add(hero);
        }

        dataPhoto.recycle(); // Jangan lupa untuk recycle TypedArray
        return listHero;
    }

    private void showRecyclerList() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(getActivity()));
        ListHeroAdapter listHeroAdapter = new ListHeroAdapter(list);
        rvHeroes.setAdapter(listHeroAdapter); // Panggil setAdapter() di sini
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}