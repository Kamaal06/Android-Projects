package com.example.imageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Teacher4 extends AppCompatActivity {

    ImageView homeWork;
    ImageView Notice;
    ImageView TimeTable;
    ImageView GallerY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher4);
        getSupportActionBar().setTitle("Welcome Teacher 4");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        homeWork=findViewById(R.id.homeWork4);
        homeWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Teacher4.this, clickAct.class));
            }
        });


        Notice=findViewById(R.id.notice4);
        TimeTable=findViewById(R.id.time4);
        GallerY=findViewById(R.id.galler4);

        Notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Teacher4.this, clickAct.class));

            }
        });

        TimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Teacher4.this, clickAct.class));

            }
        });

        GallerY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(Teacher4.this, GalleryAct.class));
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
