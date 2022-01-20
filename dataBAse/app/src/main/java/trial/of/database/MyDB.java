package trial.of.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MyDB extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="mylist.db";
    public static final String TABLE_NAME="mylist_data";
    public static final String Col1="ID";
    public static final String Col2="ITEM1";
    public static final int VERSION=1;


    public MyDB(Context context) {super (context, DATABASE_NAME,null,VERSION);

   // public MyDB( Context context) { super(context,DATABASE_NAME,factory:null,VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = "CREATE TABLE " +TABLE_NAME +"(ID INTERGER PRIMARY KEY AUTOINCREMENT, " + " ITEM1 TEXT)";
       db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP IF TABLE EXISTS " +TABLE_NAME);
    }


    public boolean addData(String item1){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col2, item1);


            long result = db.insert(TABLE_NAME, null, contentValues);

                if(result == -1){
                    return false;
                }

                else {
                    return true;
                }

    }


    public Cursor getListContents(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data=db.rawQuery("SELECT * FROM "+ TABLE_NAME,null);
        return data;
    }

}
