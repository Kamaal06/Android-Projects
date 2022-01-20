package trial.of.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyDB myDB;
    Button Add;
    Button ciew;
    EditText details;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Add=(Button)findViewById(R.id.Add);
        ciew=(Button)findViewById(R.id.view);
        details=(EditText)findViewById(R.id.details);

        myDB=new MyDB(this);

        ciew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                Intent intent = new Intent(MainActivity.this, ViewList.class);
                startActivity(intent);
            }
        });

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                String newEntry = details.getText().toString();

                if(details.length()!=0){

                    AddData(newEntry);
                    details.setText("");

                }

                else {
                    Toast.makeText(MainActivity.this,"Text Field is Empty", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void AddData(String newEntry){
         boolean insertData= myDB.addData(newEntry);
        if(insertData==true){
            Toast.makeText(MainActivity.this,"Successfully Entered Data ",Toast.LENGTH_LONG).show();
        }

        else {
            Toast.makeText(MainActivity.this,"Something went wrong",Toast.LENGTH_LONG).show();
        }
    }
}
