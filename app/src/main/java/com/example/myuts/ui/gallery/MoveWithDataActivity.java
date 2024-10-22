package com.example.myuts.ui.gallery;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myuts.R;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class MoveWithDataActivity extends AppCompatActivity {
    public static final String EXTRA_KELAS = "extra_kelas";
    public static final String EXTRA_KULIAH = "extra_kuliah";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_move_with_data_activity);

        TextView tvDataReceived = findViewById(R.id.tv_data_received);

        String kuliah = getIntent().getStringExtra(EXTRA_KULIAH);
        int kelas = getIntent().getIntExtra(EXTRA_KELAS, 0);
        String text = "Mata Kuliah :" + kuliah + ",Kelas ;" + kelas;
        tvDataReceived.setText(text);
    }
}

