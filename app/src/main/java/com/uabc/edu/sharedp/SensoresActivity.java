package com.uabc.edu.sharedp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.gson.Gson;

public class SensoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores);
        SharedPreferences preferences=getSharedPreferences(
                "mypref",
                MODE_PRIVATE);
       String usuario= preferences.getString("user",
               "not_user");
        if(!usuario.equalsIgnoreCase("not_user")){
            Gson gson=new Gson();
            //Convierte el JSON a Clase
            Usuario elUser=gson.fromJson(usuario,Usuario.class);
            this.setTitle("Hola: "+elUser.getNombre());
        }
    }
}
