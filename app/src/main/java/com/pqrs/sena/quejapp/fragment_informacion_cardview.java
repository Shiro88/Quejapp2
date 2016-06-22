package com.pqrs.sena.quejapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_informacion_cardview extends Fragment implements View.OnClickListener {


    LinearLayout lyDetallesPeticion, lyPeticion, lyQueja, lyDetallesQueja,lyReclamo, lyDetallesReclamo, lySugerencia, lyDetallesSugerencia;
    private ImageView  img_More_Peticion, img_More_Queja, img_More_Reclamo, img_More_Sugerencia;
    private static final int DURATION = 250;
    private static final float ANGLE=180;

    public fragment_informacion_cardview() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_informacion_cardview, container, false);
        img_More_Peticion=(ImageView)view.findViewById(R.id.ic_more_info_P);
        img_More_Queja=(ImageView)view.findViewById(R.id.ic_more_info_Q);
        img_More_Reclamo=(ImageView)view.findViewById(R.id.ic_more_info_R);
        img_More_Sugerencia=(ImageView)view.findViewById(R.id.ic_more_info_S);
        lyDetallesPeticion = (LinearLayout)view.findViewById(R.id.lyDetallesPeticion);
        lyPeticion = (LinearLayout) view.findViewById(R.id.lyPeicion);
        lyQueja = (LinearLayout)view.findViewById(R.id.lyQueja);
        lyDetallesQueja = (LinearLayout)view.findViewById(R.id.lyDetallesQueja);
        lyReclamo=(LinearLayout)view.findViewById(R.id.lyReclamo);
        lyDetallesReclamo=(LinearLayout)view.findViewById(R.id.lyDetallesReclamo);
        lySugerencia=(LinearLayout)view.findViewById(R.id.lySugerencia);
        lyDetallesSugerencia=(LinearLayout)view.findViewById(R.id.lyDetallesSugerencia);
        lyPeticion.setOnClickListener(this);
        lyQueja.setOnClickListener(this);
        lyReclamo.setOnClickListener(this);
        lySugerencia.setOnClickListener(this);

        return view;
    }

    public void toggleDetails(LinearLayout ly, ImageView img) {

        if (ly==lyDetallesPeticion && img==img_More_Peticion){
            try {
                if (View.GONE == ly.getVisibility()) {
                    ExpandAndCollapseViewUtil.expand(ly, DURATION);
                    img.setImageResource(R.mipmap.ic_more_info);
                    rotate(ANGLE,img);

                } else {
                    ExpandAndCollapseViewUtil.collapse(ly, DURATION);
                    img.setImageResource(R.mipmap.ic_more_info);
                    rotate(-ANGLE,img);
                }
            }
            catch(Exception ex){
                Toast.makeText(getContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
            }

        }else if(ly==lyDetallesQueja && img==img_More_Queja){
            try {
                if (View.GONE == ly.getVisibility()) {
                    ExpandAndCollapseViewUtil.expand(ly, DURATION);
                    img.setImageResource(R.mipmap.ic_more_info);
                    rotate(180.0f,img);

                } else {
                    ExpandAndCollapseViewUtil.collapse(ly, DURATION);
                    img.setImageResource(R.mipmap.ic_more_info);
                    rotate(-180.0f,img);
                }
            }
            catch(Exception ex){
                Toast.makeText(getContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
            }


        }else if(ly==lyDetallesSugerencia && img==img_More_Sugerencia){
            try {
                if (View.GONE == ly.getVisibility()) {
                    ExpandAndCollapseViewUtil.expand(ly, DURATION);
                    img.setImageResource(R.mipmap.ic_more_info);
                    rotate(-180.0f,img);

                } else {
                    ExpandAndCollapseViewUtil.collapse(ly, DURATION);
                    img.setImageResource(R.mipmap.ic_more_info);
                    rotate(180.0f,img);
                }
            }
            catch(Exception ex){
                Toast.makeText(getContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
            }


        }else if(ly==lyDetallesReclamo && img==img_More_Reclamo){
            try {
                if (View.GONE == ly.getVisibility()) {
                    ExpandAndCollapseViewUtil.expand(ly, DURATION);
                    img.setImageResource(R.mipmap.ic_more_info);
                    rotate(-180.0f,img);

                } else {
                    ExpandAndCollapseViewUtil.collapse(ly, DURATION);
                    img.setImageResource(R.mipmap.ic_more_info);
                    rotate(180.0f,img);
                }
            }
            catch(Exception ex){
                Toast.makeText(getContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
            }


        }







        }
    private void rotate ( float angle, ImageView imageView){
        Animation animation = new RotateAnimation(0.0f, angle, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setFillAfter(true);
        animation.setDuration(DURATION);
        imageView.startAnimation(animation);
    }






    @Override
    public void onClick(View v) {
        if (v == lyPeticion) {
            toggleDetails(lyDetallesPeticion, img_More_Peticion);
        }
        else if(v==lyQueja){
            toggleDetails(lyDetallesQueja, img_More_Queja);
        }
        else if (v==lyReclamo){
            toggleDetails(lyDetallesReclamo,img_More_Reclamo);
        }
        else if (v==lySugerencia){
            toggleDetails(lyDetallesSugerencia, img_More_Sugerencia);
        }
    }

    }

