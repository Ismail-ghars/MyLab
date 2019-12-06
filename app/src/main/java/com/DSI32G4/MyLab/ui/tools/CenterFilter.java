package com.DSI32G4.MyLab.ui.tools;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.DSI32G4.MyLab.R;

public class CenterFilter extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centre_filter);

        Spinner ouv =findViewById(R.id.ouv);
        Spinner fer =findViewById(R.id.fer);

        final String[] itemsOuv = new String[]{"08:00","09:00","10:00","11:00"};
        final String[] itemsFer = new String[]{"16:00","17:00","18:00"};

        ArrayAdapter<String> adapterOuv = new ArrayAdapter<String>(CenterFilter.this, android.R.layout.simple_spinner_item,itemsOuv);
        ArrayAdapter<String> adapterFer = new ArrayAdapter<String> (CenterFilter.this, android.R.layout.simple_spinner_item,itemsFer);
        ouv.setAdapter(adapterOuv);
        fer.setAdapter(adapterFer);



    }

}
