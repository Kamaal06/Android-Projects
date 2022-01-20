package trial.of.logintestpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TournamentActivity extends AppCompatActivity {

    Button JoinBtnSolo;
    Button JoinBtnDuo;
    Button JoinBtnSquad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament);



        JoinBtnSolo=findViewById(R.id.joinBtnSolo);
        JoinBtnDuo=findViewById(R.id.joinBtnDuo);
        JoinBtnSquad=findViewById(R.id.joinBtnSquad);



        JoinBtnSolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TournamentActivity.this, SoloPaymentActivity.class);
                startActivity(intent);

            }
        });


        JoinBtnDuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TournamentActivity.this, DuoPaymentActivity.class);
                startActivity(intent);
            }
        });

        JoinBtnSquad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TournamentActivity.this, PaymentActivity.class);
                startActivity(intent);

            }
        });

    }
}
