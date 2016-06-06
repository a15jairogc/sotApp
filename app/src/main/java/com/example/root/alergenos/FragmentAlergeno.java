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
    Bundle bundle = new Bundle();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alergenos, container, false);
        mainActivity = (MainActivity) getActivity();

        listViewAlergeno= (ListView) view.findViewById(R.id.listaAlergenos);
        alergenosArrayList = new ArrayList<>();
        alergenosArrayList.add(new Alergenos(1, "Gluten", R.drawable.gluten, R.drawable.glutendesc, getString(R.string.descGluten)));
//        alergenosArrayList.add(new Alergenos(2, "Huevos", R.drawable.huevos, R.drawable.huevosdesc, R.string.descHuevos));
//        alergenosArrayList.add(new Alergenos(3, "Lacteos", R.drawable.lacteos, R.drawable.lacteosdesc, R.string.descLacteos));
//        alergenosArrayList.add(new Alergenos(4, "Pescado", R.drawable.pescado, R.drawable.pescadosdesc, R.string.descPescado));
//        alergenosArrayList.add(new Alergenos(5, "Moluscos", R.drawable.moluscos, R.drawable.moluscodesc, R.string.descMoluscos));
//        alergenosArrayList.add(new Alergenos(6, "Crustaceos", R.drawable.crustaceos, R.drawable.crustaceosdesc, R.string.descCrustaceos));
//        alergenosArrayList.add(new Alergenos(7, "Cacahuetes", R.drawable.cacahuetes, R.drawable.cacahuetesdesc , R.string.descCacahuetes));
//        alergenosArrayList.add(new Alergenos(8, "Soja", R.drawable.soja, R.drawable.sojadesc, R.string.descSoja));
//        alergenosArrayList.add(new Alergenos(9, "Frutos secos", R.drawable.frutos_secos, R.drawable.frutossecosdesc, R.string.descFrutosSecos));
//        alergenosArrayList.add(new Alergenos(10, "Sesamo", R.drawable.sesamo, R.drawable.sesamodesc, R.string.descSesamo));
//        alergenosArrayList.add(new Alergenos(11, "Apio", R.drawable.apio, R.drawable.apiodesc, R.string.descApio));
//        alergenosArrayList.add(new Alergenos(12, "Mostaza", R.drawable.mostaza, R.drawable.mostazadesc, R.string.descMostaza));
//        alergenosArrayList.add(new Alergenos(13, "Altramuces", R.drawable.altramuces, R.drawable.altramucesdesc, R.string.descAltramuces));
//        alergenosArrayList.add(new Alergenos(14, "Sulfitos", R.drawable.sulfitos, R.drawable.sulfitosdesc, R.string.descSulfitos));




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
