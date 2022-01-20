package trial.of.crudatif;

import android.app.ListActivity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {

    ListActivity listActivity;
    List<model> modelList;
    Context context;

    public CustomAdapter(ListActivity listActivity, List<model> modelList, Context context) {
        this.listActivity = listActivity;
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView= LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.model, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(itemView);

        //handle item

        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                //this will be called when user click item

                String title= modelList.get(position).getTitle();
                String descrip = modelList.get(position).getDescription();
                Toast.makeText(listActivity,title+"\n"+descrip,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
    //bind view / set data

        viewHolder.mTitle.setText(modelList.get().getTitle());
        viewHolder.mdescrip.setText(modelList.get().getDescription());

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
