package trial.of.uchub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {



    ImageView spinandwincard, watchandearncard, quizcard,tournamentcard, mastertournamentcard, helpdeskcard;


  /*  private FirebaseAuth auth;
    private Button logout;
    private Button updatePassBTN;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinandwincard=findViewById(R.id.spinCardHome);
        watchandearncard=findViewById(R.id.watchCardHome);
        quizcard=findViewById(R.id.quizCardHome);
        tournamentcard=findViewById(R.id.tournamentCardHome);
        mastertournamentcard=findViewById(R.id.masterTournamentCardHome);
        helpdeskcard=findViewById(R.id.helpCardHome);



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


        quizcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        tournamentcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TournamentActivity.class);
                startActivity(intent);
            }
        });

        mastertournamentcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        helpdeskcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(MainActivity.this, loginAct.class);
                startActivity(intent);
                finish();
            }
        });

        updatePassBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, updatPass.class);
                startActivity(intent);
                finish();
            }
        });

        */

    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.);
        return true;
    }

     */


}
