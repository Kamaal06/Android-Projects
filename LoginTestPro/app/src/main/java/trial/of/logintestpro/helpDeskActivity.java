package trial.of.logintestpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class helpDeskActivity extends AppCompatActivity {

    EditText UserNameEt, MobileNumberEt, EmailEt, QueryEt;
    Button SendButton;

    FirebaseAuth auth;
    FirebaseFirestore fstore;
    String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_desk);

        UserNameEt=findViewById(R.id.userFullName);
        MobileNumberEt=findViewById(R.id.mobileNumberHelpDesk);
        EmailEt=findViewById(R.id.emailHelpDesk);
        QueryEt=findViewById(R.id.troubleQueryHelpDesk);
        SendButton=findViewById(R.id.sendBtnHelpDesk);


        auth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();

        SendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernameHelp = UserNameEt.getText().toString();
                String mobileHelp = MobileNumberEt.getText().toString();
                String emailHelp = EmailEt.getText().toString();
                String queryHelp = QueryEt.getText().toString();


                if (TextUtils.isEmpty(usernameHelp)) {

                    UserNameEt.setError("Enter Username");

                }

                else if (TextUtils.isEmpty(mobileHelp)) {

                    MobileNumberEt.setError("Enter Mobile Number");

                }

                else if (TextUtils.isEmpty(emailHelp)) {

                    EmailEt.setError("Enter Email");

                }

                else if (TextUtils.isEmpty(queryHelp)) {

                    QueryEt.setError("Enter Query");

                }
                else {
                    userID = auth.getCurrentUser().getUid();
                    DocumentReference documentReference = fstore.collection("Help Desk").document(userID);

                    Map<String, Object> user = new HashMap<>();
                    user.put("User Name", usernameHelp);
                    user.put("Mobile Number", mobileHelp);
                    user.put("Email Address", emailHelp);
                    user.put("Query or Problem",queryHelp);
                    documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(helpDeskActivity.this, "Query Sended Succefully", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(helpDeskActivity.this, "Error in sending", Toast.LENGTH_SHORT).show();

                        }
                    });

                }





            }
        });

    }
}
