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
import com.example.root.alergenos.Preferences.PreferenceHelper;
import com.example.root.alergenos.adaptador.AdaptadorAlergeno;
import com.example.root.alergenos.clase.Alergenos;

import java.util.ArrayList;

/**
 * Created by root on 2/06/16.
 */
public class FragmentAlergeno extends Fragment {

    public static final String TAG = "FragAlergenos";
    private AdaptadorAlergeno adaptadorAlergeno;
    private ArrayList<Alergenos> alergenosArrayList;
    private ListView listViewAlergeno;
    MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alergenos, container, false);
        mainActivity = (MainActivity) getActivity();

        listViewAlergeno= (ListView) view.findViewById(R.id.listaAlergenos);
        alergenosArrayList = new ArrayList<>();
        alergenosArrayList.add(new Alergenos(1, "Gluten", R.drawable.gluten, R.drawable.glutendesc, R.string.descGluten));
        alergenosArrayList.add(new Alergenos(2, "Huevos", R.drawable.huevos,R.drawable.huevosdesc, R.string.descGluten));
        alergenosArrayList.add(new Alergenos("Lacteos", 3, R.drawable.lacteos));
        alergenosArrayList.add(new Alergenos("Pescado", 4, R.drawable.pescado));
        alergenosArrayList.add(new Alergenos("Moluscos", 5, R.drawable.moluscos));
        alergenosArrayList.add(new Alergenos("Crustaceos", 6, R.drawable.crustaceos));
        alergenosArrayList.add(new Alergenos("Cacahuetes", 7, R.drawable.cacahuetes));
        alergenosArrayList.add(new Alergenos("Soja", 8, R.drawable.soja));
        alergenosArrayList.add(new Alergenos("Frutos secos", 9, R.drawable.frutos_secos));
        alergenosArrayList.add(new Alergenos("Sesamo", 10, R.drawable.sesamo));
        alergenosArrayList.add(new Alergenos("Apio", 11, R.drawable.apio));
        alergenosArrayList.add(new Alergenos("Mostaza", 12, R.drawable.mostaza));



        adaptadorAlergeno = new AdaptadorAlergeno(mainActivity,alergenosArrayList);
        listViewAlergeno.setAdapter(adaptadorAlergeno);
        listViewAlergeno.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Seleccionastes : "+alergenosArrayList.get(position).getNombre(), Toast.LENGTH_SHORT).show();
                AlergenosApplication.helper.setImgDesc(alergenosArrayList.get(position).getImgDesc());
               mainActivity.goToFragAlergenosDesc();

            }
        });
        return view;
    }


}
