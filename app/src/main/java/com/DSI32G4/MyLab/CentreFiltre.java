package com.DSI32G4.MyLab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CentreFiltre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centre_filtre);

        Toolbar bar = (Toolbar) findViewById(R.id.bar);
        bar.setTitle("Filter");
        setSupportActionBar(bar);

        Spinner ouverture = findViewById(R.id.ouv);
        Spinner fermeture = findViewById(R.id.fer);

       final Integer[] itemsOuv = new Integer[]{8,9,10,11};
       final Integer[] itemsFer = new Integer[]{4,5,6,7};

        ArrayAdapter<Integer> adapterOuv = new ArrayAdapter<Integer>(CentreFiltre.this, android.R.layout.simple_spinner_item,itemsOuv);
        ArrayAdapter<Integer> adapterFer = new ArrayAdapter<Integer> (CentreFiltre.this, android.R.layout.simple_spinner_item,itemsFer);
        ouverture.setAdapter(adapterOuv);
        fermeture.setAdapter(adapterFer);

    }
}
