

package com.datasoftbd.bddeb.dsaddressbook;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.datasoftbd.bddeb.dsaddressbook.DatabaseHelper.TABLE_NAME;


public class AsyncTasking extends AsyncTask<Void,Void,Cursor> {

    Context context;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    ListView listView ;

    public AsyncTasking(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        databaseHelper=new DatabaseHelper(context);
        db = databaseHelper.getWritableDatabase();
        listView = (ListView)((AppCompatActivity) context).findViewById(R.id.showallitem);
    }

    @Override
    protected Cursor doInBackground(Void... voids) {



        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

    protected void onPostExecute(Cursor data){




        ArrayList<String> theList = new ArrayList<>();
        Cursor results = data;


        if(results.getCount() == 0){
            Toast.makeText(context, "There are no contents in this list!", Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                theList.add(results.getString(1));
                theList.add(results.getString(2));
                Log.e("ASYNC",results.getString(1));
            }

            ListAdapter listAdapter = new ArrayAdapter<>(((AppCompatActivity) context),android.R.layout.simple_list_item_1,theList);
            listView.setAdapter(listAdapter);
        }
    }
}


