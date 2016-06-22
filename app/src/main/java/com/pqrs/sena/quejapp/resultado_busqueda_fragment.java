package com.pqrs.sena.quejapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class resultado_busqueda_fragment extends Fragment implements ListView.OnItemClickListener {

    ListView listView;
    public resultado_busqueda_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_resultado_busqueda, container, false);
        listView=(ListView) v.findViewById(R.id.my_listview);
        List<pqrs_pojo> pqrss=leerPQRS();
        pqrs_adapter adapter=new pqrs_adapter(getContext(), pqrss);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        return  v;

    }
    private List<pqrs_pojo> leerPQRS() {
        List<pqrs_pojo> pqrss=new ArrayList();

        pqrss.add(new pqrs_pojo("aaa","aaa","aaa","aaa"));
        pqrss.add(new pqrs_pojo("bbb","bbb","bbb","bbb"));
        pqrss.add(new pqrs_pojo("ccc","ccc","ccc","ccc"));
        pqrss.add(new pqrs_pojo("ddd","ddd","ddd","ddd"));
        return pqrss;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
