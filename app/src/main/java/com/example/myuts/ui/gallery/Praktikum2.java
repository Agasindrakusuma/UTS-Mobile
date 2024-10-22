package com.example.myuts.ui.gallery;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myuts.R;

public class Praktikum2 extends Fragment implements View.OnClickListener {
    private EditText edtwidht, edtHeight, edtLenght;
    private Button btnCalculate;
    private TextView tvResult;

    private  static final String STATE_RESULT ="state_result";

    @SuppressLint("MissingInflatedId")
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_praktikum2, container, false);

        // Inisialisasi View di sini
        edtwidht = view.findViewById(R.id.edt_width);
        edtHeight = view.findViewById(R.id.edt_height);
        edtLenght = view.findViewById(R.id.edt_length);
        btnCalculate = view.findViewById(R.id.btn_calculate);
        tvResult = view.findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(this);

        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }

    public void onClick (View v) {
        if (v.getId()== R.id.btn_calculate){
            String inputLenght = edtLenght.getText().toString().trim();
            String inputWight = edtwidht.getText().toString().trim();
            String inputHeight = edtHeight.getText().toString().trim();

            boolean isEmptyFields = false ;

            if (TextUtils.isEmpty(inputLenght)){
                isEmptyFields = true;
                edtLenght.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputWight)){ // Perbaikan: Memeriksa inputWight
                isEmptyFields = true;
                edtwidht.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputHeight)){
                isEmptyFields = true;
                edtHeight.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                Double volume = Double.parseDouble(inputLenght) * Double.parseDouble(inputWight) * Double.parseDouble(inputHeight);
                tvResult.setText(String.valueOf(volume));
            }
        }
    }

}