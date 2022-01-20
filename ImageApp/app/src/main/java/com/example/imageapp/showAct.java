
package com.example.imageapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.InputStream;
import java.util.UUID;

public class showAct extends AppCompatActivity {

   /* Uri filePath;
    ImageView showImg;
    StorageReference reference;

   */ @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

       /* showImg = findViewById(R.id.showImg);

        FirebaseStorage storage = FirebaseStorage.getInstance();
        reference = storage.getReference().child("image/");

        showimage();*/

    }
/*
    private void showimage() {

        if (filePath == null) {
            final ProgressDialog pd = new ProgressDialog(this);
            pd.setTitle("Retriving");
            pd.show();

            final StorageReference reference = .child("images/" + UUID.randomUUID().toString());

            reference.getFile(filePath).


                    addOnCompleteListener(new OnCompleteListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<FileDownloadTask.TaskSnapshot> task) {

                            pd.dismiss();
           /* Bitmap bm = BitmapFactory.decodeByteArray(filePath);
            showImg.setImageBitmap(bm);*/
/*

                            reference.getFile(filePath);
                            showImg.setImageURI(filePath);
                            Toast.makeText(showAct.this, "Image Retreived", Toast.LENGTH_SHORT).show();

                        }
                    }).

                    addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            pd.dismiss();
                            Toast.makeText(showAct.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    });


    }
        }
*/

}



