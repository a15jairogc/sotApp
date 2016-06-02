package com.example.root.alergenos.clase;

import android.widget.ImageView;

/**
 * Created by jairo on 2/06/16.
 */
public class Alergenos {

    public String id;
    public String nombre;
    public int img;

    public Alergenos(String nombre) {
        this.nombre = nombre;
    }

    public Alergenos() {
    }

    public Alergenos(int img) {
        this.img = img;
    }

    public Alergenos(String nombre, String id, int img) {
        this.nombre = nombre;
        this.id = id;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
