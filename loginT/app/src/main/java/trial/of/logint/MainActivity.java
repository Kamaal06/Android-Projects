package trial.of.logint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter=5;
    private Object String;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name=(EditText)findViewById(R.id.edName);
        Password=(EditText)findViewById(R.id.etPassword);
        Info=(TextView)findViewById(R.id.info);
        Login=(Button)findViewById(R.id.button);
        Info.setText(" No of attempts 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());

            }
        });



        private void validate(String userName, String userPassword){

            if((userName=="Admin") && (userPasssword=="1234")){

                Intent intent=new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
            else{
                counter --;
                Info.setText("No of Attempts Remaining "+ String.valueOf(counter));
                if(counter==0){
                    Login.setEnabled(false);
                }

            }
        }

    }
}
