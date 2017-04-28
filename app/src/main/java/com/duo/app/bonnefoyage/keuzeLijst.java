package com.duo.app.bonnefoyage;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.duo.app.bonnefoyage.Activity.MainActivity;

public class keuzeLijst extends AppCompatActivity implements View.OnClickListener {
    private CheckBox cbMuseum, cbChurch, cbStadium, cbLibrary, cbSkyscraper, cbCinema, cbStation, cbShopping, cbNature, cbPool, cbGamling, cbZoo, cbHospital;
    private EditText txtNaam;
    private Button btnSubmit;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_keuze_lijst);


        cbMuseum = (CheckBox) findViewById(R.id.cbMuseum);
        cbChurch = (CheckBox) findViewById(R.id.cbChurch);
        cbStadium = (CheckBox) findViewById(R.id.cbStadium);
        cbLibrary = (CheckBox) findViewById(R.id.cbLibrary);
        cbSkyscraper = (CheckBox) findViewById(R.id.cbSkyscraper);
        cbCinema = (CheckBox) findViewById(R.id.cbCinema);
        cbStation = (CheckBox) findViewById(R.id.cbStation);
        cbShopping = (CheckBox) findViewById(R.id.cbShopping);
        cbNature = (CheckBox) findViewById(R.id.cbNature);
        cbPool = (CheckBox) findViewById(R.id.cbPool);
        cbGamling = (CheckBox) findViewById(R.id.cbGambling);
        cbZoo = (CheckBox) findViewById(R.id.cbZoo);
        cbHospital = (CheckBox) findViewById(R.id.cbHospital);
        txtNaam = (EditText) findViewById(R.id.txtNaam);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(this);
    }



    private void startCheckboxActivity() {

        String naam = txtNaam.getText().toString().trim();
        if (TextUtils.isEmpty(naam)) {
            Toast.makeText(this, "Vul een naam in", Toast.LENGTH_LONG).show();
            return;
        }
        else{
            startMainActivity();
        }

    }

    public void startMainActivity(){
        Intent i = new Intent(keuzeLijst.this, MainActivity.class);
        startActivity(i);
    }
    @Override
    public void onClick(View view) {
        if(view  == btnSubmit){
            startCheckboxActivity();
        }
    }

}
