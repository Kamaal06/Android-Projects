package trial.of.imageretfb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.RecylerViewHolder> {

    private Context mContext;
    private List<teacher> Teachers;
    private AdapterView.OnItemClickListener mListener;

    public recyclerAdapter(Context context,List<teacher>uploads){
        mContext = context;
        Teachers = uploads;
    }

    @NonNull
    @Override
    public recyclerAdapter.RecylerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(mContext).inflate(R.layout.activity_row_models,parent,false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.RecylerViewHolder holder, int position) {
       teacher  currentTeacher = Teachers.get(position);
       holder.nameTextView.setText(currentTeacher.getName());
       holder.descriptionTextView.setText(currentTeacher.getDescription());
       holder.dateTextView.setText(getDateToday());
    }
}
