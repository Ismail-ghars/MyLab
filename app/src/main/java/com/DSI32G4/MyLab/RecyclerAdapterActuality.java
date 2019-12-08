package com.DSI32G4.MyLab;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

//Adapteur pour le recycler View de fragment Actualité
public class RecyclerAdapterActuality extends RecyclerView.Adapter<RecyclerAdapterActuality.ViewHolder> {
    public String getTitles() {
        return titles[0];
    }

    public int[] getImages() {
        return images;
    }

    private String[] titles = {"Révolutionner l'accès aux soins grâce au numérique",
            "Sit in du cadre médical et paramédical",
            "Un nouvel exploit médical en Tunisie",
            "Il existe un trafic de dossiers médicaux des patients ..."};
    public String[] description = {
            "DERNIERE ACTUALITE:DERNIERE ACTUALITE:DERNIERE ACTUALITE:DERNIERE ACTUALITE:DERNIERE ACTUALITE:DERNIERE ACTUALITE:DERNIERE ACTUALITE:DERNIERE ACTUALITE:DERNIERE ACTUALITE:",
            "DERNIER CENTRE AJOUTE:",
            "DERNIER RESULTAT D'ANALYSE:",
            "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"
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
                    Snackbar snackbar;
                    snackbar = Snackbar.make(v, description[position], Snackbar.LENGTH_SHORT);
                    View snackBarView = snackbar.getView();
                    snackBarView.setBackgroundColor(Color.RED);
                    TextView textView = (TextView) snackBarView.findViewById(R.id.snackbar_text);
                    textView.setTextColor(Color.WHITE);
                    snackbar.show();


                }
            });
        }
    }
}