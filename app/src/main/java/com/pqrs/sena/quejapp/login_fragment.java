package com.pqrs.sena.quejapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class login_fragment extends Fragment implements View.OnClickListener{

    Button btnIngresar;
    public login_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        btnIngresar = (Button) view.findViewById(R.id.btnIngresar);
        //Aqui agrego el evento onclick
        if (btnIngresar != null) {
            btnIngresar.setOnClickListener(this);
        }
        return view;
    }

    @Override
    public void onClick(View v) {


    }
}
