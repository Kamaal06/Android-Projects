package trial.of.loginregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {


    public EditText emailid, pswrd;
    Button btnsignin;
    TextView tvsign;
    FirebaseAuth mFirebaseAuth;

    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth= FirebaseAuth.getInstance();
        emailid=findViewById(R.id.editText5);
        pswrd=findViewById(R.id.editText6);
        btnsignin=findViewById(R.id.button5);
        tvsign=findViewById(R.id.textView6);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser =mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser !=null){
                    Toast.makeText(LoginActivity.this,"You are Logged in",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(intent);
                }

                else {
                    Toast.makeText(LoginActivity.this,"Please Login",Toast.LENGTH_LONG).show();
                }
            }
        };

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailid.getText().toString();
                String pass=pswrd.getText().toString();

                if (email.isEmpty()){
                    emailid.setError("Please enter Email id");
                    emailid.requestFocus();
                }

                else if (pass.isEmpty()){
                    pswrd.setError("Please enter Password");
                    pswrd.requestFocus();
                }

                else if(email.isEmpty() && pass.isEmpty()){
                    Toast.makeText(LoginActivity.this,"Fields are empty",Toast.LENGTH_LONG).show();
                }
                else if (!(email.isEmpty() && pass.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(LoginActivity.this,"Login Error Please Login Again",Toast.LENGTH_LONG).show();
                            }
                            else {
                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(intent);
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(LoginActivity.this,"Error Occured",Toast.LENGTH_LONG).show();

                }

            }
        });

        tvsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}


