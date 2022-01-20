package trial.of.logintestpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CoinToUcActivityRedeem extends AppCompatActivity {

    private TextView ucPoints;
    private TextView BpCoins;
    private EditText conPoints;
    private Button ConButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_to_uc_redeem);



        ucPoints=findViewById(R.id.textViewUC);
        BpCoins=findViewById(R.id.textViewCoins);
        conPoints=findViewById(R.id.coinEdit);
        ConButt=findViewById(R.id.convertButton);

        ucPoints.setText("10");
        BpCoins.setText("4000");


        String edit=conPoints.getText().toString();

        final int PointsInt = new Integer(edit).intValue();


        // final int PointsInt=Integer.parseInt(conPoints.getText().toString());
        final int BpPointsInt=Integer.parseInt(BpCoins.getText().toString());


        ConButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PointsInt<= BpPointsInt && PointsInt%1000==0){

                   /* int ucInc, UcF;
                    ucInc=PointsInt/1000;
                    UcF=Integer.parseInt(ucPoints.getText().toString()+ucInc);
                    ucPoints.setText(UcF);
                    */

                    Toast.makeText(CoinToUcActivityRedeem.this, "Ok", Toast.LENGTH_SHORT).show();

                }


                else
                {
                    Toast.makeText(CoinToUcActivityRedeem.this, "Enter Valid BP number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
