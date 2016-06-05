package com.pqrs.sena.quejapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Splash_Screen extends Activity implements LoadingTask.LoadingTaskFinishedListener {
    // Duración en milisegundos que se mostrará el splash
    private final int DURACION_SPLASH = 3000; // 3 segundos

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Tenemos una plantilla llamada splash.xml donde mostraremos la información que queramos (logotipo, etc.)
        setContentView(R.layout.activity_splash_screen);
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.prgbInicial);
        new LoadingTask(progressBar,this).execute("Cargando");


    }

    private void startApp(){
        new Handler().postDelayed(new Runnable(){


            public void run(){
                try {
                    Intent intent = new Intent(Splash_Screen.this, Menu_Principal.class);
                    startActivity(intent);
                    finish();
                }
                catch (Exception ex){
                    Toast.makeText(getApplicationContext(), ex.getMessage().toString(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
                // Cuando pasen los 3 segundos, pasamos a la actividad principal de la aplicación

            }
        }, DURACION_SPLASH);

    }

    private void completeSplash(){
        startApp();
        //finish();
    }

    @Override
    public void onTaskFinished() {
        completeSplash();

    }

}