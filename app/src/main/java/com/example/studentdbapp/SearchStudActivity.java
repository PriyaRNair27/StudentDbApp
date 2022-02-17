package com.example.studentdbapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchStudActivity extends AppCompatActivity {
EditText e1,e2,e3,e4;
AppCompatButton b1,b2;
String getadmissionnumber,getname,getrollnumber,getcollege;
DatabaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_stud);
        helper=new DatabaseHelper(this);
        helper.getWritableDatabase();

        e1=(EditText) findViewById(R.id.admissionnumber);
        e2=(EditText) findViewById(R.id.name);
        e3=(EditText) findViewById(R.id.rollnumber);
        e4=(EditText) findViewById(R.id.college);
        b1=(AppCompatButton) findViewById(R.id.search);
        b2=(AppCompatButton) findViewById(R.id.back);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getadmissionnumber=e1.getText().toString();
                getname=e2.getText().toString();
                getrollnumber=e3.getText().toString();
                getcollege=e4.getText().toString();
                Cursor c= helper.searchData(getadmissionnumber);
                if(c.getCount()==0)
                {
                    e2.setText("");
                    e3.setText("");
                    e4.setText("");
                    Toast.makeText(getApplicationContext(), "invalid admission number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    while (c.moveToNext())
                    {
                        getname=c.getString(1);
                        getrollnumber=c.getString(3);
                        getcollege=c.getString(4);
                    }
                    e2.setText(getname);
                    e3.setText(getrollnumber);
                    e4.setText(getcollege);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}