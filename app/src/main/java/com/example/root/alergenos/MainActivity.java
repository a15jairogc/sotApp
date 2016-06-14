package com.example.root.alergenos;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.root.alergenos.adaptador.AdaptadorAlergeno;
import com.example.root.alergenos.clase.Alergenos;
import com.example.root.alergenos.clase.TipoProducto;
import com.squareup.picasso.Picasso;

import java.security.Principal;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageView imageView;
    private static long back_pressed;
    MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mainActivity=this;
        imageView = (ImageView) findViewById(R.id.fotoPortada);
        Picasso.with(getApplicationContext()).load(R.drawable.maint).into(imageView);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }

    @Override
    public void onBackPressed() {

        if (back_pressed + 2000 > System.currentTimeMillis()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
            builder.setMessage("Desea salir de la aplicación?")
                    .setCancelable(false)
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
//                            Intent intent = new Intent(mainActivity, MainActivity.class);
//                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                            intent.putExtra("ExitMe", true);
//                            startActivity(intent);
                            mainActivity.finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        else {
            mainActivity.goToFragInicio();
            getSupportActionBar().setTitle("Inicio");
            back_pressed = System.currentTimeMillis();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_carta) {
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
            goToFragCarta();
        } else if (id == R.id.nav_alergenos) {
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
            goToFragAlergenos();
        } else if (id == R.id.nav_localizacion) {

        } else if (id == R.id.nav_sobre) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void goToFragInicio(){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container,new FragmentInicio(),FragmentInicio.TAG);
        ft.addToBackStack("inicio");
        ft.commit();
    }

    public void goToFragAlergenos(){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.addToBackStack("alergenos");
        ft.replace(R.id.fragment_container,new FragmentAlergeno(), FragmentAlergeno.TAG);
        ft.commit();
    }

    public void goToFragAlergenosDesc(Alergenos alergenos){

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.addToBackStack("alergenos");
        ft.replace(R.id.fragment_container,FragmentDescAlergenos.newInstance(alergenos), FragmentAlergeno.TAG);
        ft.commit();
    }

    public void goToFragCarta(){

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.addToBackStack("carta");
        ft.replace(R.id.fragment_container,new FragmentCarta(), FragmentAlergeno.TAG);
        ft.commit();

    }

    public void goToFragDescCarta(int id){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.addToBackStack("cartadesc");
        ft.replace(R.id.fragment_container, FragmentDescCarta.newInstance(id) ,FragmentAlergeno.TAG);
        ft.commit();

    }

}
