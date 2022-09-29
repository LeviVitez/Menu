package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button buttonsubmit;
    private EditText editTextInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        buttonsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1. lépés adat elmentés
                adatmentes();

                //2. lépés átmegyünk egy másik activity-re
                //honnan - hova
                Intent intent = new Intent(MainActivity.this,MasodikActivity.class);
                startActivity(intent);
                //backStack!!!!!!!!!!!!
                finish();
            }
        });
    }

    private void adatmentes(){
        SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        String seged= editTextInput.getText().toString();
        editor.putString("editTextErteke",seged);
        editor.apply();
    }

    private void init(){
        buttonsubmit=findViewById(R.id.buttonsubmit);
        editTextInput=findViewById((R.id.editTextInput));
    }
}