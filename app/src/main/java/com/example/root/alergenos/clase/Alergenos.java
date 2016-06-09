package com.example.root.alergenos.clase;
import android.os.Parcel;
import android.os.Parcelable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

//package com.example.root.alergenos.clase;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//import android.widget.ImageView;
//
///**
// * Created by jairo on 2/06/16.
// */
//public class Alergenos implements Parcelable{
//
//    public int id;
//    public String nombre;
//    public int img;
//    public int imgDesc;
//    public String descripcion;
//
//    public Alergenos(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public Alergenos() {
//    }
//
//    public Alergenos(int id, String nombre, int img, int imgDesc, String descripcion) {
//        this.id = id;
//        this.nombre = nombre;
//        this.img = img;
//        this.imgDesc = imgDesc;
//        this.descripcion = descripcion;
//    }
//
//    public Alergenos(int img) {
//        this.img = img;
//    }
//
//    public Alergenos(String nombre, int id, int img) {
//        this.nombre = nombre;
//        this.id = id;
//        this.img = img;
//    }
//
//    public Alergenos(int id, int imgDesc, String descripcion) {
//        this.id = id;
//        this.imgDesc = imgDesc;
//        this.descripcion = descripcion;
//    }
//
//    protected Alergenos(Parcel in) {
//        id = in.readInt();
//        nombre = in.readString();
//        img = in.readInt();
//        imgDesc = in.readInt();
//        descripcion = in.readString();
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeInt(id);
//        dest.writeString(nombre);
//        dest.writeInt(img);
//        dest.writeInt(imgDesc);
//        dest.writeString(descripcion);
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    public static final Creator<Alergenos> CREATOR = new Creator<Alergenos>() {
//        @Override
//        public Alergenos createFromParcel(Parcel in) {
//            return new Alergenos(in);
//        }
//
//        @Override
//        public Alergenos[] newArray(int size) {
//            return new Alergenos[size];
//        }
//    };
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public int getImg() {
//        return img;
//    }
//
//    public void setImg(int img) {
//        this.img = img;
//    }
//
//    public int getImgDesc() {
//        return imgDesc;
//    }
//
//    public void setImgDesc(int imgDesc) {
//        this.imgDesc = imgDesc;
//    }
//
//    public String getDescripcion() {
//        return descripcion;
//    }
//
//    public void setDescripcion(String descripcion) {
//        this.descripcion = descripcion;
//    }
//
//
//}
@DatabaseTable(tableName = "alergenos")

public class Alergenos implements Parcelable {

    @DatabaseField(generatedId = true)
    public int id;
    @DatabaseField
    public String nombre;
    @DatabaseField
    public int img;
    @DatabaseField
    public int imgDesc;
    @DatabaseField
    public String descripcion;

    protected Alergenos(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
        img = in.readInt();
        imgDesc = in.readInt();
        descripcion = in.readString();
    }


    public Alergenos() {
    }

    public Alergenos(int id, String nombre, int img, int imgDesc, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.img = img;
        this.imgDesc = imgDesc;
        this.descripcion = descripcion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nombre);
        dest.writeInt(img);
        dest.writeInt(imgDesc);
        dest.writeString(descripcion);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Alergenos> CREATOR = new Parcelable.Creator<Alergenos>() {
        @Override
        public Alergenos createFromParcel(Parcel in) {
            return new Alergenos(in);
        }

        @Override
        public Alergenos[] newArray(int size) {
            return new Alergenos[size];
        }
    };

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}