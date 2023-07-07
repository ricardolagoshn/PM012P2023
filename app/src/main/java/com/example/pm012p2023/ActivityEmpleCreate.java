package com.example.pm012p2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.pm012p2023.Config.Empleado;
import com.example.pm012p2023.Config.RestApiMethods;

import org.json.JSONException;
import org.json.JSONObject;

public class ActivityEmpleCreate extends AppCompatActivity {

    private RequestQueue requestQeue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emple_create);

        sendData();
    }

    private void sendData()
    {
        requestQeue = Volley.newRequestQueue(this);

        Empleado emple = new Empleado();
        emple.setNombres("Joel");
        emple.setApellidos("Hernandez");
        emple.setDireccion("Honduras, San Pedro Sula");
        emple.setFechanac("1987-01-01");
        emple.setGenero("M");
        emple.setTelefono("99665534");
        emple.setFoto("sdsdsdsdsdsdsdsdsdsdsdsdsdsdsds");

        JSONObject jsonemple = new JSONObject();

        try
        {
            jsonemple.put("nombres", emple.getNombres());
            jsonemple.put("apellidos", emple.getApellidos());
            jsonemple.put("direccion", emple.getDireccion());
            jsonemple.put("fechanac", emple.getFechanac());
            jsonemple.put("genero", emple.getGenero());
            jsonemple.put("telefono", emple.getTelefono());
            jsonemple.put("foto", emple.getFoto());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        JsonObjectRequest resquest = new JsonObjectRequest(Request.Method.POST,
                                                           RestApiMethods.ApiPost,
                jsonemple, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)
            {
                try {
                    String mensaje = response.getString("message");
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQeue.add(resquest);
    }
}