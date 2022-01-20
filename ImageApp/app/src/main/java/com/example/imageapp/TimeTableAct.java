package com.example.imageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class TimeTableAct extends AppCompatActivity {

    ImageView timetableNotice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        timetableNotice=findViewById(R.id.timetableNotice);

        getSupportActionBar().setTitle("Student Home work Layout");


    }
}
