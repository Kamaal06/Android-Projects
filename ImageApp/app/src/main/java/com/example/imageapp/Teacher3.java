package com.example.imageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Teacher3 extends AppCompatActivity {


    ImageView homeWork;
    private View Notice;
    private View TimeTable;
    private View GallerY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher3);


        homeWork=findViewById(R.id.homeWork3);


        homeWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Teacher3.this, clickAct.class));
            }
        });

        Notice=findViewById(R.id.notice3);
        TimeTable=findViewById(R.id.time3);
        GallerY=findViewById(R.id.galler3);

        Notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Teacher3.this, clickAct.class));

            }
        });

        TimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Teacher3.this, clickAct.class));

            }
        });

        GallerY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(Teacher3.this, GalleryAct.class));
                finish();

            }
        });


        getSupportActionBar().setTitle("Welcome Teacher 3");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();

    }
}
