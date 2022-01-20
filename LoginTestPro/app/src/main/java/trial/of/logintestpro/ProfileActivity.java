package trial.of.logintestpro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class ProfileActivity extends AppCompatActivity {

    EditText GameIdProfile, GameUserNameProfile, UsernameProfile, UserEmailProfile, UserPasswordProfile, MobileNumProfile;
    Button SaveInfo;

    FirebaseAuth auth;
    FirebaseFirestore fstore;
    private String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        GameIdProfile=findViewById(R.id.gameIdProfile);
        GameUserNameProfile=findViewById(R.id.gameUserNameProfile);
        UsernameProfile=findViewById(R.id.userNameProfile);
        UserEmailProfile=findViewById(R.id.emailIdProfile);
        MobileNumProfile=findViewById(R.id.mobileNoProfile);
        SaveInfo=findViewById(R.id.saveProfile);

        auth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        userID=auth.getCurrentUser().getUid();


        DocumentReference documentReference = fstore.collection("Users").document(userID);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                //GameIdProfile.setText(documentSnapshot.getString("GameID"));
                GameIdProfile.setHint("Game ID : "+documentSnapshot.getString("GameID"));
                GameUserNameProfile.setHint("Game Username: "+documentSnapshot.getString("Game UserName"));
                UsernameProfile.setHint("Username : "+documentSnapshot.getString("User Name"));
                MobileNumProfile.setHint("Mobile: "+documentSnapshot.getString("Contact"));
                UserEmailProfile.setHint("Email: "+documentSnapshot.getString("Email"));

            }
        });


        SaveInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(ProfileActivity.this, "Information Save Successfully", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
