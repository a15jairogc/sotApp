package com.example.root.alergenos.database;



import com.example.root.alergenos.clase.Alergenos;
import com.example.root.alergenos.clase.Producto;
import com.example.root.alergenos.clase.TipoProducto;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jairo on 11/04/16.
 */
public class ModelProvider {

    public static List<Class<?>> getModels() {
        Class<?>    [] models = {
//                Payment.class,
//                Products.class
                Producto.class,
                TipoProducto.class,
                Alergenos.class
        };
        return Arrays.asList(models);
    }

}
