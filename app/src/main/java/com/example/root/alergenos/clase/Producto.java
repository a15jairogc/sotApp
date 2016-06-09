//package com.example.root.alergenos.clase;
//
//import com.j256.ormlite.field.DatabaseField;
//import com.j256.ormlite.table.DatabaseTable;
//
///**
// * Created by jairo on 8/06/16.
// */
//@DatabaseTable(tableName = "producto")
//public class Producto {
//
//    @DatabaseField(generatedId = true)
//    public transient int id;
//
//    @DatabaseField
//    public String nombre;
//
//    @DatabaseField
//    public double precio;
//
//    @DatabaseField
//    public int img;
//
//    @DatabaseField(foreign = true)
//    public transient TipoProducto tipoProducto;
//
//    public Producto() {
//    }
//
//    public Producto(int id, String nombre, double precio, int img ) {
//        this.id = id;
//        this.nombre = nombre;
//        this.precio = precio;
//        this.img = img;
//    }
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
//    public double getPrecio() {
//        return precio;
//    }
//
//    public void setPrecio(double precio) {
//        this.precio = precio;
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
//    public TipoProducto getTipoProducto() {
//        return tipoProducto;
//    }
//
//    public void setTipoProducto(TipoProducto tipoProducto) {
//        this.tipoProducto = tipoProducto;
//    }
//}
package com.example.root.alergenos.clase;

import android.os.Parcel;
import android.os.Parcelable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by jairo on 8/06/16.
 */
@DatabaseTable(tableName = "producto")
public class Producto implements Parcelable {

    @DatabaseField(generatedId = true)
    public transient int id;

    @DatabaseField
    public String nombre;

    @DatabaseField
    public double precio;

    @DatabaseField
    public int img;

    @DatabaseField(foreign = true)
    public transient TipoProducto tipoProducto;

    public Producto() {
    }

    public Producto(int id, String nombre, double precio, int img ) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.img = img;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    protected Producto(Parcel in) {
        nombre = in.readString();
        precio = in.readDouble();
        img = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeDouble(precio);
        dest.writeInt(img);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Producto> CREATOR = new Parcelable.Creator<Producto>() {
        @Override
        public Producto createFromParcel(Parcel in) {
            return new Producto(in);
        }

        @Override
        public Producto[] newArray(int size) {
            return new Producto[size];
        }
    };
}