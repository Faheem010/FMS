package com.example.flatsmangmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button login1;
    EditText username1,password1;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username1=findViewById(R.id.username1);
        password1=findViewById(R.id.password1);
        login1=findViewById(R.id.login1);
        DB=new DBHelper(this);

        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username1.getText().toString();
                String pass = password1.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_LONG).show();
                else{
                    Boolean checkUserPassword= DB.checkUsernamePassword(user,pass);
                    if(checkUserPassword==true){
                        Toast.makeText(LoginActivity.this, "You are Logged in", Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(getApplicationContext(), HomeView.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}