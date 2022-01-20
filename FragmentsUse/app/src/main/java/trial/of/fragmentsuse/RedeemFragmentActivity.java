package trial.of.fragmentsuse;

import android.graphics.Point;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class RedeemFragmentActivity extends Fragment {

    private TextView ucPoints;
    private TextView BpCoins;
    private EditText conPoints;
    private Button ConButt;

    public RedeemFragmentActivity() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_redeem_activity, container, false);

        ucPoints=v.findViewById(R.id.textViewUC);
        BpCoins=v.findViewById(R.id.textViewCoins);
        conPoints=v.findViewById(R.id.coinEdit);
        ConButt=v.findViewById(R.id.convertButton);

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

                    Toast.makeText(getActivity(), "Ok", Toast.LENGTH_SHORT).show();

                }


                else
                    {
                    Toast.makeText(getActivity(), "Enter Valid BP number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;

    }
}
