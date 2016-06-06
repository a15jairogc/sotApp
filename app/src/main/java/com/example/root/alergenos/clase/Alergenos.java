package com.example.root.alergenos.clase;

import android.widget.ImageView;

/**
 * Created by jairo on 2/06/16.
 */
public class Alergenos {

    public int id;
    public String nombre;
    public int img;
    public int imgDesc;
    public int descripcion;

    public Alergenos(String nombre) {
        this.nombre = nombre;
    }

    public Alergenos() {
    }

    public Alergenos(int id, String nombre, int img, int imgDesc, int descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.img = img;
        this.imgDesc = imgDesc;
        this.descripcion = descripcion;
    }

    public Alergenos(int img) {
        this.img = img;
    }

    public Alergenos(String nombre, int id, int img) {
        this.nombre = nombre;
        this.id = id;
        this.img = img;
    }

    public Alergenos(int id, int imgDesc, int descripcion) {
        this.id = id;
        this.imgDesc = imgDesc;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getImgDesc() {
        return imgDesc;
    }

    public void setImgDesc(int imgDesc) {
        this.imgDesc = imgDesc;
    }

    public int getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(int descripcion) {
        this.descripcion = descripcion;
    }
}
