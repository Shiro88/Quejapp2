package com.pqrs.sena.quejapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Informacion_Fragment extends Fragment{


    public Informacion_Fragment() {


        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view;
        view = inflater.inflate(R.layout.fragment_informacion, container, false);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        Toolbar toolbarCard = (Toolbar) view.findViewById(R.id.toolbarCard);
  //      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
     //       toolbarCard.setTitle(R.string.txvInfoPeticionTitulo);
       // }


        // Inflate the layout for this fragment
        return view;
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

}
