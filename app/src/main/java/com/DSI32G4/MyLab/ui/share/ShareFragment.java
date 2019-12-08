package com.DSI32G4.MyLab.ui.share;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
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
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.DSI32G4.MyLab.Accueil;
import com.DSI32G4.MyLab.DataBAseHandler;
import com.DSI32G4.MyLab.MainActivity;
import com.DSI32G4.MyLab.R;
import com.DSI32G4.MyLab.RegisterActivity;
import com.DSI32G4.MyLab.SelectDateFragment;
import com.DSI32G4.MyLab.loginActivity;

import java.util.Calendar;

public class ShareFragment extends Fragment {

    private ShareViewModel shareViewModel;
    public DataBAseHandler db;
    EditText first;
    DatePickerDialog.OnDateSetListener mDateSetListener;
    static TextView dd;

    public static TextView getDd() {
        return dd;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_share, container, false);
        final TextView date_dep = root.findViewById(R.id.modifmobileno);
        dd=((TextView) root.findViewById(R.id.modifmobileno));


        db=new DataBAseHandler(getContext(), null, null, 2);
        final loginActivity l1=new loginActivity();
        String nom_selected =db.getregister(l1.getUser().getText().toString());
        String prenom_selected =db.getprenom(l1.getUser().getText().toString());
        String tel_selected =db.gettel(l1.getUser().getText().toString());


        final EditText nom = (EditText) root.findViewById(R.id.modiflastname);
        nom.setText(nom_selected);
        final EditText prenom = (EditText) root.findViewById(R.id.modiffirstname);
        prenom.setText(prenom_selected);
        final TextView date = (TextView) root.findViewById(R.id.modifmobileno);
        date.setText(tel_selected);

        Button modif = root.findViewById(R.id.btnmodif);
        modif.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ContentValues cv = new ContentValues();
                cv.put("KEY_FIRST_NAME",nom.getText().toString()); //These Fields should be your String values of actual column names
                cv.put("KEY_lAST_NAME",prenom.getText().toString());
                cv.put("KEY_MOB_NO",date.getText().toString());
                db.updateData(l1.getUser().getText().toString(), nom.getText().toString(), prenom.getText().toString(), date.getText().toString());
                Toast.makeText(root.getContext(), "info modifié", Toast.LENGTH_LONG).show();

            }
            });


        date_dep.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                DialogFragment newFragment = new SelectDateFragment();
                newFragment.show(getFragmentManager(), "DatePicker");

            }
        });






        return root;
    }



}