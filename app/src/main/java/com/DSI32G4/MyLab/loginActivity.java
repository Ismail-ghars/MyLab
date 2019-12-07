package com.DSI32G4.MyLab;


import android.net.Uri;
import android.os.Bundle;


        import android.app.Activity;
        import android.content.Intent;
        import android.database.Cursor;
import android.util.Log;
import android.view.MenuItem;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class loginActivity extends Activity {

    EditText  pass;
    static EditText user;
    Button login;
    TextView not_reg;
    DataBAseHandler db;
    Cursor cursor;
    GoogleSignInClient mGoogleSignInClient;
    SignInButton signInButton;
    int RC_SIGN_IN = 0;

    public static EditText getUser() {
        return user;
    }

    //Begining of Google Methods
    @Override
    protected void onStart() {
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

    }
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Google Authentification
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        signInButton = findViewById(R.id.sign_in_button);
        final GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        signInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.sign_in_button:
                        signIn();
                        break;
                }
                //Account Information
                if (acct != null) {
                    String personGivenName = acct.getGivenName();
                    String personFamilyName = acct.getFamilyName();
                    String personEmail = acct.getEmail();
                    db=new DataBAseHandler(loginActivity.this, null, null, 2);

                    if(db.Check(personEmail)){
                        Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), Accueil.class));
                    }
                    else{
                        Intent i = new Intent(getBaseContext(),RegisterActivity.class);
                        i.putExtra("personGivenName",personGivenName);
                        i.putExtra("personFamilyName",personFamilyName);
                        i.putExtra("personEmail",personEmail);
                        startActivity(i);
                    }


                }




            }
        });














        user =(EditText)findViewById(R.id.eduser);
        pass = (EditText)findViewById(R.id.edpass);
        login =(Button)findViewById(R.id.login);
        not_reg =findViewById(R.id.not_reg);

        login.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                db=new DataBAseHandler(loginActivity.this, null, null, 2);
                String username=user.getText().toString();
                String password= pass.getText().toString();


                String StoredPassword =db.getregister(username);
                if(password.equals(StoredPassword)){

                    Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), Accueil.class));

                }
                else{
                    Toast.makeText(getApplicationContext(), "Username/Password incorrect", Toast.LENGTH_LONG).show();
                    user.setText("");
                    pass.setText("");
                }


            }
        });

        not_reg.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });


    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
    /* @Override
                    public boolean onCreateOptionsMenu(Menu menu) {
MenuInflater inflater = getMenuInflater();
inflater.inflate(R.menu.action_settings, menu);
            return super.onCreateOptionsMenu(menu);
           //
     }
     */  /*
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.action_settings:
                // search action
                Intent i=new Intent(loginActivity.this,RegisterActivity.class);
                startActivity(i);
                return true;
        }
        return false;

    }
                           @Override
                                protected void onResume() {
                                                // TODO Auto-generated method stub
                                                 list = db.getAllRegister();
                                //            list=((alertv) alert).showAlert();
                                                                Customlist adapter = new Customlist(MainActivity.this, list);
                                                //            mylistview.setAdapter(adapter);

                                                                if(adapter.getCount()!=0){
                                                                      mylistview.setAdapter(adapter);


                                                                }else{
                                                                     Toast.makeText(MainActivity.this, "No Items Available",Toast.LENGTH_SHORT).show();
                                                                }
                                                super.onResume();
                                  }
  */

}