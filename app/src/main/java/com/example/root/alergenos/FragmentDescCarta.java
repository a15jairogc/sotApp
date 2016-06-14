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
import com.example.root.alergenos.adaptador.AdaptadorTipo;
import com.example.root.alergenos.clase.Alergenos;
import com.example.root.alergenos.clase.Producto;
import com.example.root.alergenos.clase.TipoProducto;
import com.example.root.alergenos.database.PersistenceHelper;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.stmt.query.In;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jairo on 9/06/16.
 */
public class FragmentDescCarta extends Fragment {
    Dao<Producto, Integer>dao = null;

    TipoProducto producto;
    TextView textView;
    PersistenceHelper persistenceHelper;
    ListView listViewAlergeno;
    MainActivity mainActivity;
    ArrayList<Producto> tipoProductoArrayList;
    ArrayList<String> tipoProductoArrayListId;
    private AdaptadorCarta adaptadorCarta;
    private FloatingActionMenu menu;
    private FloatingActionButton fab1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_desc_carta, container, false);
        listViewAlergeno= (ListView) view.findViewById(R.id.listaCarta);

//        fab1.setEnabled(true);
//        menu.hideMenuButton(true);

        mainActivity = (MainActivity) getActivity();
        try {
            Dao<Producto, Integer> dao = getHelper().getProductoDao();
            tipoProductoArrayList = new ArrayList<>();
            int Id = getArguments().getInt("id");

            if (Id != 0){
                tipoProductoArrayList = (ArrayList<Producto>) dao.queryForEq("tipoProducto_id",Id);
            }





            adaptadorCarta = new AdaptadorCarta(mainActivity,tipoProductoArrayList);
            listViewAlergeno.setAdapter(adaptadorCarta);

            listViewAlergeno.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(getContext(), "Seleccionaste : "+tipoProductoArrayList.get(position).getNombre(), Toast.LENGTH_SHORT).show();
                    AlergenosApplication.helper.setImgDesc(tipoProductoArrayList.get(position).getImg());

                }
            });

        } catch (SQLException e) {
            e.printStackTrace();
        }
//        producto = getArguments().getParcelable("listaCarta");
//        textView =(TextView) view.findViewById(R.id.tvCarta);
        return view;
    }


    public static FragmentDescCarta newInstance(int id) {

        Bundle args = new Bundle();
        FragmentDescCarta fragment = new FragmentDescCarta();
        args.putInt("id",id);
        fragment.setArguments(args);

        return fragment;
    }

    private List<String> query(Dao<Producto, Integer> dao, int position) throws SQLException{
        GenericRawResults<String[]> rawResults = dao.queryRaw("Select * from producto where tipoProductoId = "+position);
        List<String>tpId = new ArrayList<String>();
        while (rawResults.iterator().hasNext()){
            tpId.add(((String[]) rawResults.iterator().next())[0]);
        }
        return tpId;
    }
    private PersistenceHelper getHelper() {
        if (persistenceHelper == null) {
            persistenceHelper = OpenHelperManager.getHelper(getContext(),PersistenceHelper.class);
        }
        return persistenceHelper;
    }


}
