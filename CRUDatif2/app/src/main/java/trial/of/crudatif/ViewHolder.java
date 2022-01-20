package trial.of.crudatif;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder  extends RecyclerView.ViewHolder{

    TextView mTitle, mdescrip;
    View mView;
    boolean True;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView=itemView;


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mClickListener.onItemClick(v, getAdapterPosition());
            }
        });

        // Item Long Click Listener



        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemLongClick(v, getAdapterPosition());

                True=true;
            }
        });

    //initialize View with model Layout
        mTitle=itemView.findViewById(R.id.rtitle);
        mdescrip=itemView.findViewById(R.id.rDes);

    }
private ViewHolder.ClickListener mClickListener;
    public interface ClickListener{
        void  onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public  void setOnClickListener(ViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }

}
