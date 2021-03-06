package trial.of.contactdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="mylist.db";
    public static final String TABLE_NAME="mylist_data";
    public static final String COL1="ID";
    public static final String COL2="ITEM1";

    public DataBaseHelper(Context context) { super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable ="CREATE TABLE "+TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+"ITEM1 TEXT)";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("Drop IF TAble EXISTS"+ TABLE_NAME);
    }

    public boolean addData(String item1){

        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item1);

        long result =db.insert(TABLE_NAME,null, contentValues);

        if (result == -1){
            return false;
        }

        else {
            return true;
        }
    }


    public boolean addDATA(String item2){

        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item2);

        long result =db.insert(TABLE_NAME,null, contentValues);

        if (result == -1){
            return false;
        }

        else {
            return true;
        }
    }



    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return data;
    }
}
