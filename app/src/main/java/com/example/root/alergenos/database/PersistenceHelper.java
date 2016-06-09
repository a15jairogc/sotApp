package com.example.root.alergenos.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.root.alergenos.clase.Alergenos;
import com.example.root.alergenos.clase.Producto;
import com.example.root.alergenos.clase.TipoProducto;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jairo on 11/04/16.
 */
public class PersistenceHelper extends OrmLiteSqliteOpenHelper {

    public static final String DB_NAME = "SotApp.db";
    public static final int DB_VERSION = 1;
    private List<Class<?>> models;

    public PersistenceHelper(Context context, List<Class<?>> models) {
        super(context, DB_NAME, null, DB_VERSION);
        this.models = models;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        for(Class model: models) {
            try {
            TableUtils.createTable(connectionSource, model);






            } catch (SQLException e) {
                Log.e("SQL Helper","Error creating table " + model.getSimpleName());
                throw  new RuntimeException(e);
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) { }
}
