package com.datasoftbd.bddeb.dsaddressbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.widget.EditText;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="contacts.db";
    public static final String TABLE_NAME="records";
    public static final String col1="ID";
    public static final String col2="Name";
    public static final String col3="Mobile1";
    public static final String col4="Mobile2";
    public static final String col5="Email";
    public static final String col6="Address";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT, Mobile1 INTEGER, Mobile2 INTEGER,Email TEXT,Address TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);

        onCreate(sqLiteDatabase);
    }

    public boolean InsertData(String Name, String Mobile1, String Mobile2, String Email, String Address){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,Name);
        contentValues.put(col3,Mobile1);
        contentValues.put(col4,Mobile2);
        contentValues.put(col5,Email);
        contentValues.put(col6,Address);
        long result=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        if(result==-1)
            return false;

        else
            return true;

    }


   public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
       return data;

    }

}