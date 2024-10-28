package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvName;
    Button bGo;
    Toast toast;
    EditText etHello;
    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() != RESULT_OK)
                        return;
                    try {
                        String name = result.getData().getStringExtra("name");
                        tvName.setText((!name.isEmpty()) ? ("Your name is: " + name) : ("You didn't enter name"));
                    } catch (NullPointerException e) {
                        toast.setText("Called activity has returned null pointer");
                        toast.show();
                    }
                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bGo = findViewById(R.id.bGo);
        tvName = findViewById(R.id.tvName);
        etHello = findViewById(R.id.etHello);
        bGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CalledActivity.class);
                i.putExtra("HiSaying", etHello.getText().toString());
                mStartForResult.launch(i);
            }
        });

    }
}