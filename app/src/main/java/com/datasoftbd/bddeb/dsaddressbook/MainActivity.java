package com.datasoftbd.bddeb.dsaddressbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB=new DatabaseHelper(this);

    }


    public void AddNew(View view){
        Intent addNew=new Intent(this,addnew.class);
        startActivity(addNew);
    }

    public void searchItem(View view){
        Intent searchAll=new Intent(this,searchContacts.class);
        startActivity(searchAll);
    }

    public void showAll(View view){
        Intent showAllContact=new Intent(this,ShowAll.class);
        startActivity(showAllContact);
    }
}