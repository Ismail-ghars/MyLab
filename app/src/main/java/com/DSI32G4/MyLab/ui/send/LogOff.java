package com.DSI32G4.MyLab.ui.send;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.DSI32G4.MyLab.loginActivity;

//Classe pour se déconnecter
public class LogOff extends Fragment {

    private LogOffViewModel logOffViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        Intent intent = new Intent(getActivity(), loginActivity.class);
        startActivity(intent);
        return null;
    }
}