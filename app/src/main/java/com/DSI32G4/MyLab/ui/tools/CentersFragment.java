package com.DSI32G4.MyLab.ui.tools;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.DSI32G4.MyLab.R;

import java.util.ArrayList;
import java.util.List;


//Classe du fragment pour afficher les différents centres
public class CentersFragment extends Fragment {

    String[] titles;
    TypedArray pins;
    String[] locals;
    String[] cbll;

    List<RowItem> rowItems;
    ListView listView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_centers,container,false);

        rowItems = new ArrayList<RowItem>();
        titles = getResources().getStringArray(R.array.Titles);
        pins = getResources().obtainTypedArray(R.array.pins);
        locals = getResources().getStringArray(R.array.locals);
        cbll = getResources().getStringArray(R.array.cbll);

        for (int i=0; i < titles.length; i++){
            RowItem item = new RowItem(titles[i],pins.getResourceId(i,-1),locals[i]);
            rowItems.add(item);
        }



        listView = view.findViewById(R.id.l);
        CustomAdapter adapter = new CustomAdapter(this.getActivity(),rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

// Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse("google.streetview:cbll="+cbll[position].toString());
                Toast.makeText(getContext(), gmmIntentUri.toString(), Toast.LENGTH_LONG).show();

// Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
// Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

// Attempt to start an activity that can handle the Intent
                startActivity(mapIntent);

            }
        });
        return view;

    }


}