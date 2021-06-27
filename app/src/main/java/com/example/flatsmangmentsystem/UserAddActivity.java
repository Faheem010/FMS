package com.example.flatsmangmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserAddActivity extends AppCompatActivity {
    Button addButton;
    EditText editName,editPhone,editEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_add);
        addButton=findViewById(R.id.addUser);
        editEmail=findViewById(R.id.editTextEmailAddress);
        editName=findViewById(R.id.editTextPersonName);
        editPhone=findViewById(R.id.editTextPhone);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString();
                String email = editEmail.getText().toString();
                String phone = editPhone.getText().toString();

                Intent intent=new Intent(getApplicationContext(),UserList.class);
                intent.putExtra("name",name);
                intent.putExtra("email",email);
                intent.putExtra("phone",phone);
                startActivity(intent);
            }
        });

    }
}