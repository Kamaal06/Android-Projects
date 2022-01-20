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
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    public EditText emailid, pswrd;
    Button btnsignUP;
    TextView tvsign;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth= FirebaseAuth.getInstance();
        emailid=findViewById(R.id.editText);
        pswrd=findViewById(R.id.editText2);
        btnsignUP=findViewById(R.id.button1);
        tvsign=findViewById(R.id.textView5);
        btnsignUP.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(MainActivity.this,"Fields are empty",Toast.LENGTH_LONG).show();
                }
                else if (!(email.isEmpty() && pass.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(MainActivity.this,"SignUP unsuccessful",Toast.LENGTH_LONG).show();
                            }
                            else {
                                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(MainActivity.this,"Error Occured",Toast.LENGTH_LONG).show();

                }

            }
        });

        tvsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
