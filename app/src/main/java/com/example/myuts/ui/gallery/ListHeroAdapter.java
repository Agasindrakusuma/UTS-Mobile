package com.example.myuts.ui.gallery;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myuts.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.ListViewHolder> {

    private ArrayList<Hero> listHero;

    // Constructor untuk menerima data list
    public ListHeroAdapter(ArrayList<Hero> list) {
        this.listHero = list;
    }

    // Membuat dan mengembalikan ViewHolder
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_hero, parent, false); // Ganti dengan layout item
        return new ListViewHolder(view);
    }

    // Mengisi data pada item View
    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Hero hero = listHero.get(position);
        holder.imgPhoto.setImageResource(hero.getPhoto());
        holder.tvName.setText(hero.getName());
        holder.tvDescription.setText(hero.getDescription());
        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(holder.itemView.getContext(), "Kamu memilih "
                            + listHero.get(holder.getAdapterPosition()).getName(),
                    Toast.LENGTH_SHORT).show();
        });
    }

    // Mengembalikan jumlah item dalam list
    @Override
    public int getItemCount() {
        return listHero.size();
    }

    // ViewHolder untuk item data
    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDescription;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }
}
