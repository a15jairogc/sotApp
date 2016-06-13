package com.example.root.alergenos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.alergenos.Preferences.AlergenosApplication;
import com.example.root.alergenos.adaptador.AdaptadorCarta;
import com.example.root.alergenos.clase.Alergenos;
import com.example.root.alergenos.clase.Producto;
import com.example.root.alergenos.clase.TipoProducto;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jairo on 9/06/16.
 */
public class FragmentDescCarta extends Fragment {

    TipoProducto producto;
    TextView textView;
    ListView listViewAlergeno;
    MainActivity mainActivity;
    ArrayList<Producto> tipoProductoArrayList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_desc_carta, container, false);
        listViewAlergeno= (ListView) view.findViewById(R.id.listaCarta);
        mainActivity = (MainActivity) getActivity();
        listViewAlergeno.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AlergenosApplication.helper.getInicio();
                tipoProductoArrayList = new ArrayList<>();
                AdaptadorCarta adaptadorCarta = new AdaptadorCarta(mainActivity,tipoProductoArrayList);
            listViewAlergeno.setAdapter(adaptadorCarta);
            }
        });
//        producto = getArguments().getParcelable("listaCarta");
//        textView =(TextView) view.findViewById(R.id.tvCarta);
        return view;
    }


    public static FragmentDescCarta newInstance(TipoProducto a) {

        Bundle args = new Bundle();
        FragmentDescCarta fragment = new FragmentDescCarta();
        args.putParcelable("listaCarta",a);
        fragment.setArguments(args);

        return fragment;
    }
}
