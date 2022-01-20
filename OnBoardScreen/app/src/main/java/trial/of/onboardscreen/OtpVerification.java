package trial.of.onboardscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;


public class OtpVerification extends AppCompatActivity {

    TextView MobileNum;
    EditText Num1;
    EditText Num2;
    EditText Num3;
    EditText Num4;
    EditText Num5;
    EditText Num6;

    Button SumOtp;
    Button ResendOtp;

    String getBackOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        Num1 = findViewById(R.id.no1);
        Num2 = findViewById(R.id.no2);
        Num3 = findViewById(R.id.no3);
        Num4 = findViewById(R.id.no4);
        Num5 = findViewById(R.id.no5);
        Num6 = findViewById(R.id.no6);

        ResendOtp = findViewById(R.id.BtnResend);

        SumOtp = findViewById(R.id.submitBtn);

        MobileNum = findViewById(R.id.NumberExtra);
        MobileNum.setText(String.format("+91-%s", getIntent().getStringExtra("mobile")));

        getBackOtp = getIntent().getStringExtra("backOtp");

        final ProgressBar progressBar = findViewById(R.id.ProgBarOtp);

        SumOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!Num1.getText().toString().trim().isEmpty() && !Num2.getText().toString().trim().isEmpty() && !Num3.getText().toString().trim().isEmpty() && !Num4.getText().toString().trim().isEmpty() && !Num5.getText().toString().trim().isEmpty() && !Num6.getText().toString().trim().isEmpty()) {

                    String OtpCodeVerify = Num1.getText().toString() +
                            Num2.getText().toString() +
                            Num3.getText().toString() +
                            Num4.getText().toString() +
                            Num5.getText().toString() +
                            Num6.getText().toString();

                    if (getBackOtp != null) {

                        progressBar.setVisibility(View.VISIBLE);
                        SumOtp.setVisibility(View.INVISIBLE);

                        PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(
                                getBackOtp, OtpCodeVerify
                        );

                        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {

                                        if (task.isSuccessful()) {
                                            Intent intent = new Intent(getApplicationContext(), Last.class);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(OtpVerification.this, "Enter Correct Otp", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                    } else {
                        Toast.makeText(OtpVerification.this, "Please check Internet COnnection", Toast.LENGTH_SHORT).show();
                    }
                    //  Toast.makeText(OtpVerification.this," Otp Verified",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(OtpVerification.this, "Please enter all numbers", Toast.LENGTH_SHORT).show();
                }
            }
        });

        NumberMove();

        ResendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





               PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91" + getIntent().getStringExtra("MobileNum"),
                        60,
                        TimeUnit.SECONDS,
                        OtpVerification.this,

                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {


                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {


                                Toast.makeText(OtpVerification.this, "Please Check your internet", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String newbackOtp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                super.onCodeSent(newbackOtp, forceResendingToken);

                                getBackOtp = newbackOtp;
                                Toast.makeText(OtpVerification.this, "Otp Sent ", Toast.LENGTH_SHORT).show();

                            }
                        }
                );




            }
        });

    }


    private void NumberMove() {
        Num1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()) {
                    Num2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Num2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()) {
                    Num3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Num3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()) {
                    Num4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Num4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()) {
                    Num5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Num5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()) {
                    Num6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
}
