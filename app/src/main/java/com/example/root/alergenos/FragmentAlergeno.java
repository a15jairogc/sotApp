package com.example.root.alergenos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.root.alergenos.adaptador.AdaptadorAlergeno;
import com.example.root.alergenos.clase.Alergenos;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by root on 2/06/16.
 */
public class FragmentAlergeno extends Fragment{

    public static final String TAG = "FragCarta";
    private AdaptadorAlergeno adaptadorAlergeno;
    private ArrayList<Alergenos> alergenosArrayList;
    private ListView listViewAlergeno;
    MainActivity mainActivity;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carta, container, false);

        mainActivity = (MainActivity) getActivity();

        listViewAlergeno= (ListView) view.findViewById(R.id.listaAlergenos);
        alergenosArrayList = new ArrayList<>();
        alergenosArrayList.add(new Alergenos(R.drawable.gluten));
        alergenosArrayList.add(new Alergenos(R.drawable.huevos));
        alergenosArrayList.add(new Alergenos(R.drawable.lacteos));
        alergenosArrayList.add(new Alergenos(R.drawable.pescado));
        alergenosArrayList.add(new Alergenos(R.drawable.moluscos));
        alergenosArrayList.add(new Alergenos(R.drawable.crustaceos));
        alergenosArrayList.add(new Alergenos(R.drawable.cacahuetes));
        alergenosArrayList.add(new Alergenos(R.drawable.soja));
        alergenosArrayList.add(new Alergenos(R.drawable.frutos_secos));
        alergenosArrayList.add(new Alergenos(R.drawable.sesamo));
        alergenosArrayList.add(new Alergenos(R.drawable.apio));
        alergenosArrayList.add(new Alergenos(R.drawable.mostaza));



        adaptadorAlergeno = new AdaptadorAlergeno(mainActivity,alergenosArrayList);
        listViewAlergeno.setAdapter(adaptadorAlergeno);
        return view;
    }


}
