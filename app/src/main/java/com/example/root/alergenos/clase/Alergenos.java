package com.example.root.alergenos.clase;

/**
 * Created by jairo on 2/06/16.
 */
public class Alergenos {

    public String id;
    public String nombre;
    public String img;


    public Alergenos() {
    }

    public Alergenos(String nombre, String id, String img) {
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
