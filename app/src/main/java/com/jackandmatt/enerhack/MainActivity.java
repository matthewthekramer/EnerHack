package com.jackandmatt.enerhack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Object TextView;
    private TextView mostused;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mostused = (TextView) findViewById(R.id.most_used_text);
        int x = 0;
        mostused.setText("Device " + x + "is costing you the most points.");
    }

    public void turn_off(View v){

    }

    public void chart_onClick(View v){

    }

    public void home_onClick(View v){

    }

    public void challenges_onClick(View v){

    }

    public void impact_onClick(View v){

    }
}
