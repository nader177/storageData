package com.example.logpass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences mpreferences ;
    private String mpref="mprefs";

    EditText login , pwd ;
    Button btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mpreferences=getSharedPreferences(mpref,MODE_PRIVATE);

        login=findViewById(R.id.login);
        pwd=findViewById(R.id.pwd);
        btn=findViewById(R.id.btn);
        login.setText(mpreferences.getString("login",""));
        pwd.setText(mpreferences.getString("pwd",""));

        btn.setOnClickListener(view ->{
            SharedPreferences.Editor preferencesEditor = mpreferences.edit();
            preferencesEditor.putString("login",login.getText().toString());
            preferencesEditor.putString("pwd",pwd.getText().toString());
            preferencesEditor.apply();
        });


    }
}