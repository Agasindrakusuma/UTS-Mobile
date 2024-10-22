package com.example.myuts.ui.gallery;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.myuts.R;

public class Praktikum3_4 extends Fragment implements View.OnClickListener {
    private TextView tvResult;
    final ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == MoveForResultActivity.RESULT_CODE && result.getData() != null) {
                    int selectedValue = result.getData().getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                    tvResult.setText(String.format("Hasil : %s", selectedValue));
                }
            });

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_praktikum3_4, container, false);

        // Inisialisasi View di sini
        View layout = view.findViewById(R.id.background);
        layout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.agas)); // Perbaikan

        Button btnMoveActivity = view.findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        Button btnMoveActivityData = view.findViewById(R.id.btn_move_activity_data);
        btnMoveActivityData.setOnClickListener(this);

        Button btnDialPhone = view.findViewById(R.id.btn_dial_number);
        btnDialPhone.setOnClickListener(this);

        Button btnMoveforResult = view.findViewById(R.id.btn_move_for_result);
        btnMoveforResult.setOnClickListener(this);

        tvResult = view.findViewById(R.id.tv_result);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // ...
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_move_activity) {
            Intent moveIntent = new Intent(requireActivity(), MoveActivity.class); // Perbaikan
            startActivity(moveIntent);
        } else if (view.getId() == R.id.btn_move_activity_data) {
            Intent moveWithDataIntent = new Intent(requireActivity(), MoveWithDataActivity.class); // Perbaikan
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_KULIAH, "PEMROGRAMAN MOBILE");
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_KELAS, 5);
            startActivity(moveWithDataIntent);
        } else if (view.getId() == R.id.btn_dial_number) {
            String phoneNumber = "089627351078";
            Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
            startActivity(dialPhoneIntent);
        } else if (view.getId() == R.id.btn_move_for_result){
            Intent moveForResultIntent = new Intent(requireActivity(), MoveForResultActivity.class); // Perbaikan
            resultLauncher.launch(moveForResultIntent);
        }
    }
}