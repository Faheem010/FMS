package com.example.flatsmangmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserAddActivity extends AppCompatActivity {
    Button addButton;
    EditText editName,editPhone,editEmail;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_add);
        addButton=findViewById(R.id.addUser);
        editEmail=findViewById(R.id.editTextEmailAddress);
        editName=findViewById(R.id.editTextPersonName);
        editPhone=findViewById(R.id.editTextPhone);
        DB=new DBHelper(this);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString();
                String email = editEmail.getText().toString();
                String phone = editPhone.getText().toString();
                Boolean res=DB.checkusername(name);
                if(!res) {
                    DB.insertData(name, null, email, phone);
                 /*  Intent intent=new Intent(getApplicationContext(),UserList.class);
                    intent.putExtra("name",name);
                    intent.putExtra("email",email);
                    intent.putExtra("phone",phone);
                    startActivity(intent);
                    */
                }
              else{

                    Toast.makeText(UserAddActivity.this, "Username already exist", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}