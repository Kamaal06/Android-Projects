package contact.insertion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

        EditText Name, No, Address;
        Button Add, Show, Reset,UPDATE;

        static MyDB myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new MyDB(this);

        Name=(EditText)findViewById(R.id.Name);
        No=(EditText)findViewById(R.id.No);
        Address=(EditText)findViewById(R.id.Address);
        Add=(Button)findViewById(R.id.add);
        Show=(Button)findViewById(R.id.show);
        Reset=(Button)findViewById(R.id.reset);
        UPDATE=(Button)findViewById(R.id.UPDATE);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name =Name.getText().toString().trim();
                String no=No.getText().toString().trim();
                String  address=Address.getText().toString().trim();

                boolean result =MainActivity.myDB.insertData(name,no,address);

                Name.setText("");
                Address.setText("");
                No.setText("");
                }
             });

        Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowDisplay.class);
                startActivity(intent);
            }
        });


        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Name.setText("");
                Address.setText("");
                No.setText("");
            }
        });


        UPDATE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =Name.getText().toString().trim();
                String no=No.getText().toString().trim();
                String  address=Address.getText().toString().trim();

                Intent intent = new Intent(MainActivity.this, updation.class);
                intent.putExtra("name",name);
                intent.putExtra("phone",no);
                intent.putExtra("add",address);
                startActivity(intent);
            }
        });

    }
}
