package trial.of.names;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView fname;
    private TextView Lname;
    private  TextView Age;
    private EditText ename;
    private  EditText eLastName;
    private EditText eAge;
    private Button Submit;
    private EditText main;
    private Button Clear;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name();


        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.setText("My Name is"+ename.getText().toString()+" My Last Name is "+eLastName.getText().toString()+
                        " and my age is" +eAge.getText().toString());
            }
        });

        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ename.setText("");
                eLastName.setText("");
                eAge.setText("");
                main.setText("");
            }
        });
    }

        private void name(){

        fname=(TextView)findViewById(R.id.fname);
            Lname=(TextView)findViewById(R.id.lname);
                Age=(TextView)findViewById(R.id.Age);
                    ename=(EditText)findViewById(R.id.ename);
                        eLastName=(EditText)findViewById(R.id.eLastName);
                            Submit=(Button)findViewById(R.id.Submit);
                                main=(EditText)findViewById(R.id.main);
                                    eAge=(EditText) findViewById(R.id.eAge);
                                        Clear=(Button)findViewById(R.id.Clear);
        }
}
