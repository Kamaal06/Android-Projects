package trial.of.logintestpro;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class redeemIcon extends Fragment {


ImageView CoinToUc, UcToCash, RequestUc;
    public redeemIcon() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_redeem_icon, container, false);

        CoinToUc= v.findViewById(R.id.coinToUcRedeem);
        UcToCash=v.findViewById(R.id.ucToCashRedeem);
        RequestUc=v.findViewById(R.id.ucRedeem);


        CoinToUc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), CoinToUcActivityRedeem.class);
                startActivity(intent);

            }
        });


        UcToCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        RequestUc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), UcRequestActivity.class);
                startActivity(intent);

            }
        });

        return v;

    }
}
