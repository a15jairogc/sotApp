package com.example.root.alergenos.clase;

import android.widget.CalendarView;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;

/**
 * Created by jairo on 8/06/16.
 */
@DatabaseTable(tableName = "tipoProducto")
public class TipoProducto {

    @DatabaseField(generatedId = true)
    public int id;

    @DatabaseField
    public String name;

    @DatabaseField
    public int img;

    @ForeignCollectionField
    public Collection<Producto> productos;

    public TipoProducto() {
    }

    public TipoProducto(int id, String name, int img, Collection<Producto> productos) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.productos = productos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public Collection<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Collection<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "TipoProducto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img=" + img +
                ", productos=" + productos +
                '}';
    }
}
