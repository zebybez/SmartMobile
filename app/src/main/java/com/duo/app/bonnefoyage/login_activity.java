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
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_activity extends AppCompatActivity implements View.OnClickListener{
    private Button btnLogin;
    private EditText txtWachtwoord;
    private EditText txtEmail;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        txtWachtwoord = (EditText) findViewById(R.id.txtWachtwoord);
        txtEmail = (EditText) findViewById(R.id.txtEmail);

        btnLogin.setOnClickListener(this);

    }

    private void userLogin(){
        String email = txtEmail.getText().toString().trim();
        String wachtwoord = txtWachtwoord.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //email is leeg
            Toast.makeText(this,"Vul een email in",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(wachtwoord)){
            //wachtwoord is leeg
            Toast.makeText(this,"Vul een wachtwoord in",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Bezig met registreren...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, wachtwoord)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if(task.isSuccessful()){
                            finish();
                            startMainActivity();
                            Toast.makeText(login_activity.this, "Succesvol ingelogd", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(login_activity.this, "Verkeerde gegevens ingevuld", Toast.LENGTH_SHORT).show();
                        }
                        }
                });
    }

    public void startMainActivity(){
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void onClick(View view) {
        if(view == btnLogin){
            userLogin();
        }
    }
}
