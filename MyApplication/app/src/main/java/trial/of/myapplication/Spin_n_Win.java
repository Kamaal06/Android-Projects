package trial.of.myapplication;;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;
import java.util.Random;

import okhttp3.internal.cache.DiskLruCache;
import trial.of.myapplication.ButtonCountsS0;
import trial.of.myapplication.R;

public class Spin_n_Win extends AppCompatActivity {

    /*
    Timer-----------------------------------------------------
     */
    private static final long START_TIME_IN_MILLIS = 10000; //86400000;
    private TextView mTextViewCountDown;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis;
    private long mEndTime;

    /*
    FireBase--------------------------------------------------
    */
    private FirebaseDatabase DatabaseS0;
    private FirebaseAuth AuthenticationS0;
    private DatabaseReference mRef;


/*
UI---------------------------------------------------------
 */

    private int SumBp;
    private int SumUc;
    private int ButtonCount12;
    private int  RemClicks , RemSpinCnt;
    private Button spinbutton,LooutS0;
    private boolean AES0;


    TextView textView, spinInfo, degreesInfo12, Baba12, UcView12, BpView13,
            RemSpin12, BySpin23, UserID12,UPdate43,tetst;
    ImageView spinView;
    Random r;


    int degreeP, degreeR, degree_old = 0 , n ,g=1, Parapass12;

    int[] Poor = {90, 180, 270, 350};


    int[] Rich = {45, 45, 135, 135, 225, 225, 225, 225, 225, 315};

    private static final float FACTORS = 22.50f;

//Database


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin_n__win);

        spinbutton = findViewById(R.id.spinBtn);
        LooutS0 = findViewById(R.id.LgOut);
        spinView = findViewById(R.id.arr);
        textView = findViewById(R.id.tVspin);
        UPdate43 = findViewById(R.id.Update43);
        UserID12 = findViewById(R.id.UsrID12);
        UcView12 = findViewById(R.id.Uc_View12);
        BpView13 = findViewById(R.id.bp_View13);
        spinInfo = findViewById(R.id.SpinInfo11);
        degreesInfo12 = findViewById(R.id.SuckItBitch12);
        Baba12 = findViewById(R.id.baba12);
        RemSpin12 = findViewById(R.id.RemSpin12);
        BySpin23 = findViewById(R.id.BySpins12);
        tetst = findViewById(R.id.tetst);
        mTextViewCountDown = findViewById(R.id.text_view_countdown);

//Database------------------------------------------------------------------------------------------
        AuthenticationS0 = FirebaseAuth.getInstance();
        DatabaseS0 = FirebaseDatabase.getInstance();
        mRef = DatabaseS0.getReference();


        FirebaseLoadD(SumUc,SumBp,ButtonCount12,n);
        StartSpin();
        SignOutAcc();
        Update433(SumBp);


        r = new Random();

        mTextViewCountDown.setVisibility(View.INVISIBLE);



    }

