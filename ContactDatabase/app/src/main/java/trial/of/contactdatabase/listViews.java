package trial.of.contactdatabase;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listViews extends AppCompatActivity {

    DataBaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_views);


        final ListView listView =(ListView)findViewById(R.id.listVIews);
        final ListView contacts=(ListView)findViewById(R.id.Contact);


        Button btnhome = (Button)findViewById(R.id.btnHome);

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(listViews.this,MainActivity.class));

                //Intent intent =new Intent(listViews.this,MainActivity.class);
                //startActivity(intent);
            }
        });
        myDB = new DataBaseHelper(this);


        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getListContents();

        if(data.getCount() == 0){
            Toast.makeText(listViews.this,"The DataBase is Empty", Toast.LENGTH_LONG).show();
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
