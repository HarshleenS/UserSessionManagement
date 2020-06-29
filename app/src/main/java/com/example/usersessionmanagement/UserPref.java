package com.example.usersessionmanagement;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPref {
    SharedPreferences sp;
    SharedPreferences.Editor et;


    public UserPref(Context con) {
        sp=con.getSharedPreferences("myPref",Context.MODE_PRIVATE);
        et=sp.edit();
    }

    public void addData(String key, String value) {
        et.putString(key,value);
        et.commit();
    }

    public String getData(String key) {
        return  sp.getString(key,"");
    }
}
