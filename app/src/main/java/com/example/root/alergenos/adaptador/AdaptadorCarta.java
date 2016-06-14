package com.example.root.alergenos.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.alergenos.R;
import com.example.root.alergenos.clase.Producto;
import com.example.root.alergenos.clase.TipoProducto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Zadia Software on 02/05/2016.
 */
public class AdaptadorCarta extends BaseAdapter{

    private Context context;
    private List<Producto> tipoProductoList;
    private ArrayList<Integer> listImages = new ArrayList<>();
    Producto mProducto;

    public AdaptadorCarta(Context context, List<Producto> tipoProductoList){
        this.context = context;
        this.tipoProductoList = tipoProductoList;
    }


    private static class ViewHolder{
        private ImageView imgTipo;
        private TextView nombreTipo;

    }

    @Override
    public int getCount() {
        return tipoProductoList.size();
    }

    @Override
    public Object getItem(int position) {
        return tipoProductoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView==null){

            convertView = inflater.inflate(R.layout.lv_list_row_carta_desc,parent,false);

            holder = new ViewHolder();

            holder.nombreTipo = (TextView) convertView.findViewById(R.id.tvCarta);
            holder.imgTipo = (ImageView) convertView.findViewById(R.id.imCartaDesc);

            convertView.setTag(holder);



        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        mProducto = (Producto) getItem(position);


        //holder.nombreTipo.setText(mTipoProducto.getName());
//        Bitmap bm;
//        bm = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(""),100, 100, true);
//        holder.imgTipo = new ImageView(context);
//        holder.imgTipo.setImageBitmap(bm);
        //Picasso.with(context).load(mTipoProducto.getImg()).resize(360,180).into(holder.imgTipo);

//        holder.imgTipo.setImageResource(mTipoProducto.getImg());


            holder.nombreTipo.setText(mProducto.getNombre());
            Picasso.with(context).load(mProducto.getImg()).resize(360,180).into(holder.imgTipo);



        return convertView;
    }


}


