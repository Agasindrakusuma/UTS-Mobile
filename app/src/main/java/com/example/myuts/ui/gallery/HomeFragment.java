package com.example.myuts.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myuts.R;

public class HomeFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnCategory = view.findViewById(R.id.btn_category);
        // Pastikan ID inisesuai dengan ID tombol di layout XML Anda

        if (btnCategory != null) { // Tambahkan pengecekan null untuk menghindari NullPointerException
            btnCategory.setOnClickListener(this);
        } else {
            // Tangani kasus di mana tombol tidak ditemukan, misalnya dengan menampilkan pesan error
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_category) { // Pastikan ID ini sesuai dengan ID tombol di layout XML Anda
            CategoryFragment mCategoryFragment = new CategoryFragment();
            FragmentManager mFragmentManager = getParentFragmentManager();
            if (mFragmentManager != null) { // Tambahkan pengecekan null untuk FragmentManager
                mFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, mCategoryFragment, CategoryFragment.class.getSimpleName())
                        // Pastikan ID frame_container sesuai dengan layout di Activity Anda
                        .addToBackStack(null)
                        .commit();
            } else {
                // Tangani kasus di mana FragmentManager tidak tersedia, misalnya dengan menampilkan pesan error
            }
        }
    }
}