package trial.of.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
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
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class hellotest extends AppCompatActivity {

    private int ButtonCount12;
    private int newn;

    TextView HEllo;
    EditText UserNameS0, EmailS0, PasswordS0, PasswordS1;
    Button SignUpBtnS0;


    FirebaseAuth AuthenticationS0;
    FirebaseDatabase DatabaseS0;
    private DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hellotest);
        //UI
        HEllo = findViewById(R.id.Bcktolgn);
        UserNameS0 = findViewById(R.id.UserNameS0);
        EmailS0 = findViewById(R.id.EmailS0);
        PasswordS0 = findViewById(R.id.PassS0);
        PasswordS1 = findViewById(R.id.PassReS0);
        SignUpBtnS0 = findViewById(R.id.SignBttnUp);

        //Database
        AuthenticationS0 = FirebaseAuth.getInstance();
        DatabaseS0 = FirebaseDatabase.getInstance();
        mRef = DatabaseS0.getReference();


        HEllo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(hellotest.this, MainActivity.class));
            }
        });
        SignUpBtnS0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UserName = UserNameS0.getText().toString();
                String Email = EmailS0.getText().toString();
                String Password = PasswordS0.getText().toString();
                String PAssWord = PasswordS1.getText().toString();
                Integer BPC12 = 0;
                Integer UPC12 = 0;
                Integer Spins = 5;
                Integer SpinsAds = 0;

                if (UserName.isEmpty() || Email.isEmpty() || Password.isEmpty() || PAssWord.isEmpty()) {
                    Toast.makeText(hellotest.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                } else if (Email.contains("@") == false) {
                    Toast.makeText(hellotest.this, "Please Enter a Valid Email Address", Toast.LENGTH_SHORT).show();

                } else if (Password.length() <= 8) {
                    Toast.makeText(hellotest.this, "Password Should  Be Of Min. 8 Characters Long.", Toast.LENGTH_SHORT).show();
                } else if (!Password.equals(PAssWord)) {
                    Toast.makeText(hellotest.this, "Password Doesn\t't Match ", Toast.LENGTH_SHORT).show();
                } else {
                    SignUpSaveS0(UserName, Email, Password, BPC12, UPC12, newn, Spins, SpinsAds);
                }
            }
        });
        FetchCurrNo();
    }

    private void FetchCurrNo() {
        mRef.child("ButtonsCount").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ButtonCountsS0 buttonCountsS0 = snapshot.getValue(ButtonCountsS0.class);
                ButtonCount12 = buttonCountsS0.getButtonCount12();
                newn = ButtonCount12;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void SignUpSaveS0(final String username, final String email, final String password, final Integer BPC,
                              final Integer UPC, final int newn, final int spins, final int spinsads) {
        AuthenticationS0.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(hellotest.this, "SignUP Successful", Toast.LENGTH_SHORT).show();
                            FirebaseUser currentUser = AuthenticationS0.getCurrentUser();
                            //DataFeed
                            User user = new User(
                                    username,
                                    email,
                                    BPC,
                                    UPC,
                                    newn,
                                    spins,
                                    spinsads
                            );
                            FirebaseDatabase.getInstance().getReference()
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(hellotest.this, "Account Made", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(hellotest.this, "Failed to add User", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                            startActivity(new Intent(hellotest.this, MainActivity.class));

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(hellotest.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }
}
