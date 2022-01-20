package contact.insertion;

import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ShowDisplay extends AppCompatActivity {

    static MyDB myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_display);

            getSupportActionBar().setTitle("Home");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final LinearLayout lm=(LinearLayout)findViewById(R.id.ShowDisplay);
        myDB =new MyDB(this);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        Cursor c = ShowDisplay.myDB.getAllData();
        c.moveToFirst();

        if (c==null){
            Toast.makeText(getApplicationContext(),"Erro",Toast.LENGTH_LONG).show();
        }

        else {
            while (c.moveToNext()){

                final String name=c.getString(0);
                final  String no=c.getString(1);
                final String address=c.getString(2);

                LinearLayout ll =new LinearLayout(this);
                ll.setOrientation(LinearLayout.HORIZONTAL);

                final TextView Name=new TextView(this);
                Name.setText(name+" ");
                Name.setWidth(320);
                Name.setTextSize(20);
                ll.addView(Name);
                Name.setTextColor(Color.RED);


                final TextView No = new TextView(this);
                No.setText(no +" ");
                No.setWidth(300);
                ll.addView(No);
                No.setTextSize(20);
                No.setTextColor(Color.BLUE);


                final TextView Address =new TextView(this);
                Address.setText(address +" ");
                ll.addView(Address);
                Address.setTextSize(20);
                Address.setTextColor(Color.GREEN);


                Address.setLayoutParams(params);
                lm.addView(ll);
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
