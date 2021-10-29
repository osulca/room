package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView tvId = findViewById(R.id.tvId);
        String id = String.valueOf(getIntent().getExtras().get("id"));
        tvId.setText("id: "+id);
    }
}