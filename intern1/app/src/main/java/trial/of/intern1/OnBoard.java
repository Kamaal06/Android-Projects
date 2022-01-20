package trial.of.intern1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class OnBoard extends AppCompatActivity {


    private ViewPager mSliderViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;

    private Button mNextBtn;
    private Button mPrevBtn;

    private int mCurrentPage;

    private SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);

        mSliderViewPager = (ViewPager) findViewById(R.id.sliderView);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);

        mNextBtn = (Button) findViewById(R.id.next);
        mPrevBtn= (Button)findViewById(R.id.back);

        sliderAdapter = new SliderAdapter(this);
        mSliderViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSliderViewPager.addOnPageChangeListener(viewListner);


        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mSliderViewPager.setCurrentItem(mCurrentPage+1);


             }
        });



    /*    if(mNextBtn.getText()=="Finish"){

            mNextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(OnBoard.this, LogSign_Page.class);
                    startActivity(intent);
                }
            });

        }*/



        mPrevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSliderViewPager.setCurrentItem(mCurrentPage-1);
            }
        });
    }

    public void addDotsIndicator( int position){
        mDots = new TextView[3];
        mDotLayout.removeAllViews();

        for( int i=0; i< mDots.length; i++){

            mDots[i] =new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorAccent));

            mDotLayout.addView(mDots[i]);

        }
        if (mDots.length>0){

            mDots[position].setTextColor(getResources().getColor(R.color.colorPrimary));

        }
    }


    ViewPager.OnPageChangeListener viewListner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);
            mCurrentPage =i;

            if(i==0){
                mNextBtn.setEnabled(true);
                mPrevBtn.setEnabled(false);
                mPrevBtn.setVisibility(View.INVISIBLE);

                mNextBtn.setText("Next");
                mPrevBtn.setText("");

            }

            else if(i ==mDots.length -1){

                mNextBtn.setEnabled(true);
                mPrevBtn.setEnabled(true);
                mPrevBtn.setVisibility(View.VISIBLE);

                mPrevBtn.setText("Back");
                mNextBtn.setText("Finish");

                mNextBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(OnBoard.this, LogSign_Page.class);
                        startActivity(intent);

                    }
                });

            }

            else{
                mNextBtn.setEnabled(true);
                mPrevBtn.setEnabled(true);
                mPrevBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText("Next");
                mPrevBtn.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


}
