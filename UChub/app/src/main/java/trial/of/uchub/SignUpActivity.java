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

public class SignUpActivity extends AppCompatActivity {


    private FirebaseAuth auth;
    private EditText emailSignup;
    private Button signUpBtn;
    private TextView LoginTv2;
    private TextView LoginTv;
    private EditText userName;
    private EditText passwordSignup;
    private EditText confirmPassSignup;
    private EditText mobileNumberEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth = FirebaseAuth.getInstance();

        LoginTv=findViewById(R.id.loginTv);
        LoginTv2=findViewById(R.id.loginTv1);
        signUpBtn=findViewById(R.id.signup_btn);
        userName=findViewById(R.id.usernameSignupEt);
        emailSignup=findViewById(R.id.emailSignupEt);
        passwordSignup=findViewById(R.id.passwordSignupEt);
        confirmPassSignup=findViewById(R.id.confirmPassSignupEt);
        mobileNumberEt=findViewById(R.id.mobileNumberSignupEt);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email =emailSignup.getText().toString();
                String password=passwordSignup.getText().toString();

                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                    Toast.makeText(SignUpActivity.this, "Please fill the empty Fields", Toast.LENGTH_SHORT).show();
                }

                else {
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(SignUpActivity.this, "Successfully Resgistered", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                            }

                            else {
                                Toast.makeText(SignUpActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        LoginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(SignUpActivity.this, loginAct.class);
                startActivity(intent);
                finish();

            }
        });

        LoginTv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SignUpActivity.this, loginAct.class);
                startActivity(intent);
                finish();
            }
        });
        //String mobileNumber= mobileNumberEt.getText().toString().trim();


        getSupportActionBar().setTitle("SignUp");

    }
}
