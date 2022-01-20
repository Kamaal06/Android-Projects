package trial.of.uchub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TournamentActivity extends AppCompatActivity {


    Button JoinNowBt;
    Button JoinNowBt2;
    Button JoinNowBt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament);



        JoinNowBt=findViewById(R.id.JoinNowBtn);
        JoinNowBt2=findViewById(R.id.JoinNowBtn2);
        JoinNowBt3=findViewById(R.id.JoinNowBtn3);



        JoinNowBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(TournamentActivity.this, "Currently Not Available We Regret for inconvenience", Toast.LENGTH_SHORT).show();

            }
        });


        JoinNowBt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(TournamentActivity.this, "Currently Not Available We Regret for inconvenience", Toast.LENGTH_SHORT).show();
            }
        });

        JoinNowBt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TournamentActivity.this, PaymentActivity.class);
                startActivity(intent);

            }
        });

    }
}
