package com.example.myuts.ui.gallery;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.myuts.R;

public class ProfileActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile_activity);

        ImageView profileImage = findViewById(R.id.profile_image);

        // Menggunakan Glide dengan circleCrop untuk membuat gambar bulat
        Glide.with(this)
                .load("https://www.example.com/agas.jpg") // Ganti dengan URL yang benar
                .circleCrop()
                .placeholder(R.drawable.agas2) // Tambahkan gambar sementara
                .into(profileImage);
    }
}
