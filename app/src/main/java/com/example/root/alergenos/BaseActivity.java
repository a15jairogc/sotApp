package com.example.root.alergenos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.root.alergenos.database.ModelProvider;
import com.example.root.alergenos.database.PersistenceHelper;

/**
 * Created by jairo on 7/04/16.
 */
public class BaseActivity extends AppCompatActivity {


    private PersistenceHelper mPersistenceHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPersistenceHelper = new PersistenceHelper(getApplicationContext(), ModelProvider.getModels());
    }


    public PersistenceHelper getPersistenceHelper() {
        return mPersistenceHelper;
    }

}
