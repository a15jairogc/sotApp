package com.example.root.alergenos.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.root.alergenos.R;
import com.example.root.alergenos.clase.Alergenos;
import com.example.root.alergenos.clase.Producto;
import com.example.root.alergenos.clase.TipoProducto;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
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
    private ArrayList<Producto>productoArrayList;
    private Dao<Producto, Integer> productoDao;
    private Dao<TipoProducto, Integer> tipoProductoDao;
    private static PersistenceHelper persistenceHelper = null;

    public PersistenceHelper(Context context, List<Class<?>> models) {
        super(context, DB_NAME, null, DB_VERSION);
        this.models = models;
    }

    public PersistenceHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);

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


        try {
            productoArrayList = new ArrayList<>();
            productoArrayList.add(new Producto(2,"Ensalada",3.3,R.drawable.ensalada));
            Dao<TipoProducto, Integer> dao = getTipoProductoDao();
            TipoProducto tipoProducto = new TipoProducto(1, "Entrantes", R.drawable.entrantes,productoArrayList);
            TipoProducto tipoProducto1 = new TipoProducto(2, "Entrantes2", R.drawable.entrantes,productoArrayList);
            dao.create(tipoProducto);
            dao.create(tipoProducto1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) { }



    public Dao<Producto, Integer> getProductoDao() throws SQLException {
        if (productoDao == null) {
            productoDao = getDao(Producto.class);
        }
        return productoDao;
    }

    public Dao<TipoProducto, Integer> getTipoProductoDao() throws SQLException {
        if (tipoProductoDao == null) {
            tipoProductoDao = getDao(TipoProducto.class);
        }
        return tipoProductoDao;
    }



}