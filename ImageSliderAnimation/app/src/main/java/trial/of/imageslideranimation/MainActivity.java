package trial.of.imageslideranimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity {

    SliderLayout sliderLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderLayout= findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setScrollTimeInSec(2);

                    setSliderViews();
    }

    private void setSliderViews() {

        for (int i=0; i<=2; i++){

            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (i){

                case 0:
                   sliderView.setImageDrawable(R.drawable.image1);
                    break;

                case 1:
                    sliderView.setImageDrawable(R.drawable.image2);

                    break;

                case 2:
                    sliderView.setImageDrawable(R.drawable.image3);

                    break;
            }

        sliderView.setImageScaleType(ImageView.ScaleType.FIT_CENTER);

            final int finalI =i;

            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(MainActivity.this, "This is Tournament "+ (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            sliderLayout.addSliderView(sliderView);
        }
    }

}
