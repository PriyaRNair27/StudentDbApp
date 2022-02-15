package com.example.studentdbapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.EditText;

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
        b1.setOnClickListener(new);
    }
}