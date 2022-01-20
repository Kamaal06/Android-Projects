package contact.insertion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updation extends AppCompatActivity {

    EditText et1, et2, et3;
    Button btn, btn1;

    MyDB myDB;
    String selectName, selectedPhone, selectedAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updation);

        et1=(EditText)findViewById(R.id.upname);
        et2=(EditText)findViewById(R.id.upphone);
        et3=(EditText)findViewById(R.id.upadd);

        btn=(Button)findViewById(R.id.Update);

        myDB = new MyDB(this);

        Intent intent=getIntent();
        selectName = intent.getStringExtra("name");
        selectedPhone = intent.getStringExtra("phone");
        selectedAdd = intent.getStringExtra("add");

        et1.setText(selectName);
        et2.setText(selectedPhone);
        et3.setText(selectedAdd);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et1.getText().toString().trim();
                String phone = et2.getText().toString().trim();
                String add = et3.getText().toString().trim();

                if(name.equals("") && phone.equals("") && add.equals("")){
                    Toast.makeText(updation.this,"You must enter Somthing To Update Data",Toast.LENGTH_LONG).show();
                }

                else {
                    myDB.updateData(name, Integer.parseInt(phone), add, selectName);
                    Toast.makeText(updation.this,"Updatoin Completed Successfully",Toast.LENGTH_LONG).show();
                    et3.setText("");
                    et1.setText("");
                    et2.setText("");
                    startActivity(new Intent(updation.this,MainActivity.class));
                }
            }
        });
    }
}
