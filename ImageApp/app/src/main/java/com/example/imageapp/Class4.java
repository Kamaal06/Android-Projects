package com.example.imageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Class4 extends AppCompatActivity {
    ImageView HomeImg,NoticeImg,TimeTableImg,GalleryImg;


    TextView studentnameTv;
    public boolean isStudentA = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class4);


        HomeImg=findViewById(R.id.homeImg);
        NoticeImg=findViewById(R.id.noticeImg);
        TimeTableImg=findViewById(R.id.timetableImg);
        GalleryImg=findViewById(R.id.galleryImg);

        HomeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Class4.this,showAct.class));
                finish();
            }
        });

        NoticeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Class4.this, noticeAct.class));
                finish();


            }
        });

        TimeTableImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Class4.this, noticeAct.class));
                finish();


            }
        });

        GalleryImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Class4.this,GalleryAct.class));
                finish();
            }
        });


        getSupportActionBar().setTitle("Welcome To CLass 4");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        studentnameTv = (TextView) findViewById(R.id.studentnameTv);

        Intent intent = getIntent();
        isStudentA = intent.getBooleanExtra("isStudentA", false);

        if (isStudentA){
            studentnameTv.setText("Student A");
        }
        else {
            studentnameTv.setText("Student B");
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
