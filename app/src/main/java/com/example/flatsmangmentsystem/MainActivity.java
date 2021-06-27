package com.example.flatsmangmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   EditText username,password,repass;
   Button signup,login;
   DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        repass=findViewById(R.id.rePassword);
        signup=findViewById(R.id.SignUp);
        login=findViewById(R.id.login);
        DB=new DBHelper(this);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String respass = repass.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_LONG).show();
                else {
                    if (pass.equals(respass)) {
                        Boolean checkUser = DB.checkusername(user);
                        if (checkUser == false) {
                            Boolean insert = DB.insertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(MainActivity.this, "User Registered Succecfully", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), HomeView.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this, "User Registered failed", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "User already! exists please Login", Toast.LENGTH_LONG).show();

                        }
                    } else {
                        Toast.makeText(MainActivity.this, "User Password  not matching", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}