package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonAdd,buttonView;
    EditText editAge,editName,editRollNumber;
    ListView listViewDetails;
    Switch switchIsActive;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAdd=findViewById(R.id.buttonAdd);
        buttonView=findViewById(R.id.buttonView);
        editName=findViewById(R.id.editTextName);
        editAge=findViewById(R.id.editTextAge);
        editRollNumber=findViewById(R.id.editTextRoll);
        switchIsActive=findViewById(R.id.switch1);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  CustomerModel customerModel;
             //   customerModel=new CustomerModel(editName.getText().toString(),Integer.parseInt(editAge.getText().toString()),switchIsActive.isChecked(),1);
               // Toast.makeText(MainActivity.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
               // Toast.makeText(MainActivity.this, "add button Clicked", Toast.LENGTH_SHORT).show();
                String roll=  editRollNumber.getText().toString();
                String name=editName.getText().toString();
                String age=editAge.getText().toString();
                Boolean res=DB.insertData(roll,name,age);
                if(res==true)
                {
                    Toast.makeText(MainActivity.this, "New Data Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Not inserted", Toast.LENGTH_SHORT).show();
                }


            }
        });
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "View button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }
}