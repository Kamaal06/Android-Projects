package trial.of.insertion;

import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ShowDATA extends AppCompatActivity {

    static  MyDB myDB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_d_a_t);

            final LinearLayout lm =(LinearLayout) findViewById(R.id.ShowDATA);
            myDB = new MyDB(this);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);

        Cursor c = ShowDATA.myDB.getAllData();
        c.moveToFirst();

        if(c == null){
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
        }

        else {
            while (c.moveToNext()){
                final String name = c.getString(0);
                final String place = c.getString(1);
                final String food = c.getString(2);

                LinearLayout ll =new LinearLayout(this);
                ll.setOrientation(LinearLayout.HORIZONTAL);

                final TextView nm =new TextView(this);
                nm.setText(name+" ");
                nm.setWidth(320);
                ll.addView(nm);
                nm.setTextSize(20);
                nm.setTextColor(Color.RED);


                final TextView pl = new TextView(this);
                pl.setText(place +" ");
                pl.setWidth(300);
                ll.addView(pl);
                pl.setTextSize(20);

                final TextView fd =new TextView(this);
                fd.setText(food +" ");
                 ll.addView(fd);
                 fd.setTextSize(20);

                 fd.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         String [] operations = {"Delete","Update"};
                         AlertDialog.Builder builder = new AlertDialog.Builder(ShowDATA.this);
                         builder.setTitle("operations");
                         builder.setItems(operations, new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {

                                 if (which == 0) {
                                     boolean result = ShowDATA.myDB.deleteData(food, place);
                                     if (result) {
                                         Toast.makeText(ShowDATA.this, name + " Deleted", Toast.LENGTH_LONG).show();
                                     }
                                 } else {
                                     Toast.makeText(ShowDATA.this, "Deletion Failed", Toast.LENGTH_LONG).show();
                                 }
                             }
                         });
                       builder.show();
                     }
                     });
                    fd.setLayoutParams(params);
                    lm.addView(ll);
            }
        }
    }
}
