package com.example.studentdbapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudentActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    AppCompatButton b1,b2;
    String getname,getadmissionnumber,getrollnumber,getcollege;
    DatabaseHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        dbhelper=new DatabaseHelper(this);
        dbhelper.getWritableDatabase();
        e1=(EditText) findViewById(R.id.name);
        e3=(EditText) findViewById(R.id.admissionnumber);
        e2=(EditText) findViewById(R.id.rollnumber);
        e4=(EditText) findViewById(R.id.college);
        b1=(AppCompatButton) findViewById(R.id.submit);
        b2=(AppCompatButton) findViewById(R.id.back);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getname=e1.getText().toString();
                getadmissionnumber=e3.getText().toString();
                getrollnumber=e2.getText().toString();
                getcollege=e4.getText().toString();
                boolean  result=dbhelper.insertData(getname,getadmissionnumber,getrollnumber,getcollege);
                if(result==true)
                {
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    e4.setText("");
                    Toast.makeText(getApplicationContext(), "successfully inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "failed to inserted", Toast.LENGTH_SHORT).show();
                }


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplication(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}