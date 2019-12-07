package com.DSI32G4.MyLab.ui.share;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.DSI32G4.MyLab.Accueil;
import com.DSI32G4.MyLab.DataBAseHandler;
import com.DSI32G4.MyLab.MainActivity;
import com.DSI32G4.MyLab.R;
import com.DSI32G4.MyLab.RegisterActivity;
import com.DSI32G4.MyLab.loginActivity;

public class ShareFragment extends Fragment {

    private ShareViewModel shareViewModel;
    public DataBAseHandler db;
    EditText first;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
        View root = inflater.inflate(R.layout.fragment_share, container, false);

        db=new DataBAseHandler(getContext(), null, null, 2);
        loginActivity l1=new loginActivity();
        String nom_selected =db.getregister(l1.getUser().getText().toString());
        String prenom_selected =db.getprenom(l1.getUser().getText().toString());
        String tel_selected =db.gettel(l1.getUser().getText().toString());


        EditText nom = (EditText) root.findViewById(R.id.modiflastname);
        nom.setText(nom_selected);
        EditText prenom = (EditText) root.findViewById(R.id.modiffirstname);
        prenom.setText(prenom_selected);
        EditText text = (EditText) root.findViewById(R.id.modifmobileno);
        text.setText(tel_selected);

        Button modif = root.findViewById(R.id.sign_in_button);


        return root;
    }



}