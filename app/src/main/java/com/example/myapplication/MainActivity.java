package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerCategories;
    private ListView listViewItems;
    private Button buttonCurrentActivity;
    private Button buttonProfile;
    TaskAdapter taskAdapter;
    Database database;
    ArrayList<Task> tasks;

    private List<String> categoryList;
    private List<String> itemList;

    @Override
    protected void onStart() {
        super.onStart();
        if (taskAdapter != null) {
            taskAdapter = new TaskAdapter(getApplicationContext(), database.selectAll());
            taskAdapter.notifyDataSetChanged();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCategories = findViewById(R.id.spinnerCategories);
        listViewItems = findViewById(R.id.listViewItems);
        buttonCurrentActivity = findViewById(R.id.buttonCurrentActivity);
        buttonProfile = findViewById(R.id.buttonProfile);

        categoryList = Arrays.asList("Electronics", "Clothing", "Books", "Furniture", "Toys");

        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, R.layout.spinner_drop, R.id.weekofday, categoryList);
        spinnerCategories.setAdapter(categoryAdapter);

        database = new Database(this);
        tasks = database.selectAll();

        taskAdapter = new TaskAdapter(
                this, tasks
        );

        listViewItems.setAdapter(taskAdapter);

        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = itemList.get(position);
                Toast.makeText(MainActivity.this, "Selected Item: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

        buttonCurrentActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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