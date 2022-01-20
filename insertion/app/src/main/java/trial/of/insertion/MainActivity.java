package trial.of.insertion;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2, et3;
    Button btn, btn1;
    static MyDB myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new MyDB(this);

        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        et3=(EditText)findViewById(R.id.editText3);
        btn=(Button)findViewById(R.id.button);
        btn1=(Button)findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et1.getText().toString().trim();
                String place = et2.getText().toString().trim();
                String food = et3.getText().toString().trim();

                boolean result = MainActivity.myDB.insertData(name,place,food);

                if (result){

                    String [] OPERATIONS ={"okay"};

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle(name +" Registered Successfully");
                    builder.setItems(OPERATIONS, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.show();
                    //Toast.makeText(MainActivity.this,"Registered",Toast.LENGTH_LONG).show();
                }

                else {
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();
                }

                et1.setText("");
                et2.setText("");
                et3.setText("");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShowDATA.class);
                startActivity(intent);
            }
        });
    }
}
