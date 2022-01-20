package contact.insertion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

class MyDB<context> extends SQLiteOpenHelper {

    Context c;

    public static String DBNAME = "DATABASE";
    public static int VERSION = 1;
    public MyDB(Context context) {
        super(context, DBNAME, null, 1);
        c = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            String qry = "CREATE TABLE CONTACTS(Name TEXT, No INTEGER, Address Text)";
            db.execSQL(qry);

        }
        catch (Exception e) {
            Log.e("MYDB", "Something Went Wrong");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public boolean insertData(String name, String no, String add) {

        try {

            String qry = "insert into CONTACTS values('" + name + "', '" + no + "', '" + add + "')";
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(qry);
            return true;
        }
        catch (Exception e) {
            Log.e("MYDB", "Deletion Failed");
            return false;
        }

    }

    public boolean updateData(String newName, int newPhone, String newAdd , String oldname) {
        try {
            String qry = "update CONTACTS set Name = '"+newName+"', No = "+newPhone+", Address = '" +newAdd+"' where Name ='"+oldname+"' ";
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(qry);
            Toast.makeText(c, "Update", Toast.LENGTH_LONG).show();
            return true;
        } catch (Exception e) {
            Log.e("MYDB", "UPDATION IN DATA", e);
            return false;
        }
    }

    public Cursor getAllData() {
        try {

            String qry = "Select * from CONTACTS";
            SQLiteDatabase db = getWritableDatabase();
            Cursor c = db.rawQuery(qry, null);
            return c;
        } catch (Exception e) {

            Log.e("MYDB", "ERROR DB");
            return null;
        }

    }
}



