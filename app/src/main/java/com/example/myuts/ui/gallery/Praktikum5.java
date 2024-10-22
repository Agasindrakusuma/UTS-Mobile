package com.example.myuts.ui.gallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.myuts.R; // Pastikan Anda mengimpor layout yang benar

public class Praktikum5 extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate layout untuk fragmen
        View view = inflater.inflate(R.layout.fragment_praktikum5, container, false);

        // Dapatkan FragmentManager dari activity
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();

        // Periksa apakah HomeFragment sudah ada
        Fragment fragment = fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());

        if (!(fragment instanceof HomeFragment)) {
            Log.d("myFlexibleFragment", "Fragment name :" + HomeFragment.class.getSimpleName());

            // Tambahkan HomeFragment jika belum ada
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container, new HomeFragment(), HomeFragment.class.getSimpleName()) // Pastikan ID frame_container benar
                    .commit();
        }

        return view;
    }}