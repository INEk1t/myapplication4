package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.model.Category;
import com.example.myapplication.model.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listViewItems;
    private Button buttonCurrentActivity;
    private Button buttonProfile;
    TaskAdapter taskAdapter;
    Database database;
    ArrayList<Task> tasks;

    private List<String> categoryList;
    private List<String> itemList;

    CategoryAdapter categoryAdapter;
    RecyclerView categoryRecycler, taskRecycler;
    TaskAdapter TaskAdapter;

    @Override
    protected void onStart() {
        super.onStart();
        if (taskAdapter != null) {
            //taskAdapter = new TaskAdapter(getApplicationContext(), database.selectAll());
            taskAdapter.notifyDataSetChanged();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Spinner spinnerCategories = findViewById(R.id.spinnerCategories);
        //listViewItems = findViewById(R.id.listViewItems);
        buttonCurrentActivity = findViewById(R.id.buttonCurrentActivity);
        buttonProfile = findViewById(R.id.buttonProfile);

        List<Category> categoryList = new ArrayList<>();//("техника 1", "одежда 2", "книги 3", "мебель 4", "игрушки 5");
        categoryList.add(new Category(1, "техника"));
        categoryList.add(new Category(2, "одежда"));
        categoryList.add(new Category(3, "книги"));
        categoryList.add(new Category(4, "мебель"));
        categoryList.add(new Category(5, "игрушки"));

        setCategoryRecycler(categoryList);

        List<Task> taskList = new ArrayList<>();//("техника 1", "одежда 2", "книги 3", "мебель 4", "игрушки 5");
        taskList.add(new Task(0, "java_2", "pbllesos", "ofigennbli pbllesos", "#424345"));
        taskList.add(new Task(1, "java_2", "kyrtka", "ofigennbli kyrtka", "#747B2B"));

        setTaskRecycler(taskList);

        database = new Database(this);
        tasks = database.selectAll();
//        taskAdapter = new TaskAdapter(
//                this, tasks
//        );

        //listViewItems.setAdapter(taskAdapter);

//        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                String selectedItem = itemList.get(position);
////                Toast.makeText(MainActivity.this, "Selected Item: " + selectedItem, Toast.LENGTH_SHORT).show();
//            }
//        });

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

    private void setTaskRecycler(List<Task> taskList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        taskRecycler = findViewById(R.id.taskRecycler);
        taskRecycler.setLayoutManager(layoutManager);

        taskAdapter = new TaskAdapter(this, taskList);
        taskRecycler.setAdapter(taskAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);

    }
}