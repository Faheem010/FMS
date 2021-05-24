package com.example.flatsmangmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ExpenseList extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_list);
        listView=findViewById(R.id.listView);
        String name=getIntent().getStringExtra("type").toLowerCase();
        String price=getIntent().getStringExtra("price").toLowerCase();

        final ArrayList<String> itemsArrayList=new ArrayList<String>();
        itemsArrayList.add(name);
        itemsArrayList.add(price);

        final ArrayAdapter<String> itemsArrayAdapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,itemsArrayList);
        listView.setAdapter(itemsArrayAdapter);
    }
}