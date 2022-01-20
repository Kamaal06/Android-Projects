package trial.of.intern1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;


public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter (Context context){
        this.context=context;
    }

    public int[] slide_images ={
            R.drawable.h1,
            R.drawable.h4,
            R.drawable.h5
    };

    public String [] slide_headings = {
            "Plan your trip",
            "Book your flight",
            "Explore the world"
    };

    public String[] slide_desc={
            "Find the trip that suits you thanks\n" +
                    "to our trusted partners.",
            "After you’ve planned your trip, it’s a \n" +
                    "good time to book your flight.",

            "Easy discovering new places and \n" +
                    "cultures, Be curious ."
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                  return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);


        ImageView slideImageView = (ImageView) view.findViewById(R.id.imageView3);
        TextView slideHead = (TextView) view.findViewById(R.id.textMain1);
        TextView slideDesc = (TextView) view.findViewById(R.id.descText2);

        slideImageView.setImageResource(slide_images[position]);
        slideHead.setText(slide_headings[position]);
        slideDesc.setText(slide_desc[position]);

        container.addView(view);
        return view;


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((ConstraintLayout)object);

    }
}
