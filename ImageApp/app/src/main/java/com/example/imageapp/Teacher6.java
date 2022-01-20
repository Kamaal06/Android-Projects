package com.example.imageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Teacher6 extends AppCompatActivity {

    ImageView homeWork;
    ImageView Notice;
    ImageView TimeTable;
    ImageView GallerY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher6);


        homeWork=findViewById(R.id.homeWork6);
        homeWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Teacher6.this, clickAct.class));
            }
        });


        getSupportActionBar().setTitle("Welcome Teacher 6");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Notice=findViewById(R.id.notice6);
        TimeTable=findViewById(R.id.time6);
        GallerY=findViewById(R.id.galler6);

        Notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Teacher6.this, clickAct.class));

            }
        });

        TimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Teacher6.this, clickAct.class));


            }
        });

        GallerY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(Teacher6.this, GalleryAct.class));
                finish();

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();

    }
}
