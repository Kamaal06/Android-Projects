package com.example.imageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Teacher7 extends AppCompatActivity {

    ImageView homeWork;
    ImageView Notice;
    ImageView TimeTable;
    ImageView GallerY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher7);


        homeWork=findViewById(R.id.homeWork7);
        homeWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Teacher7.this, clickAct.class));
            }
        });


        getSupportActionBar().setTitle("Welcome Teacher 7");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Notice=findViewById(R.id.notice7);
        TimeTable=findViewById(R.id.time7);
        GallerY=findViewById(R.id.galler7);

        Notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Teacher7.this, clickAct.class));

            }
        });

        TimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Teacher7.this, clickAct.class));
            }
        });

        GallerY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(Teacher7.this, GalleryAct.class));
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
