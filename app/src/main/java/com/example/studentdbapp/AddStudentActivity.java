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
    String getname,getrollnumber,getadmissionnumber,getcollege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        e1=(EditText) findViewById(R.id.name);
        e2=(EditText) findViewById(R.id.rollnumber);
        e3=(EditText) findViewById(R.id.admissionnumber);
        e4=(EditText) findViewById(R.id.college);
        b1=(AppCompatButton) findViewById(R.id.submit);
        b2=(AppCompatButton) findViewById(R.id.back);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getname=e1.getText().toString();
                getrollnumber=e2.getText().toString();
                getadmissionnumber=e3.getText().toString();
                getcollege=e4.getText().toString();
                Toast.makeText(getApplicationContext(), getname, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), getrollnumber, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), getadmissionnumber, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), getcollege, Toast.LENGTH_SHORT).show();

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