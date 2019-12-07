package com.DSI32G4.MyLab.ui.tools;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.DSI32G4.MyLab.R;

import java.util.ArrayList;
import java.util.List;

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