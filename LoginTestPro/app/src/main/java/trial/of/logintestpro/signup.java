package trial.of.logintestpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText emailSignup;
    private Button signUpBtn;
    private TextView LoginTv2;
    private TextView LoginTv;
    private EditText userName;
    private EditText passwordSignup;
    private EditText confirmPassSignup;
    private EditText mobileNumberEt;
    private EditText gameID;
    private EditText gameUserName;
    private FirebaseFirestore fstore;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        fstore= FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
        LoginTv=findViewById(R.id.loginTv);
        LoginTv2=findViewById(R.id.loginTv1);
        signUpBtn=findViewById(R.id.signup_btn);
        userName=findViewById(R.id.usernameSignupEt);
        emailSignup=findViewById(R.id.emailSignupEt);
        passwordSignup=findViewById(R.id.passwordSignupEt);
        confirmPassSignup=findViewById(R.id.confirmPassSignupEt);
        mobileNumberEt=findViewById(R.id.mobileNumberSignupEt);
        gameID=findViewById(R.id.gameIdSignUp);
        gameUserName=findViewById(R.id.gameUserNameSignup);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email =emailSignup.getText().toString();
                String password=passwordSignup.getText().toString();
                final String username=userName.getText().toString();
                final String phonenumber=mobileNumberEt.getText().toString();
                final String confirmPassword=confirmPassSignup.getText().toString();
                final  String gameid=gameID.getText().toString();
                final  String gameusername=gameUserName.getText().toString();

                if(TextUtils.isEmpty(username)){
                    userName.setError("Enter Username");
                }

                else if (TextUtils.isEmpty(email)){
                    emailSignup.setError("Enter Email");
                }

                else if (TextUtils.isEmpty(password)){
                        passwordSignup.setError("Enter Password");
                }

                else if(TextUtils.isEmpty(confirmPassword)){
                        confirmPassSignup.setError("Enter Password");
                }


                else if (TextUtils.isEmpty(phonenumber)){
                    mobileNumberEt.setError("Enter Valid Mobile No.");
                }

                else if (TextUtils.isEmpty(gameid)){
                    gameID.setError("Enter Valid Mobile No.");
                }

                else if (TextUtils.isEmpty(gameusername)){
                    gameUserName.setError("Enter Valid Mobile No.");
                }


                else {
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(signup.this, "Successfully Resgistered", Toast.LENGTH_SHORT).show();
                                userID=auth.getCurrentUser().getUid();
                                DocumentReference documentReference=fstore.collection("Users").document(userID);

                                Map<String, Object> user = new HashMap<>();
                                user.put("User Name",username);
                                user.put("Email",email);
                                user.put("Contact",phonenumber);
                                user.put("GameID",gameid);
                                user.put("Game UserName", gameusername);
                                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(signup.this, "Thanyou For Registeration", Toast.LENGTH_SHORT).show();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(signup.this, "Signup Failed Please try Again", Toast.LENGTH_SHORT).show();

                                    }
                                });
                                Intent intent = new Intent(signup.this,HomeActivity.class);
                                startActivity(intent);
                                finish();

                            }

                            else {
                                Toast.makeText(signup.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        LoginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(signup.this, loginAct.class);
                startActivity(intent);
                finish();

            }
        });
        LoginTv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(signup.this, loginAct.class);
                startActivity(intent);
                finish();
            }
        });
      //String mobileNumber= mobileNumberEt.getText().toString().trim();
    }

}
