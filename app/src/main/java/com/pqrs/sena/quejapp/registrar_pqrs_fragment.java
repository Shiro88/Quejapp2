package com.pqrs.sena.quejapp;

import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by FAMILIA on 28/05/2016.
 */
public class registrar_pqrs_fragment extends Fragment implements View.OnClickListener, Spinner.OnItemSelectedListener{
    Spinner spRegional;
    Spinner spCentro;
    Spinner spSede;
    Spinner spTipoPQRS;
    EditText edtNumeroFicha;
    Spinner spCategoriaPQRS;
    CheckBox chAnonimo;
    EditText edtDescripcion;
    Button btnRegistrar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        View v= inflater.inflate(R.layout.fragment_registrar_pqrs, container, false);
        try{
            if(v!=null){

                spRegional=(Spinner)v.findViewById(R.id.spRegional);
                spRegional.setAdapter(traerAdapterDeRecurso(R.array.regionales));
                spRegional.setOnItemSelectedListener(this);


                spCentro=(Spinner)v.findViewById(R.id.spCentro);
                //spCentro.setAdapter(traerAdapterDeRecurso(R.array.centros));
                spCentro.setOnItemSelectedListener(this);


                spSede=(Spinner)v.findViewById(R.id.spSedes);
                //spSede.setAdapter(traerAdapterDeRecurso(R.array.sedes));
                spSede.setOnItemSelectedListener(this);

                spTipoPQRS=(Spinner)v.findViewById(R.id.spTipoPqrs);
                spTipoPQRS.setAdapter(traerAdapterDeRecurso(R.array.spTipoPqrsValues));
                spTipoPQRS.setOnItemSelectedListener(this);

                spCategoriaPQRS=(Spinner)v.findViewById(R.id.spCategoriaPQRS);
                chAnonimo=(CheckBox)v.findViewById(R.id.chbAnonimo);
                chAnonimo.setOnClickListener(this);
                edtDescripcion=(EditText)v.findViewById(R.id.edtDescripcion);
                btnRegistrar=(Button)v.findViewById(R.id.btnRegistrarPqrs);
                if(btnRegistrar!=null){
                    btnRegistrar.setOnClickListener(this);
                }

            }else{
                Toast.makeText(getContext(),"lo sentimos pero la vista es nula",Toast.LENGTH_SHORT).show();
            }

        }catch (Exception nexp){
            nexp.printStackTrace();
            Utilidades.enviarMensaje(getContext(),nexp.getMessage().toString());

        }
        return v;
    }

    private ArrayAdapter traerAdapterDeRecurso(int recurso_array) {
        List<String> miLista= Arrays.asList(getResources().getStringArray(recurso_array));
        ArrayAdapter miAdapter=new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,miLista);
        return miAdapter;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnRegistrarPqrs:
                Boolean permitir=false;
                WebService ws= new WebService();
                Pqrs mipqrs= new Pqrs();

                if(chAnonimo.isChecked()){
                    mipqrs.setStrFk_IdUsuario("NULL");//AQUI LOS DATOS DEL USUARIO CEULA O ID
                    permitir=true;
                }else{
                    mipqrs.setStrFk_IdUsuario("1");//AQUI LOS DATOS DEL USUARIO CEULA O ID
                }

                if(spSede.getSelectedItemPosition()>0){
                    mipqrs.setStrSede(spSede.getSelectedItem().toString());
                    permitir=true;
                }else{
                    Utilidades.enviarMensaje(getContext(),"Por favor selecciona una sede");
                }

                if(spTipoPQRS.getSelectedItemPosition()>0){
                    mipqrs.setStrTipoPeticion(spTipoPQRS.getSelectedItem().toString());
                    permitir=true;
                }else{
                    Utilidades.enviarMensaje(getContext(),"Por favor selecciona un tipo de PQRS");
                }


                if(spCategoriaPQRS.getSelectedItemPosition()>0){
                    mipqrs.setStrTipoCategoriaPeticion(spCategoriaPQRS.getSelectedItem().toString());
                    permitir=true;
                }else{
                    Utilidades.enviarMensaje(getContext(),"Por favor selecciona una categoria");
                }

                if(edtDescripcion.getText().length()>0){
                    mipqrs.setStrDescripcion(edtDescripcion.getText().toString());
                    permitir=true;
                }else{
                    Utilidades.enviarMensaje(getContext(),"Por favor ingresa una descripción");
                }

                if(permitir){

                    ws.crear_registro(getContext(),mipqrs.getRequestParamsInsertar(), new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int i, Header[] headers, byte[] bytes) {
                            //aqui logica de respuesta de servidor
                            try {
                                JSONObject jobj=Utilidades.devolverJson(bytes);
                                Utilidades.enviarMensaje(getContext(),jobj.optString("mensaje"));
                            }catch (JSONException jexp){
                                Utilidades.enviarMensaje(getContext(),jexp.getMessage().toString());
                            }
                        }

                        @Override
                        public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {



                            String s=Utilidades.validarCodigo(i,throwable);
                            Utilidades.enviarMensaje(getContext(),"error=> "+s);


                        }



                    });
                }

                break;
            case R.id.chbAnonimo:
                if(chAnonimo.isChecked()){
                    Utilidades.enviarMensaje(getContext(),"Anonimo");
                }

                break;
        }


    }

    //IMPLEMENTACION DE EVENTOS DEL VIEW SPINNER
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.spRegional:
                        //Utilidades.enviarMensaje(getContext(),parent.getItemAtPosition(position).toString()+"=>"+Integer.toString(position));
                if(position>0){
                    switch (position){
                        case 1:
                            spCentro.setAdapter(traerAdapterDeRecurso(R.array.r1c));
                            break;
                        case 2:
                            spCentro.setAdapter(traerAdapterDeRecurso(R.array.r2c));
                            break;

                    }

                }
                break;
            case R.id.spCentro:
                //Utilidades.enviarMensaje(getContext(),parent.getItemAtPosition(position).toString()+"=>"+Integer.toString(position));
                if(position>0){

                    switch (position){
                        case 1:
                            if(spRegional.getSelectedItemPosition() == 1){
                                spSede.setAdapter(traerAdapterDeRecurso(R.array.r1c1s));
                            }else if(spRegional.getSelectedItemPosition() == 2){
                                spSede.setAdapter(traerAdapterDeRecurso(R.array.r2c2s));
                            }

                            break;
                        case 2:
                            if(spRegional.getSelectedItemPosition() == 1){
                                spSede.setAdapter(traerAdapterDeRecurso(R.array.r1c2s));
                            }else if(spRegional.getSelectedItemPosition() == 2){
                                spSede.setAdapter(traerAdapterDeRecurso(R.array.r1c2s));
                            }

                            break;

                    }
                }
                break;
            case R.id.spSedes:
                //Utilidades.enviarMensaje(getContext(),parent.getItemAtPosition(position).toString()+"=>"+Integer.toString(position));
                if(position>0){

                }
                break;
            case R.id.spTipoPqrs:
                //Utilidades.enviarMensaje(getContext(),parent.getItemAtPosition(position).toString()+"=>"+Integer.toString(position));
                if(position>0){
                    switch(position){
                        case 0:
                            //Utilidades.enviarMensaje(getContext(),"Por favor seleccione una opcion diferente");
                            break;
                        case 1:
                            spCategoriaPQRS.setAdapter(traerAdapterDeRecurso(R.array.spCategoriaPeticion));
                            break;
                        case 2:
                            spCategoriaPQRS.setAdapter(traerAdapterDeRecurso(R.array.spCategoriaQueja));
                            break;
                        case 3:
                            spCategoriaPQRS.setAdapter(traerAdapterDeRecurso(R.array.spCategoriaReclamo));
                            break;
                        case 4:
                            spCategoriaPQRS.setAdapter(traerAdapterDeRecurso(R.array.spCategoriaSugerencia));
                            break;
                    }

                }
                break;
            case R.id.spCategoriaPQRS:
                //Utilidades.enviarMensaje(getContext(),parent.getItemAtPosition(position).toString()+"=>"+Integer.toString(position));
                if(position>0){

                }
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
