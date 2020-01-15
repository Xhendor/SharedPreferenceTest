package com.uabc.edu.sharedp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class SensoresActivity extends AppCompatActivity implements
        SensorEventListener {

        private SensorManager sensorManager;
        private TextView equis,ye,zeta;
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

        sensorManager= (SensorManager) getSystemService(
                SENSOR_SERVICE);

        equis=findViewById(R.id.equis);
        ye=findViewById(R.id.ye);
        zeta=findViewById(R.id.zeta);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
                float z=event.values[0];
                float x=event.values[1];
                float y=event.values[2];
                equis.setText(""+x);
                ye.setText(""+y);
                zeta.setText(""+z);
        }
        if(event.sensor.getType()==Sensor.TYPE_ORIENTATION){

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
            sensorManager.registerListener(
                    this,sensorManager.
                    getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                    SensorManager.SENSOR_DELAY_NORMAL);

        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(
                        Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
