package com.DSI32G4.MyLab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

//Adapter pour le RecyclerView du fragment Informations
public class RecyclerAdapterInformations extends RecyclerView.Adapter<RecyclerAdapterInformations.ViewHolder> {
    public String getTitles() {
        return titles[0];
    }

    public int[] getImages() {
        return images;
    }

    private String[] titles = {

            "info 1",
            "info 2",
            "info 3",
            "info 4"
    };


    private int[] images = {R.drawable.actuality001,
            R.drawable.actuality002,
            R.drawable.actuality003,
            R.drawable.actuality004};

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemTitle.setText(titles[position]);
        holder.itemImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImage;
        private TextView itemTitle;

        private ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_title);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Snackbar.make(v, titles[position],
                            Snackbar.LENGTH_LONG).show();
                }
            });
        }
    }
}