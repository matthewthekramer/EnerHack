package com.jackandmatt.enerhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Object TextView;
    private TextView mostused;
    private Analyzer anal;
    private int mostUsedNode;
    private double points;
    private TextView pts;
    private Button turn_off;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent recieve = this.getIntent();

        mostused = (TextView) findViewById(R.id.most_used_text);
        int x = 0;
        anal = new Analyzer();
        mostUsedNode = anal.calcMostUsedNode();
        mostused.setText("Device " + mostUsedNode + "is costing you the most points.");
        points = recieve.getDoubleExtra("Score", 0);
        ProgressBar bar = (ProgressBar) findViewById(R.id.determinateBar);
//        bar.setMax(100);
        bar.setProgress((int) (recieve.getDoubleExtra("Average", 25) * 100));
        Log.v("PROGRESS BAR AMOUNG", (recieve.getDoubleExtra("Average", 25) * 100)+ "");
        pts = (TextView) findViewById(R.id.points_total);
        pts.setText("" + recieve.getDoubleExtra("Score", 230));
        turn_off = (Button) findViewById(R.id.turn_off_button);
    }

    public void turn_off(View v){
        anal.turnOffNode(mostUsedNode);
        points += 5;
        pts.setText("" + points);
        turn_off.setEnabled(false);

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
