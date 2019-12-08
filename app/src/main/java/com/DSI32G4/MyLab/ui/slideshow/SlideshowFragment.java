package com.DSI32G4.MyLab.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.DSI32G4.MyLab.R;
import com.DSI32G4.MyLab.RecyclerAdapterInformations;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        recyclerView = new RecyclerView(getContext());
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapterInformations();
        recyclerView.setAdapter(adapter);


        return recyclerView;

        };

}