package trial.of.onboardscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

        EditText Number;
        Button OBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Number = findViewById(R.id.NumberField);
        OBtn = findViewById(R.id.OtpBtn);

        final ProgressBar progressBar=findViewById(R.id.ProgBar);

        OBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {






               if(!Number.getText().toString().trim().isEmpty()){
                    if ((Number.getText().toString().trim()).length()==10) {

                        progressBar.setVisibility(View.VISIBLE);
                        OBtn.setVisibility(View.INVISIBLE);


                        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                "+91" + Number.getText().toString(),
                                60,
                                TimeUnit.SECONDS,
                                MainActivity.this,

                                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                                        progressBar.setVisibility(View.GONE);
                                        OBtn.setVisibility(View.VISIBLE);

                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {

                                        progressBar.setVisibility(View.GONE);
                                        OBtn.setVisibility(View.VISIBLE);

                                        Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String backOtp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                        super.onCodeSent(backOtp, forceResendingToken);

                                        progressBar.setVisibility(View.GONE);
                                        OBtn.setVisibility(View.VISIBLE);

                                        Intent intent = new Intent(MainActivity.this, OtpVerification.class);
                                        intent.putExtra("mobile",Number.getText().toString());
                                        intent.putExtra("backOtp",backOtp);
                                        startActivity(intent);
                                    }
                                }
                        );


                    }

                    else {
                        Toast.makeText(MainActivity.this,"Please enter correct number",Toast.LENGTH_SHORT).show();
                    }
                }

                else {
                    Toast.makeText(MainActivity.this,"Please enter Mobile Number",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
