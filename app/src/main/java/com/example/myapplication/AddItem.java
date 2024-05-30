package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.model.Category;
import com.example.myapplication.model.CategoryAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddItem extends AppCompatActivity {
    EditText editText;
    Button buttonBack;
    Button buttonAdd;
    Button buttonAddImages;
    Database database;
    private Spinner spinner;
    RecyclerView categoryRecycler;
    CategoryAdapter categoryAdapter;
    SharedPreferences sharedpreferences;
    static final int GALLERY_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        sharedpreferences = getSharedPreferences("app_data", Context.MODE_PRIVATE);

        buttonBack = findViewById(R.id.button_back);
        buttonAddImages = findViewById(R.id.button_add_images);
        spinner = findViewById(R.id.add_spinner_categories);
        buttonAdd = findViewById(R.id.button_add);
        editText = findViewById(R.id.name_item);


        database = new Database(this);
        Spinner spinner = (Spinner) findViewById(R.id.add_spinner_categories);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this, R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.insert(editText.getText().toString(), spinner.getFirstVisiblePosition() + 1);
            }
        });
        buttonAddImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, GALLERY_REQUEST);

            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создайте намерение для открытия второй активности
                Intent intent = new Intent(AddItem.this, MainActivity.class);
                // Запустите вторую активность
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        Bitmap bitmap = null;
        ImageView imageView = (ImageView) findViewById(R.id.view_image);

        switch(requestCode) {
            case GALLERY_REQUEST:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    imageView.setImageBitmap(bitmap);
                }
        }

    }

}
