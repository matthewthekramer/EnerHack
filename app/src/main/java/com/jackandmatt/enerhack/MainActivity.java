package com.jackandmatt.enerhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Object TextView;
    private TextView mostused;
    private Analyzer anal;
    private int mostUsedNode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mostused = (TextView) findViewById(R.id.most_used_text);
        int x = 0;
//        anal = new Analyzer();
//        mostUsedNode = anal.calcMostUsedNode();
//        mostused.setText("Device " + mostUsedNode + "is costing you the most points.");
    }

    public void turn_off(View v){
//        anal.turnOffNode(mostUsedNode);

    }

    public void chart_onClick(View v){

    }

    public void home_onClick(View v){

    }

    public void goal_onClick(View v){
        Intent intent = new Intent(this, NodePickerActivity.class);
        startActivity(intent);
    }

    public void challenges_onClick(View v){
        Intent intent = new Intent(this, ChallengesActivity.class);
        startActivity(intent);

    }

    public void impact_onClick(View v){

    }
}
