package trial.of.database;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewList extends AppCompatActivity {

    MyDB myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);

        ListView listView=(ListView)findViewById(R.id.listView);
        myDB = new MyDB(this);

        ArrayList<String> theList=new ArrayList<>();
        Cursor data =myDB.getListContents();

        if(data.getCount()==0){
            Toast.makeText(ViewList.this,"Database was empty",Toast.LENGTH_LONG).show();
            }
        else {
            while (data.moveToNext()){
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);
            }
        }
    }
}
