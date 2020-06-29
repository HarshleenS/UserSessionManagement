package com.example.usersessionmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Welcome extends AppCompatActivity {

    TextView tv,tv2;
    Button b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        tv=findViewById(R.id.textView);
        tv2=findViewById(R.id.textView2);

        final UserPref up=new UserPref(Welcome.this);
        String spname=up.getData("Name");
        String sppassword=up.getData("Password");
        String address=up.getData("Address");
        String mobile=up.getData("Mobile");
        String email=up.getData("Email");

        tv.setText(spname+"\n"+sppassword+"\n"+address+"\n"+mobile+"\n"+email);

        b4=findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                up.addData("status","false");
                Intent i=new Intent(Welcome.this,MainActivity.class);
                startActivity(i);
                finish();

            }
        });


        SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(this);
        String uname=sp.getString("uname","");
        String password=sp.getString("upassword","");
        String country=sp.getString("list","");
        boolean chk=sp.getBoolean("chk1",false);
        boolean sw=sp.getBoolean("sw",false);
        tv2.setText(uname+"\n"+password+"\n"+country+"\n"+chk+"\n"+sw);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.settings)
        {
     //       Toast.makeText(this, "settings selected", Toast.LENGTH_SHORT).show();
       Intent i=new Intent(Welcome.this,Settings.class);
       startActivity(i);
       finish();

        }

        return true;
    }
}
