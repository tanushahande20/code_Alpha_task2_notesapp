package com.example.notes_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button insert;
    Animation zoomout ;
    TextView welcome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert = findViewById(R.id.insert);
        welcome = findViewById(R.id.welcome);
        zoomout = AnimationUtils.loadAnimation(MainActivity.this,R.anim.zoom_out);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , InsertActivity.class);
                startActivity(intent);

            }
        });
        welcome.startAnimation(zoomout);
        welcome.setVisibility(View.VISIBLE);
    }
}