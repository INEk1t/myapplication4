package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    private TextView textViewUserName;
    private ListView listViewUserItems;
    private Button buttonEditProfile;
    private Button buttonCurrentActivity;
    private Button buttonProfile;
    private Button buttonAddItem;
    private List<String> userItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textViewUserName = findViewById(R.id.textViewUserName);
        listViewUserItems = findViewById(R.id.listViewUserItems);
        buttonEditProfile = findViewById(R.id.buttonEditProfile);
        buttonCurrentActivity = findViewById(R.id.buttonCurrentActivity);
        buttonProfile = findViewById(R.id.buttonProfile);
        buttonAddItem = findViewById(R.id.addItemButton);

        textViewUserName.setText("John Doe"); // Установка имени пользователя

        userItems = new ArrayList<>(Arrays.asList()); // Допустим, что у пользователя есть 3 товара

        ArrayAdapter<String> userItemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userItems);
        listViewUserItems.setAdapter(userItemsAdapter);

        buttonEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Действия при нажатии кнопки "Редактировать профиль"
            }
        });


        buttonCurrentActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                // Действия при нажатии кнопки "Текущая активность"
            }
        });

        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddItem.class));
                // Действия при нажатии кнопки "Текущая активность"
            }
        });

        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Действия при нажатии кнопки "Профиль"
            }
        });

    }
}