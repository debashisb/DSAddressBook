package com.datasoftbd.bddeb.dsaddressbook;


import android.content.Context;
import android.database.Cursor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ShowAll extends AppCompatActivity {


     DatabaseHelper myDB=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstancstate){
        super.onCreate(savedInstancstate);
        setContentView(R.layout.activity_showall);



        ListView listView = (ListView) findViewById(R.id.showallitem);

        new AsyncTasking(this).execute();



    }

}
