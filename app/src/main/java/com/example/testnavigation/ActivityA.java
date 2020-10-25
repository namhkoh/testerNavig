package com.example.testnavigation;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class ActivityA extends AppCompatActivity {

    private Button next;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);
        if (intent == null) {
            intent = new Intent(this,ActivityB.class);
        }
        next = findViewById(R.id.next5);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //nextActivity();
                startActivity(intent);
                //finish();
            }
        });

    }

}