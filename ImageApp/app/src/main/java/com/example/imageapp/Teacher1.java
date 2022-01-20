package com.example.imageapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Teacher1 extends AppCompatActivity {


    ImageView homeWork;
    ImageView Notice;
    ImageView TimeTable;
    ImageView GallerY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher1);

    homeWork=findViewById(R.id.homeWork1);


    homeWork.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            startActivity(new Intent(Teacher1.this, clickAct.class));
        }
    });

    Notice=findViewById(R.id.notice1);
    TimeTable=findViewById(R.id.time1);
    GallerY=findViewById(R.id.galler1);

    Notice.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            startActivity(new Intent(Teacher1.this, clickAct.class));
        }
    });

    TimeTable.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            startActivity(new Intent(Teacher1.this, clickAct.class));
        }
    });

    GallerY.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            startActivity(new Intent(Teacher1.this, GalleryAct.class));
            finish();
        }
    });

        getSupportActionBar().setTitle("Welcome Teacher 1");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}
