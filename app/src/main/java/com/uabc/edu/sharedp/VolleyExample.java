package com.uabc.edu.sharedp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class VolleyExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_example);
        peticionVolley();
    }

    public void peticionVolley(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url="https://api.imgflip.com/get_memes";
        StringRequest stringRequest= new StringRequest(
                Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        String res=response;
                        System.err.println(res);
                        Toast.makeText(VolleyExample.this,
                                res,
                                Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(VolleyExample.this,
                                error.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });

        queue.add(stringRequest);
    }
}
