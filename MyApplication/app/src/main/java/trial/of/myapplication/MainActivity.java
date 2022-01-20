package trial.of.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    private EditText PasswordL,EmailAddr;

    //Checking Existing User

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = AuthenticationS0.getCurrentUser();
        if (currentUser != null) {
            startActivity(new Intent(MainActivity.this,Spin_n_Win.class));
        }
    }


    //Database
    private FirebaseAuth AuthenticationS0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Write a message to the database

        Button btn_login = findViewById(R.id.btn_Login);
        EmailAddr = findViewById(R.id.EmailAddrL);
        PasswordL = findViewById(R.id.PasswordL);
        TextView signUpR = findViewById(R.id.LoginR);

        //database
        AuthenticationS0 = FirebaseAuth.getInstance();


        //UI //Goto SignUp Page
        signUpR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this , hellotest.class ));
            }
        });

        //Login Wrkfnction

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Database
                String Email = EmailAddr.getText().toString();
                String Pass = PasswordL.getText().toString();


                if (TextUtils.isEmpty(Email) || TextUtils.isEmpty(Pass)){
                    Toast.makeText(MainActivity.this, "Empty Credentials", Toast.LENGTH_SHORT).show();}
                else if(Pass.length() <= 8){
                    Toast.makeText(MainActivity.this, "Password Should be of min. 8 Characters", Toast.LENGTH_SHORT).show();}
                else{
                    signInWithEmailAndPassword(Email ,Pass);
                }
            }
        });
    }

    private void signInWithEmailAndPassword(String email, String pass) {
        AuthenticationS0.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(MainActivity.this , Spin_n_Win.class ));
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            FirebaseUser currentUser = AuthenticationS0.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Failed to LogIn", Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });

    }


}
