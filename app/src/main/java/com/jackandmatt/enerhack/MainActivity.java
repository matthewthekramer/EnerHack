package com.jackandmatt.enerhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void turn_off(View v){

    }

    public void chart_onClick(View v){

    }

    public void home_onClick(View v){

    }

    public void goal_onClick(View v){

    }

    public void challenges_onClick(View v){
        Intent intent = new Intent(this, ChallengesActivity.class);
        startActivity(intent);

    }

    public void impact_onClick(View v){

    }
}
