package com.example.flatsmangmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.EventLog;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Expense extends AppCompatActivity {

    EditText eidtPrice;
    Spinner mySpinner;
    Button addValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
        mySpinner= findViewById(R.id.spinner);
        eidtPrice=findViewById(R.id.priceEdit);
        addValue=findViewById(R.id.addValues);
       DBHelper myDB=new DBHelper(this);

        ArrayAdapter<String> arrayItems=new ArrayAdapter<String>(Expense.this,
                android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.items));
        mySpinner.setAdapter(arrayItems);
        addValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String typeExpanse=mySpinner.getSelectedItem().toString();
                String price=eidtPrice.getText().toString();
                ExpenseModel expenseModel=new ExpenseModel(typeExpanse,price);
              //  Toast.makeText(Expense.this,expenseModel.toString(),Toast.LENGTH_LONG).show();
                Boolean insert = myDB.insertExpense(expenseModel);
                if (insert == true) {
                    Toast.makeText(Expense.this, "Values Registered Succecfully", Toast.LENGTH_LONG).show();
                  //  Intent intent = new Intent(getApplicationContext(), ExpenseList.class);
                 //   intent.putExtra("typeExpanse",typeExpanse);
                  //  intent.putExtra("price",price);
                 //   startActivity(intent);
                }
                else {
                    Toast.makeText(Expense.this, "Values saving failed", Toast.LENGTH_LONG).show();
                }

              /*  Intent intent=new Intent(ExpenseAddActivity.this,ExpenseList.class);
                intent.putExtra("type",type);
                intent.putExtra("price",price);
                startActivity(intent);*/
            }
        });

    }
}