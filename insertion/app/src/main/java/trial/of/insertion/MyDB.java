package trial.of.insertion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class MyDB extends SQLiteOpenHelper {

    Context c;

    public static String DBNAME = "DATABASE";
    public static int VERSION =1;


    public MyDB(Context context) {super(context,DBNAME, null,VERSION);

    c = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            String qry ="create table CONTACTS(Name TEXT, Place TEXT, FOOD TEXT)";
            db.execSQL(qry);
            Toast.makeText(c,"Table created",Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Log.e("MYDB","Something went wrong",e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public boolean insertData (String name, String place, String food){
        try{
            String qry = "insert into CONTACTS values('"+name+"', '"+place+"', '"+food+"')";
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(qry);
            Toast.makeText(c,"Registered Successfully",Toast.LENGTH_LONG).show();
            return true;
        }

        catch (Exception e){
            Log.e("MYDB", "Something Went Wrong db",e);
            return false;
        }
    }

    public boolean deleteData(String food, String place){
        try {
            String qry ="delete from CONTACTS where Food = '"+food+"' and Place = '"+place+"'";
            SQLiteDatabase db =getWritableDatabase();
            db.execSQL(qry);
            Toast.makeText(c,"Deletion complete",Toast.LENGTH_LONG).show();
            return true;
        }
        catch (Exception e){
            Log.e("MYDB","Deletion failed",e);
            return  false;
        }
    }



    public Cursor getAllData(){
        try{
            String qry = "Select Name, Place, Food from CONTACTS";
            SQLiteDatabase db = getWritableDatabase();
            Cursor c= db.rawQuery(qry, null);
            return c;
        }
        catch (Exception e){
            Log.e("MYDB","Error db",e);
            return null;
        }
    }
}