/*
-----------------------------------------firebase---------------------------------------------------
*/

    private void FirebaseLoadD(int sumUc, int sumBp,int buttonCount12,int neww) {
        mRef.child(AuthenticationS0.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                UserID12.setText(user.getUsername());
                SumUc = user.getUcx();
                SumBp = user.getBpx();

                RemSpinCnt = user.getSpins();
                RemClicks = user.getSpinsads();
                UcView12.setText(user.getUcx() + " " + "UC");
                BpView13.setText(user.getBpx() + " " + "BP");
                RemSpin12.setText("Spins Left" + ":" + RemSpinCnt);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mRef.child("ButtonsCount").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ButtonCountsS0 buttonCountsS0 = snapshot.getValue(ButtonCountsS0.class);
                ButtonCount12 = buttonCountsS0.getButtonCount12();
                Baba12.setText("ButtonCount" + " " + ButtonCount12);

                if(!AES0) {
                    n = buttonCountsS0.getButtonCount12();
                    AES0 = true;
                }
                tetst.setText("as"+" "+ n);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
/*
-----------------------------------------firebase---------------------------------------------------
*/


    private void StartSpin() {

        spinbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (RemSpinCnt == 0 && RemClicks == 0) {

                    spinbutton.setEnabled(false);
                    v.setEnabled(true);
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Opps! Out of Spins",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }
                else if(RemClicks == 5 && RemSpinCnt == 0){
                    spinbutton.setEnabled(false);
                    v.setEnabled(true);
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Come Back Tommorow!",
                            Toast.LENGTH_SHORT);
                    toast.show();
                    mTextViewCountDown.setVisibility(View.VISIBLE);
                    startTimer();
                }
                else {

                    ButtonCount12++;
                    RemSpinCnt--;
                    UpdateClicksS0(RemSpinCnt);

                    Baba12.setText("ButtonCount" + " " + ButtonCount12);
                    RemSpin12.setText("Spins Left" + ":" + RemSpinCnt);


                    if (ButtonCount12 != g && ButtonCount12 == n + (g*2)) {
                        degree_old = Rich[degreeR] % 360;
                        degreeR = r.nextInt(Rich.length);
                        Parapass12 = Rich[degreeR];
                        g++;
                    }
                    else if(ButtonCount12 < n + (g * 2)) {
                        degree_old = Poor[degreeP] % 360;
                        degreeP = r.nextInt(Poor.length);
                        Parapass12 = Poor[degreeP];
                    }
                    else {
                        degree_old = Poor[degreeP] % 360;
                        degreeP = r.nextInt(Poor.length);
                        Parapass12 = Poor[degreeP];
                    }


                    //fromDegrees:0 ,toDegrees:-55,
                    RotateAnimation rotate = new RotateAnimation(degree_old, Parapass12 + 3600,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setDuration(3600);
                    rotate.setFillAfter(true);
                    rotate.setInterpolator(new DecelerateInterpolator());
                    rotate.setAnimationListener(new Animation.AnimationListener() {

                        @Override
                        public void onAnimationStart(Animation animation) {
                            spinbutton.setClickable(false);
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {


                            if (Parapass12 == Rich[degreeR]) {
                                spinbutton.setClickable(true);
                                SumUc = SumUc + currentNumber(Parapass12);
                                textView.setText(currentNumber(Parapass12) + " " + "UCP"); //Middle
                                UcView12.setText(SumUc + " " + "UC");//TopRight
                                UpDateUc(SumUc);
                                UpdateButtonCount12(ButtonCount12);


                            } else if (Parapass12 == Poor[degreeP]) {
                                spinbutton.setClickable(true);
                                SumBp = SumBp + currentNumber(Parapass12);
                                textView.setText(currentNumber(Parapass12) + " " + "BPC");
                                BpView13.setText(SumBp + " " + "BP");
                                UpDateBp(SumBp);
                                UpdateButtonCount12(ButtonCount12);
                            }
                            else{
                                spinbutton.setClickable(true);
                            }


                            spinInfo.setText("Degree" + " " + Parapass12); //working

                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }

                    });

                    spinView.startAnimation(rotate);
                }
            }
        });

        BySpin23.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                if (RemClicks == 5) {
                    BySpin23.setEnabled(false);
                    Toast.makeText(Spin_n_Win.this, "Purchased Limit Reached!", Toast.LENGTH_SHORT).show();
                }
                else{
                    RemSpinCnt = RemSpinCnt + 1;
                    RemSpin12.setText("Spins Left" + ":" + RemSpinCnt );
                    RemClicks++;
                    UpdateClicksAds(RemClicks);
                    UpdateClicksS0(RemSpinCnt);
                }
            }
        });
    }

    private void UpDateUc(int sumUc) {
        final int aS0;
        aS0 = sumUc;
        mRef.child(AuthenticationS0.getUid()).child("ucx").setValue(aS0);
    }
    private void UpDateBp(int sumBp){
        final int bS0;
        bS0 = sumBp;
        mRef.child(AuthenticationS0.getUid()).child("bpx").setValue(bS0);
    }
    private void UpdateButtonCount12(int buttonCount12){
        final int cS0;
        cS0 = buttonCount12;
        mRef.child("ButtonsCount").child("buttonCount12").setValue(cS0);
    }
    private void resetSpins(int remSpinCnt){
        final int dS0;
        dS0 = 5;
        mRef.child(AuthenticationS0.getUid()).child("spins").setValue(dS0);
    };
    private void resetSpinsAds(int remClicks){
        final int eS0;
        eS0 = 0;
        mRef.child(AuthenticationS0.getUid()).child("spinsads").setValue(eS0);
    }
    private void UpdateClicksAds(int remClicks){
        final int fS0;
        fS0 = RemClicks;
        mRef.child(AuthenticationS0.getUid()).child("spinsads").setValue(fS0);
    }
    private void UpdateClicksS0(int remSpinCnt){
        final int gS0;
        gS0 = RemSpinCnt;
        mRef.child(AuthenticationS0.getUid()).child("spins").setValue(gS0);
    }





    private Integer currentNumber(int degrees){
        int scores = 0;

        degreesInfo12.setText("Degrees"+ " " + degrees);
        if (degrees >= (FACTORS * 1) && degrees < (FACTORS *  3)){
            scores = 5;
        }if (degrees >= (FACTORS * 3) && degrees < (FACTORS * 5)){
            scores = 100;
        }if (degrees >= (FACTORS * 5) && degrees < (FACTORS * 7)){
            scores = 3;
        }if (degrees >= (FACTORS * 7) && degrees < (FACTORS * 9)){
            scores = 50;
        }if (degrees >= (FACTORS * 9) && degrees < (FACTORS * 11)){
            scores = 1;
        }if (degrees >= (FACTORS * 11) && degrees < (FACTORS * 13)){
            scores = 20;
        }if (degrees >= (FACTORS * 13) && degrees < (FACTORS * 15)){
            scores = 50;
        }
        if
        ((degrees >= (FACTORS * 15) && degrees < 360) || (degrees >= 0 && degrees < (FACTORS * 1))){
            scores = 500;
        }
        return (scores);
    }
    private void Update433(int sumBp) {

    }

    private void SignOutAcc() {
        LooutS0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Spin_n_Win.this , MainActivity.class));
                finish();
                Toast.makeText(Spin_n_Win.this, "Logged Out Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

/*
------------------------------------------!Timer----------------------------------------------------
 */



    private void startTimer() {
        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis;
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }
            @Override
            public void onFinish() {
                mTimerRunning = false;
                resetTimer();

            }
        }.start();
        mTimerRunning = true;

    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        resetSpins(RemSpinCnt);
        resetSpinsAds(RemClicks);
        mTextViewCountDown.setVisibility(View.INVISIBLE);
    }
    private void updateCountDownText() {
        int hours = (int) (mTimeLeftInMillis / 1000) / 3600;
        int minutes = (int) ((mTimeLeftInMillis / 1000) % 3600) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted;
        if (hours > 0) {
            timeLeftFormatted = String.format(Locale.getDefault(),
                    "%d:%02d:%02d", hours, minutes, seconds);
        } else {
            timeLeftFormatted = String.format(Locale.getDefault(),
                    "%02d:%02d", minutes, seconds);
        }
        mTextViewCountDown.setText(timeLeftFormatted);

    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong("millisLeft", mTimeLeftInMillis);
        editor.putBoolean("timerRunning", mTimerRunning);
        editor.putLong("endTime", mEndTime);
        editor.apply();
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        mTimeLeftInMillis = prefs.getLong("millisLeft", START_TIME_IN_MILLIS);
        mTimerRunning = prefs.getBoolean("timerRunning", false);
        updateCountDownText();

        if (mTimerRunning) {
            mEndTime = prefs.getLong("endTime", 0);
            mTimeLeftInMillis = mEndTime - System.currentTimeMillis();
            if (mTimeLeftInMillis < 0) {
                mTimeLeftInMillis = 0;
                mTimerRunning = false;
                updateCountDownText();

            } else {
                startTimer();
            }
        }
    }


}



