package com.example.root.alergenos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.root.alergenos.Preferences.AlergenosApplication;
import com.example.root.alergenos.adaptador.AdaptadorCarta;
import com.example.root.alergenos.adaptador.AdaptadorTipo;
import com.example.root.alergenos.clase.Alergenos;
import com.example.root.alergenos.clase.Producto;
import com.example.root.alergenos.clase.TipoProducto;
import com.example.root.alergenos.database.PersistenceHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.util.ArrayList;

/**
 * Created by jairo on 8/06/16.
 */
public class FragmentCarta extends Fragment{

    private PersistenceHelper persistenceHelper = null;
    private MainActivity mainActivity;
    public static final String TAG = "FragTipo";

    private AdaptadorTipo adaptadorTipo;
    private ArrayList<TipoProducto> tipoProductoArrayList;
    public ArrayList<Producto> productoArrayList;
    private ListView listViewTipo;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carta, container, false);
        mainActivity = (MainActivity) getActivity();
        listViewTipo= (ListView) view.findViewById(R.id.listaTipo);
        productoArrayList = new ArrayList<>();
        insertarDatos();

        return view;
    }

    private PersistenceHelper getHelper() {
        if (persistenceHelper == null) {
            persistenceHelper = OpenHelperManager.getHelper(getContext(),PersistenceHelper.class);
        }
        return persistenceHelper;
    }



    public void insertarDatos(){
        productoArrayList.add(new Producto(1, "Filete", R.drawable.filete, 10));
        tipoProductoArrayList = new ArrayList<>();
        TipoProducto tipoProducto = new TipoProducto(1, "Entrantes",R.drawable.entrantes,productoArrayList);
        TipoProducto tipoProducto1 = new TipoProducto(2, "Pescados",R.drawable.pescados,productoArrayList);
        TipoProducto tipoProducto2 = new TipoProducto(3, "Mariscos",R.drawable.mariscos,productoArrayList);
        TipoProducto tipoProducto3 = new TipoProducto(4, "Arroces",R.drawable.arroces,productoArrayList);
        TipoProducto tipoProducto4 = new TipoProducto(5, "Carnes",R.drawable.carnes,productoArrayList);
        TipoProducto tipoProducto5 = new TipoProducto(6, "Postres",R.drawable.postres,productoArrayList);
        TipoProducto tipoProducto6 = new TipoProducto(7, "Vinos Blancos",R.drawable.vblanco,productoArrayList);
        TipoProducto tipoProducto7 = new TipoProducto(8, "Vinos Tintos",R.drawable.vtinto,productoArrayList);


        tipoProductoArrayList.add(tipoProducto);
        tipoProductoArrayList.add(tipoProducto1);
        tipoProductoArrayList.add(tipoProducto2);
        tipoProductoArrayList.add(tipoProducto3);
        tipoProductoArrayList.add(tipoProducto4);
        tipoProductoArrayList.add(tipoProducto5);
        tipoProductoArrayList.add(tipoProducto6);
        tipoProductoArrayList.add(tipoProducto7);

        adaptadorTipo = new AdaptadorTipo(mainActivity,tipoProductoArrayList);
        listViewTipo.setAdapter(adaptadorTipo);

        listViewTipo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Seleccionaste : "+tipoProductoArrayList.get(position).getName(), Toast.LENGTH_SHORT).show();
                AlergenosApplication.helper.setImgDesc(tipoProductoArrayList.get(position).getImg());
                mainActivity.goToFragDescCarta((TipoProducto) adaptadorTipo.getItem(position));

            }
        });

    }

}