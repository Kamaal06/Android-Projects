package trial.of.crudatif;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class list extends AppCompatActivity {

    List<model> modelList = new ArrayList<>();
    RecyclerView mRecyclerView;

    RecyclerView.LayoutManager layoutManager;

    FirebaseFirestore db;

    CustomAdapter adapter;

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mRecyclerView = findViewById(R.id.recylerView);

        mRecyclerView.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        showData();
    }

    private void showData() {

        pd.setTitle("Loading Data.....");

        pd.show();

        db.collection("Documents")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        pd.dismiss();
                        for (DocumentSnapshot doc:task.getResult()){
                            model Model =new model(doc.getString("id"),
                            doc.getString("title");
                            doc.getString("description"));
                            modelList.add(Model);
                        }

                        adapter = new CustomAdapter(listActivity.this, modelList);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        pd.dismiss();
                        Toast.makeText(list.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}
