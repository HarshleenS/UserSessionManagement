package com.example.usersessionmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText et,add,mob,em,pw;
    Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et=findViewById(R.id.editText3);
        add=findViewById(R.id.editText4);
        mob=findViewById(R.id.editText5);
        em=findViewById(R.id.editText6);
        pw=findViewById(R.id.editText7);
        b3=findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=et.getText().toString();
                String address=add.getText().toString();
                String mobile=mob.getText().toString();
                String email=em.getText().toString();
                String password=pw.getText().toString();
                UserPref up=new UserPref(Register.this);
                up.addData("Name",name);
                up.addData("Address",address);
                up.addData("Mobile",mobile);
                up.addData("Email",email);
                up.addData("Password",password);
                Toast.makeText(Register.this, "Data Stored successfully", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Register.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(Register.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
