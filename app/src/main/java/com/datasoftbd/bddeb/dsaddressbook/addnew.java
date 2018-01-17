package com.datasoftbd.bddeb.dsaddressbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class addnew extends AppCompatActivity {


    EditText textName,textMobile,textMobileOffice,textEmail,textAddress;
    Button saving, resetting;
    DatabaseHelper myDB;

    protected void onCreate(Bundle InstanceState){
        super.onCreate(InstanceState);
        setContentView(R.layout.activity_addnew);
        myDB=new DatabaseHelper(this);

        textName= (EditText)findViewById(R.id.name);
        textMobile=(EditText) findViewById(R.id.mobile_personal);
        textMobileOffice=(EditText) findViewById(R.id.mobile_office);
        textEmail=(EditText)findViewById(R.id.email);
        textAddress=(EditText)findViewById(R.id.address);
        saving=(Button)findViewById(R.id.saving);
        resetting=(Button)findViewById(R.id.reset);
        Saving();




    }

    public void Saving(){
        saving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean Inserted=myDB.InsertData(textName.getText().toString(),
                        textMobile.getText().toString(),
                        textMobileOffice.getText().toString(),
                        textEmail.getText().toString(),
                        textAddress.getText().toString());

                if(Inserted=true)
                    Toast.makeText(addnew.this,"Item Saved",Toast.LENGTH_LONG).show();

                else
                    Toast.makeText(addnew.this,"Error, Data Not Saved",Toast.LENGTH_LONG).show();
            }
        });
    }
}
