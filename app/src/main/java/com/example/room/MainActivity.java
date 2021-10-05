package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText etTitulo, etDescripcion, etAnho, etPoster;
    AppDatabaseDataSource dataSource;
    TextView tvMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitulo = findViewById(R.id.etTitulo);
        etDescripcion = findViewById(R.id.etDescripcion);
        etAnho = findViewById(R.id.etAnho);
        etPoster = findViewById(R.id.etPoster);
        tvMostrar = findViewById(R.id.tvMostrar);

        dataSource = new AppDatabaseDataSource(this);
        tvMostrar.setText("");

    }

    public void agregar(View view) {
        String titulo, descripcion;
        int anho, poster;

        titulo = etTitulo.getText().toString();
        descripcion = etDescripcion.getText().toString();
        anho = Integer.parseInt(etAnho.getText().toString());
        poster = Integer.parseInt(etPoster.getText().toString());

        Pelicula pelicula = new Pelicula(titulo, descripcion, anho, poster);
        dataSource.crearPelicula(pelicula);
        Toast.makeText(getApplicationContext(), "Se guardó", Toast.LENGTH_SHORT).show();
    }


    public void mostrar(View view) {
        List<Pelicula> peliculas = dataSource.traerPelicula();
        for(Pelicula pelicula: peliculas){
            tvMostrar.append(
                    "Titulo: "+pelicula.getTitulo()+"\n"+
                    "Año: "+pelicula.getAnho()+"\n"+
                    "Descripcion: "+pelicula.getDescripcion()+"\n\n"
            );
        }
    }
}