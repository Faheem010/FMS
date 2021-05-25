package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.style.IconMarginSpan;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name) {
        super(context, "myDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table UserDetails(name Text primary key,age Number )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {

    }
    public boolean insertData (String rollNumber,String name , String age ){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("rollNumber",rollNumber);
        contentValues.put("name",name);
        contentValues.put("age",age);
        long result=DB.insert("myDB.db",null,contentValues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean updateData (String rollNumber,String name , String age ){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("age",age);
        Cursor cursor=DB.rawQuery("select * from myDB.db where rollNmber=?",new String[]{rollNumber});
        if(cursor.getCount()>0){
        long result=DB.update("myDB.db",contentValues,"rollNumber=?",new String[]{rollNumber});
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
        }
        else
        {
            return false;
        }
    }
}
