package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends AppCompatActivity {
    Button btnregister,btnlogin;
    EditText eduserlogin,edpasslogin;
    DatabaseHelper dblogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        eduserlogin = findViewById(R.id.editTextUsername);
        edpasslogin = findViewById(R.id.editTextPassword);
        btnregister = findViewById(R.id.buttonRegister);
        btnlogin = findViewById(R.id.buttonLogin);
        dblogin = new DatabaseHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String suser = eduserlogin.getText().toString();
                String spassword = edpasslogin.getText().toString();
                Boolean checkUserPassword = dblogin.checkUserPassword(suser, spassword);
                if (checkUserPassword) {
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

    }
}