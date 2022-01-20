package trial.of.spinwin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button  spinbutton;
   // TextView spintv;
    ImageView spinView;

    Random r;
    int degree=0, degree_old=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinbutton=findViewById(R.id.spinBtn);
        spinView=findViewById(R.id.spin);
       // spintv=findViewById(R.id.tVspin);


        r=new Random();

        spinbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                degree_old=degree%360;
                degree=r.nextInt(360)+3600;

                RotateAnimation rotate = new RotateAnimation(degree_old, degree,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                rotate.setDuration(3600);
                rotate.setFillAfter(true);
                rotate.setInterpolator(new DecelerateInterpolator());
                rotate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                 spinView.startAnimation(rotate);
            }
        });

    }
}
