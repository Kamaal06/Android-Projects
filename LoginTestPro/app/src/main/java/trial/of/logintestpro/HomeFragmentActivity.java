package trial.of.logintestpro;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragmentActivity extends Fragment {


    ImageView spinandwincard, watchandearncard,  tournamentcard, mastertournamentcard;
    private Button logout;
    private TextView UserNameDis;

    String displayName;
    ActionBar userActionbar;
    SliderLayout sliderLayout;

    FirebaseFirestore db;
    FirebaseAuth auth;
    String usedID;


    public HomeFragmentActivity() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home_activity, container, false);


        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        logout = v.findViewById(R.id.logOutBtn);
        spinandwincard = v.findViewById(R.id.spinCardHome);
        watchandearncard = v.findViewById(R.id.watchCardHome);
        tournamentcard = v.findViewById(R.id.tournamentCardHome);
        mastertournamentcard = v.findViewById(R.id.masterTournamentCardHome);

        sliderLayout= v.findViewById(R.id.imageSlider);



        usedID = auth.getCurrentUser().getUid();

      DocumentReference documentReference = db.collection("Users").document(usedID);
        documentReference.addSnapshotListener( new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {


            }
        });




       // DocumentReference documentReference =db.collection("Users").document(usedID);


        /*
        DocumentReference documentReference =db.collection("Users").document(usedID);
         documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                UserNameDis.setText(documentSnapshot.getString("User Name"));
                displayName=UserNameDis.getText().toString();

            }
        });

 */




        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setScrollTimeInSec(2);


        setSliderViews();

        spinandwincard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


        watchandearncard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




        tournamentcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity().getApplication(), TournamentActivity.class));

            }
        });

        mastertournamentcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), " We'll Start This ASAP, regret for delay", Toast.LENGTH_SHORT).show();

            }
        });



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getActivity().getApplication(), loginAct.class));
            }
        });




       /* auth=FirebaseAuth.getInstance();

        logout=findViewById(R.id.logout_btn);
        updatePassBTN=findViewById(R.id.update_pass_btn);

        if (auth.getCurrentUser()==null){
            Intent intent = new Intent(MainActivity.this, loginAct.class);
            startActivity(intent);
            finish();
        }

        else {
            Toast.makeText(this, "Already Logged in", Toast.LENGTH_SHORT).show();
        }

        updatePassBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, updatPass.class);
                startActivity(intent);
                finish();
            }
        });

        */


        return v;
    }

    private void setSliderViews() {

            for (int i=0; i<=2; i++){

                DefaultSliderView sliderView = new DefaultSliderView(getContext());

                switch (i){

                    case 0:
                        sliderView.setImageDrawable(R.drawable.image1);
                        sliderView.setDescription("Win upto 5000rs Cash");
                        break;

                    case 1:
                        sliderView.setImageDrawable(R.drawable.image2);
                        sliderView.setDescription("Get chance to WIN upto 600 UC");

                        break;

                    case 2:
                        sliderView.setImageDrawable(R.drawable.image3);
                        sliderView.setDescription("Get chance to win upto 1500 UC");

                        break;
                }

                sliderView.setImageScaleType(ImageView.ScaleType.FIT_CENTER);

                final int finalI =i;

                sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(SliderView sliderView) {
                        Toast.makeText(getActivity(), "This is Tournament "+ (finalI + 1), Toast.LENGTH_SHORT).show();
                    }
                });

                sliderLayout.addSliderView(sliderView);

            }
     }
}
