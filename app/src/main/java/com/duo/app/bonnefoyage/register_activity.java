package com.duo.app.bonnefoyage;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register_activity extends AppCompatActivity implements View.OnClickListener {
    private Button btnRegister;
    private EditText txtWachtwoord;
    private EditText txtEmail;
    private TextView txtSignin;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        btnRegister = (Button) findViewById(R.id.btnRegister);

        txtWachtwoord = (EditText) findViewById(R.id.txtWachtwoord);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtSignin = (TextView) findViewById(R.id.txtSignin);

        btnRegister.setOnClickListener(this);
        txtSignin.setOnClickListener(this);
    }

    private void registerUser(){

        //getting email and password from edit texts
        String email = txtEmail.getText().toString().trim();
        String password  = txtWachtwoord.getText().toString().trim();

        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            //display some message here
                            startInteresseActivity();
                            Toast.makeText(register_activity.this,"Successfully registered",Toast.LENGTH_LONG).show();
                        }else{
                            //display some message here
                            startInteresseActivity();
                            Toast.makeText(register_activity.this,"Successfully registered",Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });

    }
    public void startLoginActivity(){
        Intent i = new Intent(register_activity.this, login_activity.class);
        startActivity(i);
    }
    public void startInteresseActivity(){
        Intent i = new Intent(register_activity.this, keuzeLijst.class);
        startActivity(i);
    }

    @Override
    public void onClick(View view) {
        if(view  == btnRegister){
            registerUser();
        }
        if(view == txtSignin){
            finish();
            startLoginActivity();
        }
    }

}
