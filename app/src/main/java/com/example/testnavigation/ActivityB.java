package com.example.testnavigation;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivityB extends AppCompatActivity {
    boolean is_first;
    String tester = "Hello World";
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
//        ActionBar actionbar = getSupportActionBar();
//        if( actionbar != null ) {
//            actionbar.setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        }
        back = findViewById(R.id.back2);
        Log.e("Entering activity", "true");
        Log.e("is_First", String.valueOf(is_first));
        Log.e("is_First", String.valueOf(tester));
        is_first = true;
        tester = "bye world";
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });
    }

    private void goBack() {
        Intent intent = new Intent(this, ActivityA.class);
        startActivity(intent);
        //finish();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        Log.v("bundle", "saved");
        savedInstanceState.putBoolean("Is_first", is_first);
        savedInstanceState.putString("test",tester);
        super.onSaveInstanceState(savedInstanceState);
        Log.e("ONSAVE", "ONSAVE");
        Log.e("onSaveInstanceState", String.valueOf(savedInstanceState.getBoolean("Is_first")));
        Log.e("onSaveInstanceState", String.valueOf(savedInstanceState.getBoolean("tester")));
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        is_first = savedInstanceState.getBoolean("Is_first");
        tester = savedInstanceState.getString("tester",tester);
        System.out.println(is_first);
        Log.e("ONRESTORE", "ONRESTORE");
        Log.e("onRestoreInstanceState", String.valueOf(savedInstanceState.getBoolean("Is_first")));
        Log.e("onRestoreInstanceState", String.valueOf(savedInstanceState.getBoolean("tester")));
    }
}