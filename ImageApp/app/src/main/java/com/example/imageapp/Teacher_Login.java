package com.example.imageapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Teacher_Login extends AppCompatActivity {

    EditText EmailEt, PasswordEt;
    Button Login;

    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference getMyRef = database.getReference("Teacher");

    UserIdPass_Teacher Ut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher__login);

        //init views
        EmailEt = (EditText) findViewById(R.id.EmailEt);
        PasswordEt = (EditText) findViewById(R.id.PasswordEt);
        Login = (Button) findViewById(R.id.Login);
        Ut = new UserIdPass_Teacher();


        HashMap<Object, Object> map1 = new HashMap<>();
        map1.put(Ut.U, Ut.P);
        map1.put(Ut.U1, Ut.P1);
        map1.put(Ut.U2, Ut.P2);
        map1.put(Ut.U3, Ut.P3);
        map1.put(Ut.U4, Ut.P4);
        map1.put(Ut.U5, Ut.P5);
        map1.put(Ut.U6, Ut.P6);
        map1.put(Ut.U7, Ut.P7);
        map1.put(Ut.U8, Ut.P8);
        map1.put(Ut.U9, Ut.P9);
        getMyRef.setValue(map1);

        getMyRef = FirebaseDatabase.getInstance().getReference().child("Teacher");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // store data of edittexts in String variables
                final String TeacherId = PasswordEt.getText().toString().trim();
                final String TeacherPass = EmailEt.getText().toString().trim();

                getMyRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        getMyRef = FirebaseDatabase.getInstance().getReference().child("Teacher");
                        String A111 = dataSnapshot.child("A111").getKey();
                        String B112 = dataSnapshot.child("B112").getKey();
                        String C113 = dataSnapshot.child("C113").getKey();
                        String D114 = dataSnapshot.child("D114").getKey();
                        String E115 = dataSnapshot.child("E115").getKey();
                        String F116 = dataSnapshot.child("F116").getKey();
                        String G117 = dataSnapshot.child("G117").getKey();
                        String H118 = dataSnapshot.child("H118").getKey();
                        String I119 = dataSnapshot.child("I119").getKey();
                        String J110 = dataSnapshot.child("J110").getKey();

                        if (TeacherId.equals("") && TeacherPass.equals("")){
                            EmailEt.setFocusable(true);
                            EmailEt.setError("Empty Field");
                            PasswordEt.setFocusable(true);
                            PasswordEt.setError("Empty Fiels");
                        }
                        else if (TeacherId.equals(A111) && TeacherPass.equals(A111 = dataSnapshot.child("A111").getValue().toString())){
                            Toast.makeText(Teacher_Login.this, "Details Matches", Toast.LENGTH_SHORT).show();
                            EmailEt.setText("");
                            PasswordEt.setText("");
                            startActivity(new Intent(Teacher_Login.this,Teacher1.class));
                        }
                        else if (TeacherId.equals(B112) && TeacherPass.equals(B112 = dataSnapshot.child("B112").getValue().toString())){
                            Toast.makeText(Teacher_Login.this, "Details Matches", Toast.LENGTH_SHORT).show();
                            EmailEt.setText("");
                            PasswordEt.setText("");
                            startActivity(new Intent(Teacher_Login.this,Teacher2.class));
                        }
                        else if (TeacherId.equals(C113) && TeacherPass.equals(C113 = dataSnapshot.child("C113").getValue().toString())){
                            Toast.makeText(Teacher_Login.this, "Details Matches", Toast.LENGTH_SHORT).show();
                            EmailEt.setText("");
                            PasswordEt.setText("");
                            startActivity(new Intent(Teacher_Login.this,Teacher3.class));
                        }
                        else if (TeacherId.equals(D114) && TeacherPass.equals(D114 = dataSnapshot.child("D114").getValue().toString())){
                            Toast.makeText(Teacher_Login.this, "Details Matches", Toast.LENGTH_SHORT).show();
                            EmailEt.setText("");
                            PasswordEt.setText("");
                            startActivity(new Intent(Teacher_Login.this,Teacher4.class));
                        }
                        else if (TeacherId.equals(E115) && TeacherPass.equals(E115 = dataSnapshot.child("E115").getValue().toString())){
                            Toast.makeText(Teacher_Login.this, "Details Matches", Toast.LENGTH_SHORT).show();
                            EmailEt.setText("");
                            PasswordEt.setText("");
                            startActivity(new Intent(Teacher_Login.this,Teacher5.class));
                        }
                        else if (TeacherId.equals(F116) && TeacherPass.equals(F116 = dataSnapshot.child("F116").getValue().toString())){
                            Toast.makeText(Teacher_Login.this, "Details Matches", Toast.LENGTH_SHORT).show();
                            EmailEt.setText("");
                            PasswordEt.setText("");
                            startActivity(new Intent(Teacher_Login.this,Teacher6.class));
                        }
                        else if (TeacherId.equals(G117) && TeacherPass.equals(G117 = dataSnapshot.child("G117").getValue().toString())){
                            Toast.makeText(Teacher_Login.this, "Details Matches", Toast.LENGTH_SHORT).show();
                            EmailEt.setText("");
                            PasswordEt.setText("");
                            startActivity(new Intent(Teacher_Login.this,Teacher7.class));
                        }
                        else if (TeacherId.equals(H118) && TeacherPass.equals(H118 = dataSnapshot.child("H118").getValue().toString())){
                            Toast.makeText(Teacher_Login.this, "Details Matches", Toast.LENGTH_SHORT).show();
                            EmailEt.setText("");
                            PasswordEt.setText("");
                            startActivity(new Intent(Teacher_Login.this,Teacher8.class));
                        }
                        else if (TeacherId.equals(I119) && TeacherPass.equals(I119 = dataSnapshot.child("I119").getValue().toString())){
                            Toast.makeText(Teacher_Login.this, "Details Matches", Toast.LENGTH_SHORT).show();
                            EmailEt.setText("");
                            PasswordEt.setText("");
                            startActivity(new Intent(Teacher_Login.this,Teacher9.class));
                        }
                        else if (TeacherId.equals(J110) && TeacherPass.equals(J110 = dataSnapshot.child("J110").getValue().toString())){
                            Toast.makeText(Teacher_Login.this, "Details Matches", Toast.LENGTH_SHORT).show();
                            EmailEt.setText("");
                            PasswordEt.setText("");
                            startActivity(new Intent(Teacher_Login.this,Teacher10.class));
                        }
                        else {
                            EmailEt.setFocusable(true);
                            EmailEt.setError("Incorrect");
                            PasswordEt.setFocusable(true);
                            PasswordEt.setError("Incorrect");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        getSupportActionBar().setTitle("Teacher Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
            startActivity(new Intent(Teacher_Login.this, Student_Teacher_Login.class));

        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}



        //TeacherId.equals(B112) &&  TeacherPass.equals(B112 = dataSnapshot.child("B112").getValue().toString()) ||
        //TeacherId.equals(C113) &&  TeacherPass.equals(C113 = dataSnapshot.child("C113").getValue().toString()) ||
        //TeacherId.equals(D114) &&  TeacherPass.equals(D114 = dataSnapshot.child("D114").getValue().toString()) ||
        //TeacherId.equals(E115) &&  TeacherPass.equals(E115 = dataSnapshot.child("E115").getValue().toString()) ||
        //TeacherId.equals(F116) &&  TeacherPass.equals(F116 = dataSnapshot.child("F116").getValue().toString()) ||
        //TeacherId.equals(G117) &&  TeacherPass.equals(G117 = dataSnapshot.child("G117").getValue().toString()) ||
        //TeacherId.equals(H118) &&  TeacherPass.equals(H118 = dataSnapshot.child("H118").getValue().toString()) ||
        //TeacherId.equals(I119) &&  TeacherPass.equals(I119 = dataSnapshot.child("I119").getValue().toString()) ||
        //TeacherId.equals(J110) &&  TeacherPass.equals(J110 = dataSnapshot.child("J110").getValue().toString())