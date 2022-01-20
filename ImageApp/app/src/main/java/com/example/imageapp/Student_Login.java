package com.example.imageapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Student_Login extends AppCompatActivity {

    EditText EmailEt, PasswordEt;
    Button Login;


    UserIdPass_Student Us;



    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Student");
    DatabaseReference getMyRef = database.getReference("Teacher");
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_studentlogin);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //init views
        EmailEt = (EditText) findViewById(R.id.EmailEt);
        PasswordEt = (EditText) findViewById(R.id.PasswordEt);
        Login = (Button) findViewById(R.id.Login);

        Us = new UserIdPass_Student();


        HashMap<Object, Object> map = new HashMap<>();
        map.put(Us.U, Us.P);
        map.put(Us.U1, Us.P1);
        map.put(Us.U2, Us.P2);
        map.put(Us.U3, Us.P3);
        map.put(Us.U4, Us.P4);
        map.put(Us.U5, Us.P5);
        map.put(Us.U6, Us.P6);
        map.put(Us.U7, Us.P7);
        map.put(Us.U8, Us.P8);
        map.put(Us.U9, Us.P9);
        myRef.setValue(map);

        myRef = FirebaseDatabase.getInstance().getReference().child("Student");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // store data of edittexts in String variables
                final String ClassId = PasswordEt.getText().toString().trim();
                final String ClassPass = EmailEt.getText().toString().trim();

                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        myRef = FirebaseDatabase.getInstance().getReference().child("Student");
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

                        if (ClassId.equals("") && ClassPass.equals("")){
                            EmailEt.setFocusable(true);
                            EmailEt.setError("Empty Field");
                            PasswordEt.setFocusable(true);
                            PasswordEt.setError("Empty Fiels");
                        }
         /*class1*/               else if (ClassId.equals(A111) && ClassPass.equals(A111 = dataSnapshot.child("A111").getValue().toString())){
                            Toast.makeText(Student_Login.this, "Details Matches", Toast.LENGTH_SHORT).show();
                            EmailEt.setText("");
                            PasswordEt.setText("");
                            Intent intent = new Intent(Student_Login.this, Class1.class);
                            intent.putExtra("isStudentA",true);
                            startActivity(intent);
                        }
         /*class1*/               else if (ClassId.equals(B112) && ClassPass.equals(B112 = dataSnapshot.child("B112").getValue().toString())){
                            Toast.makeText(Student_Login.this, "Details Matches", Toast.LENGTH_SHORT).show();
                            EmailEt.setText("");
                            PasswordEt.setText("");
                            startActivity(new Intent(Student_Login.this, Class1.class));

                        }
         /*class2*/               else if (ClassId.equals(C113) &&  ClassPass.equals(C113 = dataSnapshot.child("C113").getValue().toString())){
                            Toast.makeText(Student_Login.this, "Details Matches", Toast.LENGTH_SHORT).show();
                            EmailEt.setText("");
                            PasswordEt.setText("");
                            Intent intent = new Intent(Student_Login.this, Class2.class);
                            intent.putExtra("isStudentA",true);
                            startActivity(intent);
                        }
                        else if (ClassId.equals(D114) &&  ClassPass.equals(D114 = dataSnapshot.child("D114").getValue().toString())){
                            Toast.makeText(Student_Login.this, "Details Matches", Toast.LENGTH_SHORT).show();
                            EmailEt.setText("");
                            PasswordEt.setText("");
                            startActivity(new Intent(Student_Login.this, Class2.class));
                        }
                        else if (ClassId.equals(E115) &&  ClassPass.equals(E115 = dataSnapshot.child("E115").getValue().toString())){
                            Toast.makeText(Student_Login.this, "Details Matches", Toast.LENGTH_SHORT).show();
                            EmailEt.setText("");
                            PasswordEt.setText("");
                            Intent intent = new Intent(Student_Login.this, Class3.class);
                            intent.putExtra("isStudentA",true);
                            startActivity(intent);
                        }
                        else if (ClassId.equals(F116) &&  ClassPass.equals(F116 = dataSnapshot.child("F116").getValue().toString())){
                            Toast.makeText(Student_Login.this, "Details Matches", Toast.LENGTH_SHORT).show();
                            EmailEt.setText("");
                            PasswordEt.setText("");
                            startActivity(new Intent(Student_Login.this, Class3.class));
                        }
                        else if ( ClassId.equals(G117) &&  ClassPass.equals(G117 = dataSnapshot.child("G117").getValue().toString())){
                            Toast.makeText(Student_Login.this, "Details Matches", Toast.LENGTH_SHORT).show();
                            EmailEt.setText("");
                            PasswordEt.setText("");
                            Intent intent = new Intent(Student_Login.this, Class4.class);
                            intent.putExtra("isStudentA", true);
                            startActivity(intent);
                        }
                        else if (ClassId.equals(H118) &&  ClassPass.equals(H118 = dataSnapshot.child("H118").getValue().toString())){
                            Toast.makeText(Student_Login.this, "Details Matches", Toast.LENGTH_SHORT).show();
                            EmailEt.setText("");
                            PasswordEt.setText("");
                            startActivity(new Intent(Student_Login.this, Class4.class));
                        }
                        else if (ClassId.equals(I119) &&  ClassPass.equals(I119 = dataSnapshot.child("I119").getValue().toString())){
                            Toast.makeText(Student_Login.this, "Details Matches", Toast.LENGTH_SHORT).show();
                            EmailEt.setText("");
                            PasswordEt.setText("");
                            Intent intent = new Intent(Student_Login.this, Class5.class);
                            intent.putExtra("isStudentA", true);
                            startActivity(intent);
                        }
                        else if (ClassId.equals(J110) &&  ClassPass.equals(J110 = dataSnapshot.child("J110").getValue().toString())){
                            Toast.makeText(Student_Login.this, "Details Matches", Toast.LENGTH_SHORT).show();
                            EmailEt.setText("");
                            PasswordEt.setText("");
                            startActivity(new Intent(Student_Login.this, Class5.class));
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
    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(Student_Login.this, Student_Teacher_Login.class));

        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}