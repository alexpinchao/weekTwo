package com.example.weektwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText EditText1, EditText2, EditText3,EditText4;
    TextView ed2;
    CalendarView cal;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        savedInstanceState();

        EditText1 = findViewById(R.id.EditText1);
        EditText2 = findViewById(R.id.EditText2);
        EditText3 = findViewById(R.id.EditText3);
        EditText4 = findViewById(R.id.EditText4);


        ed2 = findViewById(R.id.ed2);
        cal = findViewById(R.id.calendarView);
        button1 = findViewById(R.id.button1);
        Bundle parametros = getIntent().getExtras();

        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String fecha = i2 + "/"+i1+"/"+i;
                ed2.setText(fecha);
            }
        });

        if (parametros != null && !parametros.isEmpty()){

            String nombre = parametros.getString("nombre");
            String fecha = parametros.getString("fecha");
            String telefono = parametros.getString("telefono");
            String email = parametros.getString("email");
            String descripcion = parametros.getString("descripcion");

            EditText1.setText(nombre);
            ed2.setText(fecha);
            EditText2.setText(telefono);
            EditText3.setText(email);
            EditText4.setText(descripcion);

        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,ConfirmarDatos.class);
                String nombre = String.valueOf(EditText1.getText());
                String fecha = String.valueOf(ed2.getText());
                String telefono = String.valueOf(EditText2.getText());
                String email = String.valueOf(EditText3.getText());
                String descripcion = String.valueOf(EditText4.getText());

                intent.putExtra("nombre", nombre);
                intent.putExtra("fecha", fecha);
                intent.putExtra("telefono", telefono);
                intent.putExtra("email", email);
                intent.putExtra("descripcion", descripcion);
                startActivity(intent);

            }
        });
    }

    private void savedInstanceState() {
    }
}