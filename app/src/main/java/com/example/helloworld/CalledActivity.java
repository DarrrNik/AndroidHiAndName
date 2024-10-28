package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalledActivity extends AppCompatActivity {

    EditText etName;
    Button bBack;
    TextView tvSecHello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_called);
        etName = findViewById(R.id.etName);
        bBack = findViewById(R.id.bBack);
        tvSecHello = findViewById(R.id.tvSecHello);
        tvSecHello.setText("You has entered: " + getIntent().getStringExtra("HiSaying").toString());
        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("name", etName.getText().toString());
                setResult(RESULT_OK, i);
                finish();
            }
        });

    }
}