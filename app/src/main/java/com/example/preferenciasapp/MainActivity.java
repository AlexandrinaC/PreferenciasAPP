package com.example.preferenciasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    //Creamos un fichero que será mi fichero principal

    public static final String NOMBRE_FICHERO_PREFS = "preferencias";
    public static final String CLAVE_PRIMERA_VEZ = "primera vez";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Leemos el fichero

        //Si es la primera vez
            //Informo
        //Si no es la primera vez
            //Informo
       SharedPreferences sp = getSharedPreferences (NOMBRE_FICHERO_PREFS, MODE_PRIVATE); //EL nombre del fichero primero , y despues, el modo. En nuestro caso, siempre privado. Si no existe el fichero, con esta instruccion me crea el fichero el solo.
        boolean primera_vez = sp.getBoolean(CLAVE_PRIMERA_VEZ, true); //Lee el fichero Clave por primera vez, y si no lo encuentra, el valor que devuelve será true.
        if(primera_vez)
        {
            Log.d("MIAPP", "Es la primera vez que entra");
            //Ahora dejamos marcado que ha entrado.
            SharedPreferences.Editor editor = sp.edit(); //Lo utilizamos para escribir en el fichero.
            editor.putBoolean(CLAVE_PRIMERA_VEZ, false); //Por si ya ha entrado y no es la primera vez que lo hace.

            //Hago commit para que se haga la mustra "buena", la de verdad. Porque si no, mientras tanto estamos trabajando como en una copia de "mentira".
            editor.commit();
        }else{
            Log.d("MIAPP", "No es la primera vez que entra");
        }
    }
}
