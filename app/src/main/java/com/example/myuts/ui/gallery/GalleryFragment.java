package com.example.myuts.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myuts.R;
import com.example.myuts.databinding.FragmentGalleryBinding;

    public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Tidak perlu lagi menggunakan ViewModel atau TextView lama

        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}