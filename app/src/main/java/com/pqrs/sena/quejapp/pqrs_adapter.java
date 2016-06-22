package com.pqrs.sena.quejapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hernando on 21/06/2016.
 */
public class pqrs_adapter extends BaseAdapter {
    List<pqrs_pojo> pqrss;

    Context context;


    public pqrs_adapter(Context context,List<pqrs_pojo> pqrss){
        this.context=context;
        this.pqrss = pqrss;

    }

    @Override
    public int getCount() {
        return pqrss.size();
    }

    @Override
    public Object getItem(int position) {
        return pqrss.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.valueOf(pqrss.get(position).getCodigo());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.layoutrow,parent,false);
        }
        pqrs_pojo pqrs=(pqrs_pojo)getItem(position);
        TextView codigo=(TextView)convertView.findViewById(R.id.codigo);
        TextView descripcion=(TextView)convertView.findViewById(R.id.descripcion);
        TextView fecha=(TextView)convertView.findViewById(R.id.fecha);
        TextView estado=(TextView)convertView.findViewById(R.id.estado);
        codigo.setText(pqrs.getCodigo());
        descripcion.setText(pqrs.getDescripcion());
        fecha.setText(pqrs.getFecha());
        estado.setText(pqrs.getEstado());

        return convertView;
    }
}
