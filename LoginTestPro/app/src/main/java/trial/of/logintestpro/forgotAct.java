package trial.of.logintestpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotAct extends AppCompatActivity {

    private   FirebaseAuth auth;
    private EditText emailET;
    private Button resetPasswordBtn;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);


        auth=FirebaseAuth.getInstance();
        emailET=findViewById(R.id.email_edt_text);
        resetPasswordBtn=findViewById(R.id.reset_pass_btn);
        back=findViewById(R.id.back_btn);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        resetPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=emailET.getText().toString();

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(forgotAct.this, "Please fill empty fields", Toast.LENGTH_SHORT).show();
                }

                else {
                    auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful()){
                                Toast.makeText(forgotAct.this, "Reset link send to your email", Toast.LENGTH_SHORT).show();
                            }

                            else {
                                Toast.makeText(forgotAct.this, "Unable to send reset mail", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });



    }
}
