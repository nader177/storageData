package com.example.logpass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.logpass.appdatabase.AppDataBase;
import com.example.logpass.entity.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences mpreferences;
    private AppDataBase appDataBase;
    private String mpref = "mprefs";

    EditText login, pwd;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mpreferences = getSharedPreferences(mpref, MODE_PRIVATE);
        appDataBase = AppDataBase.getAppDatabase(this);
        login = findViewById(R.id.login);
        pwd = findViewById(R.id.pwd);
        btn = findViewById(R.id.btn);
        login.setText(mpreferences.getString("login", ""));
        pwd.setText(mpreferences.getString("pwd", ""));

        btn.setOnClickListener(view -> {
            System.out.println("insert into data base room");
            User user = new User(login.getText().toString(), pwd.getText().toString());
            appDataBase.userDao().insertOne(user);

            System.out.println("insert into shared pref");

            SharedPreferences.Editor preferencesEditor = mpreferences.edit();
            preferencesEditor.putString("login", login.getText().toString());
            preferencesEditor.putString("pwd", pwd.getText().toString());
            preferencesEditor.apply();
            List<User> Ul = appDataBase.userDao().getAll();
            for (User singelUser : Ul) {
                System.out.println(singelUser);


            }


        });


    }
}