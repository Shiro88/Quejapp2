package com.pqrs.sena.quejapp;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Chaquen on 18/06/2016.
 */
public class ListAdapter extends ArrayAdapter<String>{
    private List<String> miLista;
    private Context context;
    public ListAdapter(Context context,int recurso,List<String> list) {
        super(context,recurso,list);
        this.miLista=list;
        this.context=context;
    }


}
