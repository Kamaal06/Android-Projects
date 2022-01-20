package trial.of.firebasenew;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static trial.of.firebasenew.R.layout.activity_view;

public class MainActivity extends AppCompatActivity {

    Button show;
    Button submit;
    EditText editText;
    ListView listITEM;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show=findViewById(R.id.show);
        editText=findViewById(R.id.editText);
        submit=findViewById(R.id.submit);
        listITEM=findViewById(R.id.listITEM);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_name=editText.getText().toString();

                    FirebaseDatabase.getInstance().getReference().child("FirstDataBase").setValue(txt_name);


                final ArrayList<String> list =new ArrayList<>();
                final ArrayAdapter adapter =new ArrayAdapter<String>(MainActivity.this, activity_view, list);
                listITEM.setAdapter(adapter);

                show.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("FirstDatabase");
                        reference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                list.clear();
                                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                                    list.add(snapshot.getValue().toString());
                                }
                                adapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                });

            }
                });

    }

}

