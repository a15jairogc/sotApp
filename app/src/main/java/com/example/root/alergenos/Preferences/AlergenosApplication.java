package com.example.root.alergenos.Preferences;

import android.app.Application;

import com.example.root.alergenos.Preferences.PreferenceHelper;

/**
 * Created by jairo on 6/06/16.
 */
public class AlergenosApplication extends Application {

    public static PreferenceHelper helper;

    @Override
    public void onCreate() {
        super.onCreate();
        helper = new PreferenceHelper(getApplicationContext());
    }
}
