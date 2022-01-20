package trial.of.uchub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginAct extends AppCompatActivity {


    private FirebaseAuth auth;
    private EditText emailET;
    private  EditText passwordET;
    private TextView signupBtn;
    private Button loginBtn;
    private TextView signupBtn2;

    private  TextView resetPasswordTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth=FirebaseAuth.getInstance();

        emailET=findViewById(R.id.email_edt_text);
        passwordET=findViewById(R.id.pass_edt_text);
        signupBtn=findViewById(R.id.signtv);
        signupBtn2=findViewById(R.id.signuptv2);
        loginBtn = (Button)findViewById(R.id.login_btn);
        resetPasswordTV=findViewById(R.id.reset_pass_tv);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email =emailET.getText().toString().trim();
                String password=passwordET.getText().toString().trim();

                if(TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
                    Toast.makeText(loginAct.this, "Please Fill the empty fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){

                                Toast.makeText(loginAct.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(loginAct.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }

                            else {

                                Toast.makeText(loginAct.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginAct.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        signupBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginAct.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        resetPasswordTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(loginAct.this, forgotAct.class));
                finish();
            }
        });

        getSupportActionBar().setTitle("UcHub Login");


    }
}
