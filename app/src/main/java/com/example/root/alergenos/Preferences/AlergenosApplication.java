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

            Producto caldo = new Producto("Caldo Gallego",3.7, R.drawable.caldo);
            Producto ensalada = new Producto("Ensalada",3.3,R.drawable.ensalada);
            Producto ensaladam = new Producto("Ensalada Mixta",5.8,R.drawable.ensaladam);
            Producto ensaladap = new Producto("Ensalada Primavera",5.8,R.drawable.ensaladap);
            Producto ensaladas = new Producto("Ensalada Sotavento",7.8,R.drawable.ensaladas);
            Producto pate = new Producto("Pate de Mejillones",7.5,R.drawable.pate);
            Producto jamons = new Producto("Jamon Serrano",5.5,R.drawable.jamons);
            Producto pulpof = new Producto("Pulpo a feira",12,R.drawable.pulpof);
            Producto pulpog = new Producto("Pulpo a la Gallega",12.5,R.drawable.pulpog);
            Producto calamares = new Producto("Calamares",8.8,R.drawable.calamares);
            Producto chipirones = new Producto("Chipirones",8.3,R.drawable.chipirones);
            Producto pimientos = new Producto("Pimientos de Padrón",4.4,R.drawable.pimientos);
            Producto esparragos = new Producto("Espárragos con mahonesa",5,R.drawable.esparragos);
//test
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
            //test




            TipoProducto tipoProducto = new TipoProducto("Entrantes",R.drawable.filete,mArraylistProdEntrantes);
            int max = mArraylistProdEntrantes.size();
            for (int i=0; i < max; i++ ) {
                tipoProducto.productos.add(mArraylistProdEntrantes.get(i));
            }
            persistenceHelper.getRuntimeExceptionDao(TipoProducto.class).create(tipoProducto);


        }



    }
}