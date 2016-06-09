package com.example.root.alergenos.Preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jairo on 6/06/16.
 */
public class PreferenceHelper  {

    private Context context;
    private SharedPreferences sharedPreferences;

    public PreferenceHelper(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("Preferences", Context.MODE_PRIVATE);
    }

    public void setId(int id) {
        SharedPreferences.Editor  editor = sharedPreferences.edit();
        editor.putInt("id", id);
        editor.commit();
    }

    public int getId() {
        return sharedPreferences.getInt("id", 0);
    }


    public void setImgDesc(int img) {
        SharedPreferences.Editor  editor = sharedPreferences.edit();
        editor.putInt("img", img);
        editor.commit();
    }

    public int getImgDesc(){
        return sharedPreferences.getInt("img", 0);
    }

    public void setDesc(String desc) {
        SharedPreferences.Editor  editor = sharedPreferences.edit();
        editor.putString("desc", desc);
        editor.commit();
    }

    public int getDesc() {
        return sharedPreferences.getInt("desc", 0);
    }

    public boolean getInicio() {
        return sharedPreferences.getBoolean("inicio", true);
    }


    public void setInicio(boolean flag) {
        SharedPreferences.Editor  editor = sharedPreferences.edit();
        editor.putBoolean("inicio", flag);
        editor.commit();
    }




}
