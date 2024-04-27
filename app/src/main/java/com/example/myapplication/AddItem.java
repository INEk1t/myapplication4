package com.example.myapplication;

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
import android.content.Context;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AddItem extends AppCompatActivity {
    EditText editText;
    Button buttonBack;
    Button buttonAdd;
    Button buttonAddImages;
    Database database;
    private Spinner spinner;
    SharedPreferences sharedpreferences;
    static final int GALLERY_REQUEST = 1;
    private List<String> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        sharedpreferences = getSharedPreferences("app_data", Context.MODE_PRIVATE);

        buttonBack = findViewById(R.id.button_back);
        buttonAddImages = findViewById(R.id.button_add_images);

        buttonAdd = findViewById(R.id.button_add);
        editText = findViewById(R.id.name_item);
        spinner = findViewById(R.id.add_spinner_categories);

        database = new Database(this);
        categoryList = Arrays.asList("Electronics 1", "Clothing 2", "Books 3", "Furniture 4", "Toys 5");

        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, R.layout.spinner_drop, R.id.weekofday, categoryList);
        spinner.setAdapter(categoryAdapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.insert(editText.getText().toString(), spinner.getFirstVisiblePosition() + 1);
            }
        });


        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
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
