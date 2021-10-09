package com.example.tdstester;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        progressBar = findViewById(R.id.prgressBarId);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
            }
        });
        thread.start();

    }

    public void doWork(){
        for(progress=20;progress<=100;progress = progress+20) {
            try {
                Thread.sleep(500);
                progressBar.setProgress(progress);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void startApp(){
        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }
}