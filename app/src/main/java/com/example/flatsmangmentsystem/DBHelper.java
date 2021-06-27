package com.example.flatsmangmentsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;

public class DBHelper extends SQLiteOpenHelper {
    private static String myDB="FMS.db";
    private static String EXPENSE="expenses";
    private static String USERS="users";
    private static String typeExpanse="typeExpanse";
    private static String price="price";
    private static String members="member";

    public DBHelper(@Nullable Context context) {
        super(context,myDB,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        String expenses="create table "+ EXPENSE+ " ( id INTEGER primary key ," + typeExpanse + " Text," + price+ " Text)";
        String users="create table "+ USERS +" ( id INTEGER primary key ,username Text,password Text,email Text,phone Text)";
        myDB.execSQL(users);
        myDB.execSQL(expenses);
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        myDB.execSQL("Drop table if exists "+USERS);
        myDB.execSQL("Drop table if exists "+EXPENSE);
        onCreate(myDB);
    }
    public  Boolean insertData(String username ,String password, String email, String phone){
        SQLiteDatabase myDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("phone", phone);
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("email",email);
        long result=myDB.insert(USERS,"null",contentValues);
        //myDB.close();
        if(result==-1) return false;
        else
            return true;
    }
    public Boolean checkusername(String username){
        SQLiteDatabase myDB=this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery("select * from users where username=?",new String[]{username});
        if(cursor.getCount()>0) return true;
        else
            return false;
    }
    public  Boolean checkUsernamePassword(String username,String password){
        SQLiteDatabase myDB=this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery("select * from users where username =? and password=?",new String[]{username,password});
        if(cursor.getCount()>0) return true;
        else
            return false;
    }
  /*  public  Boolean insertExpense(String expense,String price){
        SQLiteDatabase myDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("expense",expense);
        contentValues.put("price",price);
        long res=myDB.insert(EXPENSE,"null",contentValues);
        if(res==-1) return false;
        else
            return true;
    }*/

    public  Boolean insertExpense(ExpenseModel expenseModel){

        SQLiteDatabase myDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("typeExpanse",expenseModel.getTypeExpanse());
        contentValues.put("price",expenseModel.getPrice());
        long res=myDB.insert(EXPENSE,"null",contentValues);
        if(res==-1) return false;
        else
            return true;
    }

    public ArrayList getExpense(){
        SQLiteDatabase myDB=this.getReadableDatabase();
        ArrayList <String> arrayList=new ArrayList<>();
        Cursor cursor=myDB.rawQuery("SELECT * FROM "+EXPENSE,null);
        cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                arrayList.add(cursor.getString(cursor.getColumnIndex("id")));
                arrayList.add(cursor.getString(cursor.getColumnIndex("typeExpanse")));
                arrayList.add(cursor.getString(cursor.getColumnIndex("price")));
                cursor.moveToNext();
            }
            return  arrayList;
    }
    public ArrayList getUsers(){
        SQLiteDatabase myDB=this.getReadableDatabase();
        ArrayList <String> arrayList=new ArrayList<>();
        Cursor cursor=myDB.rawQuery("SELECT * FROM users",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            arrayList.add(cursor.getString(cursor.getColumnIndex("id")));
            arrayList.add(cursor.getString(cursor.getColumnIndex("username")));
            arrayList.add(cursor.getString(cursor.getColumnIndex("email")));
            arrayList.add(cursor.getString(cursor.getColumnIndex("phone")));
            cursor.moveToNext();
        }
        return  arrayList;
    }

}


