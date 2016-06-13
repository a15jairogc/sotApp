package com.example.root.alergenos.Preferences;

import android.app.Application;

import com.example.root.alergenos.BaseActivity;
import com.example.root.alergenos.R;
import com.example.root.alergenos.clase.Producto;
import com.example.root.alergenos.clase.TipoProducto;
import com.example.root.alergenos.database.ModelProvider;
import com.example.root.alergenos.database.PersistenceHelper;
import com.j256.ormlite.table.TableUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jairo on 6/06/16.
 */
public class AlergenosApplication extends Application {

    public static PreferenceHelper helper;
    public PersistenceHelper persistenceHelper;
    public ArrayList<Producto> mArraylistProdEntrantes;

    @Override
    public void onCreate() {
        super.onCreate();
        persistenceHelper = new PersistenceHelper(getApplicationContext(), ModelProvider.getModels());
        helper = new PreferenceHelper(getApplicationContext());
        if (helper.getInicio()){
            helper.setInicio(false);
            mArraylistProdEntrantes = new ArrayList<>();
            // Producto producto = new Producto();
//            producto.id = 13243;
//            producto.nombre = "Filete";
//            producto.img = R.drawable.filete;
//            producto.precio = 8;

            Producto caldo = new Producto();
            caldo.id = 1;
            caldo.nombre = "Caldo Gallego";
            caldo.img = R.drawable.caldo;
            caldo.precio = 3.7;
            Producto ensalada = new Producto(2,"Ensalada",3.3,R.drawable.ensalada);
            Producto ensaladam = new Producto(3,"Ensalada Mixta",5.8,R.drawable.ensaladam);
            Producto ensaladap = new Producto(4,"Ensalada Primavera",5.8,R.drawable.ensaladap);
            Producto ensaladas = new Producto(5,"Ensalada Sotavento",7.8,R.drawable.ensaladas);
            Producto pate = new Producto(6,"Pate de Mejillones",7.5,R.drawable.pate);
            Producto jamons = new Producto(7,"Jamon Serrano",5.5,R.drawable.jamons);
            Producto pulpof = new Producto(8,"Pulpo a feira",12,R.drawable.pulpof);
            Producto pulpog = new Producto(9,"Pulpo a la Gallega",12.5,R.drawable.pulpog);
            Producto calamares = new Producto(10,"Calamares",8.8,R.drawable.calamares);
            Producto chipirones = new Producto(11,"Chipirones",8.3,R.drawable.chipirones);
            Producto pimientos = new Producto(12,"Pimientos de Padrón",4.4,R.drawable.pimientos);
            Producto esparragos = new Producto(13,"Espárragos con mahonesa",5,R.drawable.esparragos);

            mArraylistProdEntrantes.add(caldo);
            mArraylistProdEntrantes.add(ensalada);
            mArraylistProdEntrantes.add(ensaladam);
            mArraylistProdEntrantes.add(ensaladap);
            mArraylistProdEntrantes.add(ensaladas);
            mArraylistProdEntrantes.add(pate);
            mArraylistProdEntrantes.add(jamons);
            mArraylistProdEntrantes.add(pulpof);
            mArraylistProdEntrantes.add(pulpog);
            mArraylistProdEntrantes.add(calamares);
            mArraylistProdEntrantes.add(chipirones);
            mArraylistProdEntrantes.add(pimientos);
            mArraylistProdEntrantes.add(esparragos);




            TipoProducto tipoProducto = new TipoProducto(1,"Entrantes",R.drawable.filete,mArraylistProdEntrantes);
            int max = mArraylistProdEntrantes.size();
            for (int i=0; i < max; i++ ) {
                tipoProducto.productos.add(mArraylistProdEntrantes.get(i));
            }
            persistenceHelper.getRuntimeExceptionDao(TipoProducto.class).create(tipoProducto);


        }



    }
}