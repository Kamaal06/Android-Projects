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

public class updatPass extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText passwordEt;
    private Button changepasswordBtn;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updat_pass);


        auth = FirebaseAuth.getInstance();

        passwordEt=findViewById(R.id.password_edt_text);
        changepasswordBtn=findViewById(R.id.reset_pass_btn);
        back=findViewById(R.id.back_btn);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        changepasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String password = passwordEt.getText().toString();

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(updatPass.this, "Please fill the empty Fields", Toast.LENGTH_SHORT).show();
                }

                else {

                    auth.getCurrentUser().updatePassword(password).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()){
                                Toast.makeText(updatPass.this, "Password changes successfully ", Toast.LENGTH_SHORT).show();

                            }

                            else {
                                Toast.makeText(updatPass.this, "Password not changes", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });


    }
}
