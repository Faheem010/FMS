package com.example.flatsmangmentsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Switch;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static String myDB = "login.db";
    private static String USERS = "users";
    private static String EXPENSE = "expense";
    private static String expenseType = "expenseType";
    private static String price = "price";
    private static String members ="member";

    public DBHelper(@Nullable Context context) {
        super(context,myDB,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        String users="create table " +USERS+ " (username Text primary key ,password Text)";
        String expenses="create table "+ EXPENSE+ " ( id INTEGER primary key ," + expenseType + " Text," + price+ " Text)";
        myDB.execSQL(users);
        myDB.execSQL(expenses);
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        myDB.execSQL("Drop table if exists "+USERS);
        myDB.execSQL("Drop table if exists "+EXPENSE);
        onCreate(myDB);
    }
    public  Boolean insertData(String username ,String password){
        SQLiteDatabase myDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result=myDB.insert("users",null,contentValues);
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
    public  Boolean insertExpense(ExpenseModel expenseModel){
        SQLiteDatabase myDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("expenseType",expenseModel.getTypeExpnse());
        contentValues.put("price",expenseModel.getPrice());
        long res=myDB.insert("expense",null,contentValues);
        myDB.close();
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
                arrayList.add(cursor.getString(cursor.getColumnIndex("expenseType")));
                arrayList.add(cursor.getString(cursor.getColumnIndex("price")));
                cursor.moveToNext();
            }
            return  arrayList;
    }


}


