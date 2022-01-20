package com.example.imageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Student_Teacher_Login extends AppCompatActivity {

    Button Teacher_Login, Student_Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__teacher__login);

        getSupportActionBar().setTitle("User's Login ");

        Teacher_Login = (Button) findViewById(R.id.Teacher_Login);
        Student_Login = (Button) findViewById(R.id.Student_Login);

        Teacher_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Student_Teacher_Login.this, com.example.imageapp.Teacher_Login.class));
                finish();
            }
        });

        Student_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Student_Teacher_Login.this, com.example.imageapp.Student_Login.class));
                finish();
            }
        });
    }
}
