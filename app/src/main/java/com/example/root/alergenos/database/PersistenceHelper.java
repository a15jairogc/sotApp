package com.example.root.alergenos.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.root.alergenos.R;
import com.example.root.alergenos.clase.Alergenos;
import com.example.root.alergenos.clase.Producto;
import com.example.root.alergenos.clase.TipoProducto;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jairo on 11/04/16.
 */
public class PersistenceHelper extends OrmLiteSqliteOpenHelper {

    public static final String DB_NAME = "SotApp.db";
    public static final int DB_VERSION = 1;
    private List<Class<?>> models;
    private ArrayList<Producto>productoArrayList;
    private Dao<Producto, Integer> productoDao;
    private Dao<TipoProducto, Integer> tipoProductoDao;
    private static PersistenceHelper persistenceHelper = null;

    public PersistenceHelper(Context context, List<Class<?>> models) {
        super(context, DB_NAME, null, DB_VERSION);
        this.models = models;
    }

    public PersistenceHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);

    }




    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        for(Class model: models) {
            try {


                TableUtils.createTable(connectionSource, model);






            } catch (SQLException e) {
                Log.e("SQL Helper","Error creating table " + model.getSimpleName());
                throw  new RuntimeException(e);
            }
        }


        try {
            productoArrayList = new ArrayList<>();
            Dao<TipoProducto, Integer> dao = getTipoProductoDao();
            Dao<Producto, Integer> daoP = getProductoDao();


            TipoProducto tipoProducto = new TipoProducto("Entrantes",R.drawable.entrantes);
            TipoProducto tipoProducto1 = new TipoProducto("Mariscos",R.drawable.mariscos);
            TipoProducto tipoProducto2 = new TipoProducto("Pescados",R.drawable.pescados);
            TipoProducto tipoProducto3 = new TipoProducto("Arroces",R.drawable.arroces);
            TipoProducto tipoProducto4 = new TipoProducto("Carnes",R.drawable.carnes);
            TipoProducto tipoProducto5 = new TipoProducto("Postres",R.drawable.postres);
            TipoProducto tipoProducto6 = new TipoProducto("Vinos Blancos",R.drawable.vblanco);
            TipoProducto tipoProducto7 = new TipoProducto("Vinos Tintos",R.drawable.vtinto);
            dao.create(tipoProducto);
            dao.create(tipoProducto1);
            dao.create(tipoProducto2);
            dao.create(tipoProducto3);
            dao.create(tipoProducto4);
            dao.create(tipoProducto5);
            dao.create(tipoProducto6);
            dao.create(tipoProducto7);
//entrantes


            Producto caldo = new Producto("Caldo Gallego",3.7, R.drawable.caldo,dao.queryForId(1));
            Producto ensalada = new Producto("Ensalada",3.3,R.drawable.ensalada,dao.queryForId(1));
            Producto ensaladam = new Producto("Ensalada Mixta",5.8,R.drawable.ensaladam,dao.queryForId(1));
            Producto ensaladap = new Producto("Ensalada Primavera",5.8,R.drawable.ensaladap,dao.queryForId(1));
            Producto ensaladas = new Producto("Ensalada Sotavento",7.8,R.drawable.ensaladas,dao.queryForId(1));
            Producto pate = new Producto("Pate de Mejillones",7.5,R.drawable.pate,dao.queryForId(1));
            Producto jamons = new Producto("Jamon Serrano",5.5,R.drawable.jamons,dao.queryForId(1));
            Producto pulpof = new Producto("Pulpo a feira",12,R.drawable.pulpof,dao.queryForId(1));
            Producto pulpog = new Producto("Pulpo a la Gallega",12.5,R.drawable.pulpog,dao.queryForId(1));
            Producto calamares = new Producto("Calamares",8.8,R.drawable.calamares,dao.queryForId(1));
            Producto chipirones = new Producto("Chipirones",8.3,R.drawable.chipirones,dao.queryForId(1));
            Producto pimientos = new Producto("Pimientos de Padrón",4.4,R.drawable.pimientos,dao.queryForId(1));
            Producto esparragos = new Producto("Espárragos con mahonesa",5,R.drawable.esparragos,dao.queryForId(1));

            daoP.create(caldo);
            daoP.create(ensalada);
            daoP.create(ensaladam);
            daoP.create(ensaladap);
            daoP.create(ensaladas);
            daoP.create(pate);
            daoP.create(jamons);
            daoP.create(pulpof);
            daoP.create(pulpog);
            daoP.create(calamares);
            daoP.create(chipirones);
            daoP.create(pimientos);
            daoP.create(esparragos);

            //mariscos

            Producto percebes = new Producto("Percebes",13, R.drawable.percebes,dao.queryForId(2));
            Producto almejas = new Producto("Almejas a la marinera",11,R.drawable.almejas,dao.queryForId(2));
            Producto mejisv = new Producto("Mejillones al vapor",6.3,R.drawable.mejisv,dao.queryForId(2));
            Producto mejismari = new Producto("Mejillones a la marinera",6.7,R.drawable.mejism,dao.queryForId(2));
            Producto berberechos = new Producto("Berberechos al vapor",6.3,R.drawable.berberechos,dao.queryForId(2));
            Producto navajas = new Producto("Navajas",8.7,R.drawable.navajas,dao.queryForId(2));
            Producto gambasp = new Producto("Gambas a la plancha",8.7,R.drawable.gambasp,dao.queryForId(2));
            Producto gambasa = new Producto("Gambas al ajillo",9.3,R.drawable.gambasa,dao.queryForId(2));
            Producto langostinos = new Producto("Langostinos a la plancha",10,R.drawable.langostinos,dao.queryForId(2));

            daoP.create(percebes);
            daoP.create(almejas);
            daoP.create(mejisv);
            daoP.create(mejismari);
            daoP.create(berberechos);
            daoP.create(navajas);
            daoP.create(gambasp);
            daoP.create(gambasa);
            daoP.create(langostinos);


            //pescados


            Producto merluzag = new Producto("Merluza a la Gallega",13, R.drawable.merluzag,dao.queryForId(3));
            Producto merluzar = new Producto("Merluza a la Romana",13,R.drawable.merluzar,dao.queryForId(3));
            Producto merluzap = new Producto("Merluza a la Plancha",13,R.drawable.merluzap,dao.queryForId(3));
            Producto merluzasv = new Producto("Merluza en salsa verde con almejas",32,R.drawable.merluzasv,dao.queryForId(3));
            Producto rapante = new Producto("Rapante",9,R.drawable.rapante,dao.queryForId(3));
            Producto solla = new Producto("Solla a la Plancha",9.5,R.drawable.sollap,dao.queryForId(3));
            Producto sollaf = new Producto("Solla Frita",9.5,R.drawable.sollaf,dao.queryForId(3));
            Producto pescadillas = new Producto("Pescadillas",9,R.drawable.pescadillas,dao.queryForId(3));
            Producto rayac = new Producto("Raya en Caldeirada",10,R.drawable.rayac,dao.queryForId(3));
            Producto rayap = new Producto("Raya a la Plancha",10,R.drawable.rayap,dao.queryForId(3));
            Producto bacalaog = new Producto("Bacalao a la Gallega",12.5,R.drawable.bacalaog,dao.queryForId(3));
            Producto bonito = new Producto("Bonito a la Plancha",8.8,R.drawable.bonito,dao.queryForId(3));
            Producto lenguado = new Producto("Lenguado a la Plancha",8.3,R.drawable.lenguado,dao.queryForId(3));
            Producto rapepl = new Producto("Rape a la Plancha",4.4,R.drawable.rapep,dao.queryForId(3));
            Producto rapesv = new Producto("Rape en salsa verde con almejas",5,R.drawable.rapesv,dao.queryForId(3));

            daoP.create(merluzag);
            daoP.create(merluzar);
            daoP.create(merluzap);
            daoP.create(merluzasv);
            daoP.create(rapante);
            daoP.create(solla);
            daoP.create(sollaf);
            daoP.create(pescadillas);
            daoP.create(rayac);
            daoP.create(rayap);
            daoP.create(bacalaog);
            daoP.create(bonito);
            daoP.create(lenguado);
            daoP.create(rapepl);
            daoP.create(rapesv);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) { }



    public Dao<Producto, Integer> getProductoDao() throws SQLException {
        if (productoDao == null) {
            productoDao = getDao(Producto.class);
        }
        return productoDao;
    }

    public Dao<TipoProducto, Integer> getTipoProductoDao() throws SQLException {
        if (tipoProductoDao == null) {
            tipoProductoDao = getDao(TipoProducto.class);
        }
        return tipoProductoDao;
    }



}