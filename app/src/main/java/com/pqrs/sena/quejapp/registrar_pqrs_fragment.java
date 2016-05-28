package com.pqrs.sena.quejapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class registrar_pqrs_fragment extends Fragment implements View.OnClickListener{


    public registrar_pqrs_fragment() {

    }
        // Required empty public constructor



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_registrar_pqrs, container, false);
        WebServiceManager WebService = new WebServiceManager();
        HashMap miHashRegional = new HashMap<String,String>();
        miHashRegional.put("tabla", "regional");
        miHashRegional.put("campos", "*");
        JSONObject miJsonRegional=WebService.ConsultarDatos(miHashRegional);
        try {
            Toast.makeText(getContext(),miJsonRegional.get("mensaje").toString(),Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
