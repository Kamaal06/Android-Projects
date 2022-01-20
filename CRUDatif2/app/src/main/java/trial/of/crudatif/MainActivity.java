package trial.of.crudatif;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {


    EditText title, desc;
    Button Save, Show;

    ProgressDialog pd;

    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Add data");

        title = findViewById(R.id.edit1);
        desc = findViewById(R.id.edit2);
        Save = findViewById(R.id.btn1);
        Show=findViewById(R.id.btn2)
        pd = new ProgressDialog(this);

        db = FirebaseFirestore.getInstance();


        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Title = title.getText().toString().trim();
                String Descript = desc.getText().toString().trim();


                uploadData(Title, Descript);
            }
        });

        Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, list.class));
                finish();
            }
        });
    }

    private void uploadData(String Title, String Descript) {

        pd.setTitle("Adding Data to FireStore");

        pd.show();

        String id = UUID.randomUUID().toString();

        Map<String, Object> doc = new HashMap<>();
        doc.put("id", id);
        doc.put("Title ", Title);
        doc.put("Description ", Descript);

        db.collection("Documents").document(id).set(doc)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        pd.dismiss();

                        Toast.makeText(MainActivity.this, "Uploaded...", Toast.LENGTH_LONG).show();
                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        pd.dismiss();

                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();


                    }
                });
    }
}
