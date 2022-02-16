package com.example.studentdbapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    static String Dbname="college.db";
    static String Tablename="students";
    static String col1="id";
    static String col2="Name";
    static String col3="RollNumber";
    static String col4="Admissionnumber";
    static String col5="COLLEGE";


    public DatabaseHelper(Context context) {
        super(context, Dbname,  null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String query="create table "+Tablename+"("+col1+" integer primary key autoincrement,"+
            col2+" text,"+
            col3+" text,"+
            col4+"  text,"+
            col5+" text)";
    db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean insertData(String name ,String admno ,String rollno,String college)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues content=new ContentValues();
        content.put(col2,name);
        content.put(col3,admno);
        content.put(col4,rollno);
        content.put(col5,college);
         Long status=db.insert(Tablename,null,content);
         if (status==-1)
         {
             return false;
         }
         else
         {
             return true;
         }
    }
}
