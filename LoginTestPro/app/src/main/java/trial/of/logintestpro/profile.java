package trial.of.logintestpro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;


public class profile extends Fragment {

    TextView Username, Mobile, Email, Gameid, GameUserName;
    TextView LogoutProfile, EditInfoProfile, SupportProfile, ChangePassProfile;
    FirebaseAuth auth;
    FirebaseFirestore fstore;
    String userId;



    public profile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_profile, container, false);

        LogoutProfile = v.findViewById(R.id.logoutProfileFrag);
        EditInfoProfile=v.findViewById(R.id.editProfileFrag);
        SupportProfile=v.findViewById(R.id.supportProfileFrag);
        ChangePassProfile=v.findViewById(R.id.passwordFrag);

        Username=v.findViewById(R.id.userNameFrag);
        Mobile=v.findViewById(R.id.mobileNoFrag);
        Email=v.findViewById(R.id.emailIdFrag);
        Gameid=v.findViewById(R.id.gameIdFrag);
        GameUserName=v.findViewById(R.id.gameUserNameFrag);

        auth= FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();

        userId = auth.getCurrentUser().getUid();


        DocumentReference documentReference = fstore.collection("Users").document(userId);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                Gameid.setText("Game ID :"+documentSnapshot.getString("GameID"));
                GameUserName.setText("Game Username :"+documentSnapshot.getString("Game UserName"));
                Username.setText(" Username : "+documentSnapshot.getString("User Name"));
                Mobile.setText(" Mobile :"+documentSnapshot.getString("Contact"));
                Email.setText("Email : "+documentSnapshot.getString("Email"));


            }
        });



        LogoutProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Succefull", Toast.LENGTH_SHORT).show();
            }
        });

        EditInfoProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "Editted Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),ProfileActivity.class);
                startActivity(intent);
            }
        });

        SupportProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), helpDeskActivity.class);
                startActivity(intent);

            }
        });

        ChangePassProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), forgotAct.class);
                startActivity(intent);

            }
        });

        return v;
    }
}
