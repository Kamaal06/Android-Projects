package com.example.imageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Teacher2 extends AppCompatActivity {

    ImageView homeWork2;
    ImageView Notice;
    ImageView TimeTable;
    ImageView GallerY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher2);


        homeWork2=findViewById(R.id.homeWork2);



        homeWork2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Teacher2.this, clickAct.class));
            }
        });

        getSupportActionBar().setTitle("Welcome Teacher 2");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Notice=findViewById(R.id.notice2);
        TimeTable=findViewById(R.id.time2);
        GallerY=findViewById(R.id.galler2);

        Notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Teacher2.this, clickAct.class));
            }
        });

        TimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Teacher2.this, clickAct.class));
            }
        });

        GallerY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(Teacher2.this, GalleryAct.class));
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
