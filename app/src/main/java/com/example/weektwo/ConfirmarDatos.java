package com.example.weektwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmarDatos extends AppCompatActivity {

    TextView ed1, ed2, ed3,ed4,ed5;
    Button buttonedtar;
    String nombre,fecha,telefono,email,descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_confirmar);

        Bundle paramtros = getIntent().getExtras();

        nombre = paramtros.getString("nombre");
        fecha = paramtros.getString("fecha");
        telefono = paramtros.getString("telefono");
        email = paramtros.getString("email");
        descripcion = paramtros.getString("descripcion");


        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        ed4 = findViewById(R.id.ed4);
        ed5 = findViewById(R.id.ed5);

        ed1.setText(nombre);
        ed2.setText(fecha);
        ed3.setText(telefono);
        ed4.setText(email);
        ed5.setText(descripcion);

        buttonedtar = findViewById(R.id.buttonedtar);

        buttonedtar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ConfirmarDatos.this,MainActivity.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("fecha", fecha);
                intent.putExtra("telefono", telefono);
                intent.putExtra("email", email);
                intent.putExtra("descripcion", descripcion);
                startActivity(intent);

            }
        });
    }
}