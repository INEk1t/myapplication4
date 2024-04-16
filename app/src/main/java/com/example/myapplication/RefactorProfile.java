package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RefactorProfile extends AppCompatActivity   {
    Button buttonHome;
    Button buttonProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refactor_profile);

        buttonHome = findViewById(R.id.button_home);
        buttonProfile = findViewById(R.id.button_profile);

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                // Действия при нажатии кнопки "Текущая активность"
            }
        });

        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                // Действия при нажатии кнопки "Профиль"
            }
        });

    }
}
