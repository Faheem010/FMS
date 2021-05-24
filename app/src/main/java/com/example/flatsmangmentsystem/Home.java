package com.example.flatsmangmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Home extends AppCompatActivity {
    EditText eidtPrice;
    Spinner mySpinner;
    Button addValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mySpinner=(Spinner)findViewById(R.id.spinner);
        eidtPrice=findViewById(R.id.priceEdit);
        addValue=findViewById(R.id.addValues);
        ArrayAdapter<String> arrayItems=new ArrayAdapter<String>(Home.this,
                android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.items));
        mySpinner.setAdapter(arrayItems);
        addValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type=mySpinner.getSelectedItem().toString();
                String price=eidtPrice.getText().toString();
                Intent intent=new Intent(Home.this,ExpenseList.class);
                intent.putExtra("type",type);
                intent.putExtra("price",price);
                startActivity(intent);
            }
        });
    }


}