package com.example.tdstester;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    private EditText et;
    private TextView showRes;
    private int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        et = findViewById(R.id.inputEditText);
        showRes = findViewById(R.id.ShowResult);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
    public void ShowResult(View view) {
        String value = et.getText().toString();
        if (value.isEmpty()) {
            et.setError("Please Enter a value!!");
            Toast.makeText(this, "This field must not be empty!!", Toast.LENGTH_SHORT).show();
        }
        else if(value.length()>4){
            et.setError("Range exceeded!!");
        }
        else {
            int val = Integer.parseInt(et.getText().toString());
            this.Category(val);
            et.setText(null);
        }
    }
    public void Category(int v){
        if(v<50){
            String message = v+ " ppm. Less than 50. Unacceptable as it lacks essential minerals. Our body need minerals. Drinking water with appropriate amount of minerals can full fill the need of minerals in our body. As this water has less than 50 miligram minerals per liter, this is not enough minerals.";
            showRes.setText(message);
        }
        else if(v>=50 && v<150){
            String message = v+ " ppm. 50-150 Acceptable for drinking. The TDS level is ideal for areas where the water polluted by sewage or industrial waste. As this water has 50 to 150 miligram minerals per liter, this is acceptable amount of minerals for our body.";
            showRes.setText(message);
        }
        else if(v>=150 && v<250){
            String message = v+ " ppm. 150-250 Good. The water is ideal for people with cardiovascular disease. As this water has 1500 to 250 miligram minerals per liter, this is good amount of minerals for our body.";
            showRes.setText(message);
        }
        else if(v>=250 && v<300){
            String message = v+ " ppm. 250-350 Good. The water is ideal for people with cardio vascular disease";
            showRes.setText(message);
        }
        else if(v>=300 && v<500){
            String message = v+ " ppm. 350-500 Fairly acceptable. As this water has 350 to 500 miligram minerals per liter, this is fairly accetable.  amount of minerals for our body. Though lower amount would be better.";
            showRes.setText(message);
        }
        else if(v>=500 && v<900){
            String message = v+ " ppm. 500-900 Less acceptable. As this water has 500 to 900 miligram minerals per liter, this is not good amount of minarales for body. It is not preferred to drink this in regular basis.";
            showRes.setText(message);
        }
        else if(v>=900 && v<1200){
            String message = v+ " ppm. 900-1200 Least acceptable. Avoid drinking water which has a TDS level of 900. This is not acceptable for drinking. It has way too much minerals. This amount of mineral can cause health concern. ";
            showRes.setText(message);
        }
        else if(v>=1200 && v<2000){
            String message = v+ " ppm. 1200-2000 Water is not acceptable for drinking.";
            showRes.setText(message);
        }
        else if(v>=2000){
            String message = v+ " ppm. Above 2000. Unacceptable";
            showRes.setText(message);
        }
    }

    public void goToAbout(View view) {
        Intent intent = new Intent(HomeActivity.this,AboutActivity.class);
        startActivity(intent);

    }
}