package trial.of.tournamentact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    Button JoinNowBt;
    Button JoinNowBt2;
    Button JoinNowBt3;
    Button TourNa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JoinNowBt=findViewById(R.id.JoinNowBtn);
        JoinNowBt2=findViewById(R.id.JoinNowBtn2);
        JoinNowBt3=findViewById(R.id.JoinNowBtn3);
        TourNa=findViewById(R.id.TOur);


        TourNa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, TournamentMap.class);
                startActivity(intent);


            }
        });



        JoinNowBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Currently Not Available We Regret for inconvenience", Toast.LENGTH_SHORT).show();

            }
        });


        JoinNowBt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Currently Not Available We Regret for inconvenience", Toast.LENGTH_SHORT).show();
            }
        });

        JoinNowBt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);

            }
        });




    }
}
