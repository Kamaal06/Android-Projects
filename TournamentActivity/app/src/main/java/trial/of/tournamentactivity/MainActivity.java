package trial.of.tournamentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button SoloJoinBtn, DuoJoinBtn, SquadJoinBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SoloJoinBtn=findViewById(R.id.joinBtnSolo);
        DuoJoinBtn=findViewById(R.id.joinBtnDuo);
        SquadJoinBtn=findViewById(R.id.joinBtnSquad);

        SoloJoinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SoloPaymentActivity.class);
                startActivity(intent);
            }
        });

        DuoJoinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, DuoPaymentActivity.class);
                startActivity(intent);

            }
        });


        SquadJoinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, SquadPaymentActivity.class);
                startActivity(intent);

            }
        });
    }
}
