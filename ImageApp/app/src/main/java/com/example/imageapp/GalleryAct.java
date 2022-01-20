package com.example.imageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class GalleryAct extends AppCompatActivity {

    ImageView galleryStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        galleryStore=findViewById(R.id.gallerStore);


        getSupportActionBar().setTitle("School Gallery Layout");

    }
}
