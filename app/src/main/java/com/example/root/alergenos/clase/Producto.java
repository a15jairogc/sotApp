package com.example.root.alergenos.clase;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by jairo on 8/06/16.
 */
@DatabaseTable(tableName = "producto")
public class Producto {

    @DatabaseField(generatedId = true)
    public transient int id;

    @DatabaseField
    public String nombre;

    @DatabaseField
    public double precio;

    @DatabaseField(foreign = true)
    public transient TipoProducto tipoProducto;

    public Producto() {
    }

    public Producto(int id, String nombre, double precio ) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
}
