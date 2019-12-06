package com.DSI32G4.MyLab.ui.tools;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.DSI32G4.MyLab.R;
import com.DSI32G4.MyLab.RecyclerAdapter;
import com.DSI32G4.MyLab.RegisterActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToolsFragment extends Fragment {

    String[] titles;
    TypedArray pins;
    String[] locals;

    List<RowItem> rowItems;
    ListView listView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tools,container,false);

        rowItems = new ArrayList<RowItem>();
        titles = getResources().getStringArray(R.array.Titles);
        pins = getResources().obtainTypedArray(R.array.pins);
        locals = getResources().getStringArray(R.array.locals);

        for (int i=0; i < titles.length; i++){
            RowItem item = new RowItem(titles[i],pins.getResourceId(i,-1),locals[i]);
            rowItems.add(item);
        }




        listView = view.findViewById(R.id.l);
        CustomAdapter adapter = new CustomAdapter(this.getActivity(),rowItems);
        listView.setAdapter(adapter);





































//        listView = view.findViewById(R.id.l);
//
//        ArrayList<HashMap<String,String>> list = new ArrayList<>();
//
//        HashMap<String,String> map;
//
//
//        map = new HashMap<String, String>();
//        map.put("Titre","Centre 1");
//        map.put("Localisation","Localisation 1");
//        map.put("Pin",String.valueOf(R.drawable.pin));
//        list.add(map);
//
//        map = new HashMap<String, String>();
//        map.put("Titre","Centre 2");
//        map.put("Localisation","Localisation 2");
//        map.put("Pin",String.valueOf(R.drawable.pin));
//        list.add(map);
//
//        map = new HashMap<String, String>();
//        map.put("Titre","Centre 3");
//        map.put("Localisation","Localisation 3");
//        map.put("Pin",String.valueOf(R.drawable.pin));
//        list.add(map);
//
//        SimpleAdapter adapter = new SimpleAdapter(this.getActivity().getBaseContext(),
//                list,
//                R.layout.fragment_tools,
//                new String[]{"Pin","Titre","Localisation"},
//                new int[]{R.id.item_image,R.id.item_title,R.id.item_detail});
//
//        listView.setAdapter(adapter);

        return view;


    }

}