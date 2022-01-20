package trial.of.intern1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LogSign_Page extends AppCompatActivity {

    private Button SignUpBtn;
    private Button LogInBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_sign__page);


            SignUpBtn =(Button) findViewById(R.id.signUp);
            LogInBtn=(Button)findViewById(R.id.login);

            SignUpBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(LogSign_Page.this, SignUp.class);
                    startActivity(intent);

                }
            });

            LogInBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(LogSign_Page.this, Login.class);
                    startActivity(intent);
                }
            });
    }
}
