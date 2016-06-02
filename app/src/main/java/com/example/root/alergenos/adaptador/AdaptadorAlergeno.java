package com.example.root.alergenos.adaptador;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.alergenos.clase.Alergenos;
import com.example.root.alergenos.R;

import java.util.List;

/**
 * Created by Zadia Software on 02/05/2016.
 */
public class AdaptadorAlergeno extends BaseAdapter{

    private Context context;
    private List<Alergenos> alergenosList;
    Alergenos mAlergenos;

    public AdaptadorAlergeno(Context context, List<Alergenos> cartaList){
        this.context = context;
        this.alergenosList = cartaList;
    }


    private static class ViewHolder{
        private ImageView imgAlergenos;
        private TextView nombreAlergeno;

    }

    @Override
    public int getCount() {
        return alergenosList.size();
    }

    @Override
    public Object getItem(int position) {
        return alergenosList.get(position);
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

            convertView = inflater.inflate(R.layout.lv_list_row_alergenos,parent,false);
            holder = new ViewHolder();

            //holder.imgAlergenos = (ImageView) convertView.findViewById(R.id.imgAlergeno);
            holder.nombreAlergeno = (TextView) convertView.findViewById(R.id.tvAlergeno);
            convertView.setTag(holder);

        }else{holder = (ViewHolder) convertView.getTag();}

        mAlergenos = (Alergenos) getItem(position);

//        holder.imgAlergenos.setImageResource();
          holder.nombreAlergeno.setText(mAlergenos.getNombre());
        return convertView;
    }




}


