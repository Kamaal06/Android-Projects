package trial.of.contactdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    Button btnView;
    DataBaseHelper myDB;
    EditText editText1;
    EditText Contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1=(EditText)findViewById(R.id.editText1);
        btnAdd=(Button)findViewById(R.id.btnAdd);
        btnView=(Button)findViewById(R.id.btnView);
        myDB = new DataBaseHelper(this);
        Contact =(EditText)findViewById(R.id.contacts);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,listViews.class);
                startActivity(intent);
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newEntry= editText1.getText().toString();
                String newEntry1=Contact.getText().toString();

                if ((newEntry.length() !=0) && (newEntry.length() !=0){
                    AddData(newEntry);
                    AddData(newEntry1);
                    editText1.setText("");
                    Contact.setText("");
                }

                else {
                    Toast.makeText(MainActivity.this, "ENTER DATA IN TEXT FIELD", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void AddData(String newEntry){
        boolean insertData = myDB.addData(newEntry);

        if(insertData == true){
            Toast.makeText(MainActivity.this,"Successfully Inserted",Toast.LENGTH_LONG).show();
        }

        else {
            Toast.makeText(MainActivity.this,"Something Went Wrong",Toast.LENGTH_LONG).show();
        }
    }
}
