package com.DSI32G4.MyLab;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;


//Classe pour l'activité d'enregistrement du compte
public class RegisterActivity extends Activity {
        private DatePickerDialog.OnDateSetListener mDateSetListener1;
        EditText first, last, email, pass, confpass;
        TextView DateNaissance;
        String sexe="null";
        Button save, cancel;
        DataBAseHandler db;
@Override
       protected void onCreate(Bundle savedInstanceState) {
               super.onCreate(savedInstanceState);
               setContentView(R.layout.activity_register);
               Intent i = getIntent();


               first= (EditText)findViewById(R.id.editfirstname);
               last =(EditText)findViewById(R.id.editlastname);
               email=(EditText)findViewById(R.id.editemail);
               DateNaissance =(TextView)findViewById(R.id.editmobileno);
               pass=(EditText)findViewById(R.id.editpassword);
               confpass=(EditText)findViewById(R.id.editconformpassword);


               save=(Button)findViewById(R.id.btnsave);
               cancel=(Button)findViewById(R.id.btncancel);

               cancel.setOnClickListener(new OnClickListener() {

                       @Override
                       public void onClick(View arg0) {
                               startActivity(new Intent(getApplicationContext(), loginActivity.class));


                       }
               });
        final TextView date_deb = findViewById(R.id.editmobileno);
        date_deb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        Calendar calendar = Calendar.getInstance();
                        int year = calendar.get(Calendar.YEAR);
                        int month = calendar.get(Calendar.YEAR);
                        int day = calendar.get(Calendar.YEAR);
                        DatePickerDialog dialog1 = new DatePickerDialog(RegisterActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                                mDateSetListener1,
                                year, month, day);
                        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog1.show();
                }
        });
     mDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month + 1;
                        Log.d("", "onDateSet: mm/dd/yy " + day + "/" + month + "/" + year);
                        String date = month + "/" + day + "/" + year;
                        date_deb.setText(date);

                }
        };
               save.setOnClickListener(new OnClickListener() {

@Override
                     public void onClick(View arg0) {
                             // TODO Auto-generated method stub

                             String edfirst = first.getText().toString();
                             String edlast = last.getText().toString();
                             String edemail = email.getText().toString();
                             String edmobile = DateNaissance.getText().toString();
                             String edpass = pass.getText().toString();
                             String edConf = confpass.getText().toString();

                             if(edConf.equals(edpass) ){


                             db = new DataBAseHandler(RegisterActivity.this, null, null, 2);
                                 RegisterData reg = new RegisterData();

                             reg.setfirstName(edfirst);
                             reg.setlastName(edlast);
                             reg.setEmailId(edemail);
                             reg.setDateNaissance(edmobile);
                             reg.setPassword(edpass);
                             db.addregister(reg);

                             Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_LONG).show();
                             startActivity(new Intent(getApplicationContext(), loginActivity.class));
        }
        else{

        Toast.makeText(getApplicationContext(), "Password doesn't match", Toast.LENGTH_LONG).show();
        pass.setText("");
        confpass.setText("");
        }
        }
        });
        }
        public void onRadioButtonClicked(View view) {
                // Is the button now checked?
                boolean checked = ((RadioButton) view).isChecked();

                // Check which radio button was clicked
                switch(view.getId()) {
                        case R.id.radio_homme:
                                if (checked){
                                        sexe="Homme";
                                        break;
                                }
                        case R.id.radio_femme:
                                if (checked) {
                                        sexe="Femme";
                                        break;
                                }
                }
        }



        }