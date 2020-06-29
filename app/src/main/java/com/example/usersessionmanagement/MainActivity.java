package com.example.usersessionmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1, pass;
    Button b1, b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final UserPref up=new UserPref(MainActivity.this);

        String status=up.getData("status");
        if(status.equals("true"))
        {
            Intent i=new Intent(this,Welcome.class);
            startActivity(i);
            finish();
        }else {
            et1 = findViewById(R.id.editText);
            pass = findViewById(R.id.editText2);
            b1 = findViewById(R.id.button);
            b2 = findViewById(R.id.button2);
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, Register.class);
                    startActivity(i);
                    finish();
                }
            });
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (et1.getText().toString().isEmpty() || pass.getText().toString().isEmpty()) {
                        Toast.makeText(MainActivity.this, "Please Enter the data ", Toast.LENGTH_SHORT).show();
                    } else {
                        String name = et1.getText().toString();
                        String password = pass.getText().toString();

                        String spname = up.getData("Name");
                        String sppassword = up.getData("Password");

                        if (name.equals(spname) && password.equals(sppassword)) {
                            up.addData("status", "true");
                            Intent i = new Intent(MainActivity.this, Welcome.class);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(MainActivity.this, "Wrong Credentials.", Toast.LENGTH_SHORT).show();
                        }
                    }


                }
            });
        }
    }
}
