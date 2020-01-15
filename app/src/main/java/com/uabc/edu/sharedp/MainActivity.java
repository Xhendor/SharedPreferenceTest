package com.uabc.edu.sharedp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sp;
    private EditText uname;
    private EditText pass;
    private Button ingresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = this.getSharedPreferences("mypref",
                Context.MODE_PRIVATE);
        uname=findViewById(R.id.userName);
        pass=findViewById(R.id.passwd);
        String esta=sp.getString("user","not user");
       if(esta.equalsIgnoreCase("not user")){

           Toast.makeText(this,
                   "No hay usuario loggeado",
                   Toast.LENGTH_SHORT).show();
       }else{
           Gson gson=new Gson();
           //Convierte el JSON a Clase
           Usuario elUser=gson.fromJson(esta,Usuario.class);
           cambiarActivity();
       }

        //}else{
          //  Toast.makeText(this,esta,
            //        Toast.LENGTH_SHORT).show();
        //}

        ingresar=findViewById(R.id.loginBtn);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(uname.getText().toString().length()>0&&
                pass.getText().toString().length()>0){
                Usuario user=new Usuario("Juan",
                        uname.getText().toString(),
                        pass.getText().toString().getBytes());
                    Gson gson=new Gson();
                    String userJSON= gson.toJson(user);
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putString("user",userJSON);
                    editor.commit();
                    cambiarActivity();
                }
            }
        });

    }

    private void cambiarActivity() {
        Intent intent=new Intent(this,
                SensoresActivity.class);
        startActivity(intent);
    }
}
