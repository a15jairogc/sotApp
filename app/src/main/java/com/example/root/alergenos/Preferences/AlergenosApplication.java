package com.example.root.alergenos.Preferences;

import android.app.Application;

import com.example.root.alergenos.Preferences.PreferenceHelper;
import com.example.root.alergenos.clase.Producto;
import com.example.root.alergenos.clase.TipoProducto;

import java.util.ArrayList;

/**
 * Created by jairo on 6/06/16.
 */
public class AlergenosApplication extends Application {

    public static PreferenceHelper helper;
    public ArrayList<Producto> mArraylistProd;
    @Override
    public void onCreate() {
        super.onCreate();
        helper = new PreferenceHelper(getApplicationContext());

        if (helper.getInicio()){
            helper.setInicio(false);
            mArraylistProd = new ArrayList<>();

            Producto producto = new Producto();
            producto.id = 1;
            producto.nombre = "Filete";
            producto.precio = 8;


            TipoProducto tipoProducto = new TipoProducto();
            tipoProducto.id = 1;
            tipoProducto.name= "Carne";

            tipoProducto.productos.add(producto);
        }



    }
}
