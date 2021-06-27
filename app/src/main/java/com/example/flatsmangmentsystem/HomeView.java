package com.example.flatsmangmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeView extends AppCompatActivity {
     Button addUser,userView,addExpense,viewExpense;
    DBHelper dbHelper=new DBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view);
        addUser=findViewById(R.id.userList);
        userView=findViewById(R.id.userListView);
        addExpense=findViewById(R.id.expenseList);
        viewExpense=findViewById(R.id.expenseListView);

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent=new Intent(getApplicationContext(),UserAddActivity.class);
            startActivity(intent);
            }
        });
       userView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(getApplicationContext(),UserList.class);
               startActivity(intent);
           }
       });
       addExpense.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(getApplicationContext(),Expense.class);
               startActivity(intent);
           }
       });
       viewExpense.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(getApplicationContext(),ExpenseList.class);
               startActivity(intent);
           }
       });
    }
}