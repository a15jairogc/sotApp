package com.example.root.alergenos.adaptador;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.alergenos.R;
import com.example.root.alergenos.clase.Alergenos;
import com.example.root.alergenos.clase.TipoProducto;
import com.j256.ormlite.stmt.query.In;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zadia Software on 02/05/2016.
 */
public class AdaptadorTipo extends BaseAdapter{

    private Context context;
    private List<TipoProducto> tipoProductoList;
    private ArrayList<Integer> listImages = new ArrayList<>();
    TipoProducto mTipoProducto;

    public AdaptadorTipo(Context context, List<TipoProducto> tipoProductoList){
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
    public TipoProducto getItem(int position) {
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

            convertView = inflater.inflate(R.layout.lv_list_row_carta,parent,false);

            holder = new ViewHolder();

            holder.nombreTipo = (TextView) convertView.findViewById(R.id.tvTipo);
            holder.imgTipo = (ImageView) convertView.findViewById(R.id.imTipoProd);

            convertView.setTag(holder);



        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        mTipoProducto = (TipoProducto) getItem(position);


        holder.nombreTipo.setText(mTipoProducto.getName());
//        Bitmap bm;
//        bm = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(""),100, 100, true);
//        holder.imgTipo = new ImageView(context);
//        holder.imgTipo.setImageBitmap(bm);
        Picasso.with(context).load(mTipoProducto.getImg()).resize(360,180).into(holder.imgTipo);

//        holder.imgTipo.setImageResource(mTipoProducto.getImg());


        return convertView;
    }


}


