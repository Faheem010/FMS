package com.example.flatsmangmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class UserList extends AppCompatActivity {
        ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        listView=findViewById(R.id.listOfUser);

     //   String name=getIntent().getStringExtra("name").toString();
     //   String phone=getIntent().getStringExtra("phone").toString();
     //   String email=getIntent().getStringExtra("email").toString();

     //   final ArrayList<String> itemsArrayList=new ArrayList<String>();
     //   itemsArrayList.add(phone);
      //  itemsArrayList.add(email);

       DBHelper dbHelper=new DBHelper(this);

        ArrayList <String> itemsArrayList=new ArrayList<String>();
        itemsArrayList=dbHelper.getUsers();



        final ArrayAdapter<String> itemsArrayAdapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,itemsArrayList);
        listView.setAdapter(itemsArrayAdapter);

    }
}