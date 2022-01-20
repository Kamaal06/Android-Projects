package trial.of.storeret;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button btnAdd;
    Spinner spin;

    DatabaseReference databaseArtists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseArtists= FirebaseDatabase.getInstance().getReference("artist");

        name = findViewById(R.id.enter);
        spin = findViewById(R.id.spinner1);
        btnAdd = findViewById(R.id.Add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Addart();
            }
        });
    }
        private void Addart(){

            String name1 = name.getText().toString().trim();
            String genre = spin.getSelectedItem().toString();

            if (!TextUtils.isEmpty(name1)){

                String id =databaseArtists.push().getKey();

                addition Addition = new addition(id, name1, genre);
                databaseArtists.child(id).setValue(Addition);
                Toast.makeText(this,"Artist Added",Toast.LENGTH_LONG ).show();

            }

            else {
                Toast.makeText(MainActivity.this, "You have to Enter A name",Toast.LENGTH_LONG).show();

        }
    }
}
