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


public class RecyclerAdapterAccueil extends RecyclerView.Adapter<RecyclerAdapterAccueil.ViewHolder> {
    RecyclerAdapterActuality act=new RecyclerAdapterActuality();
    RecyclerAdapterInformations info=new RecyclerAdapterInformations();
    private String[] titles = {

            act.getTitles() ,
            info.getTitles() ,
            "info 3",

    };
    public String[] titres = {
            "DERNIERE ACTUALITE:",
            "DERNIER CENTRE AJOUTE:",
            "DERNIER RESULTAT D'ANALYSE:",
    };
    public String[] description = {
            "DERNIERE ACTUALITE:DERNIERE ACTUALITE:DERNIERE ACTUALITE:DERNIERE ACTUALITE:\n\n\nDERNIERE ACTUALITE:DERNIERE ACTUALITE:DERNIERE ACTUALITE:DERNIERE ACTUALITE:DERNIERE ACTUALITE:",
            "DERNIER CENTRE AJOUTE:",
            "DERNIER RESULTAT D'ANALYSE:",
    };
    private int[] images = {R.drawable.actuality001,
            R.drawable.actuality002,
            R.drawable.actuality003,
           };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_list_item_accueil, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemTitle.setText(titles[position]);
        holder.itemImage.setImageResource(images[position]);
        holder.itemTitre.setText(titres[position]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImage;
        private TextView itemTitle;
        private TextView itemTitre;

        private ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image_accueil);
            itemTitle = itemView.findViewById(R.id.item_title_accueil);
            itemTitre = itemView.findViewById(R.id.titre);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Snackbar snackbar;
                    snackbar = Snackbar.make(v, description[position], Snackbar.LENGTH_SHORT);
                    View snackBarView = snackbar.getView();
                    snackBarView.setBackgroundColor(Color.rgb(63,37,130));
                    TextView textView = (TextView) snackBarView.findViewById(R.id.snackbar_text);
                    textView.setTextColor(Color.WHITE);
                    snackbar.setDuration(8000);
                    snackbar.show();

                }
            });
        }
    }
}