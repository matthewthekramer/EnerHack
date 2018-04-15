package com.jackandmatt.enerhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.IOException;

public class NodePickerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public final static int FAN = 0;
    public final static int LIGHT = 1;
    public final static int CHARGER = 2;
    public final static int FRIDGE = 3;

    private int node1;
    private int node2;
    private int node3;
    private int node4;
    private int node5;
    private int node6;

    public double percentageOfAvg() {
        try{
            HTTPClient httpClient = new HTTPClient();
            httpClient.updateDaily();
            double avg = computerAverageConsumption();
            double useage = httpClient.getDaily();
            return (useage / avg);
        } catch(IOException e){

        }
      return 0.0;
    }
    private int computerAverageConsumption() {
        int avgConsumption = 0;
        avgConsumption += computeConsumption(node1);
        avgConsumption += computeConsumption(node2);
        avgConsumption += computeConsumption(node3);
        avgConsumption += computeConsumption(node4);
        avgConsumption += computeConsumption(node5);
        avgConsumption += computeConsumption(node6);
        return avgConsumption;
    }

    public double calculatorScore()  {
        HTTPClient httpClient;
        try {
            httpClient = new HTTPClient();
            httpClient.updateDaily();
            double powerUsed = httpClient.getDaily()/(60 * 24);
            double score = ((this.computerAverageConsumption() - powerUsed)/10);
            return Math.floor(score);
        } catch (IOException e){

        }
        return 0.0;
    }
    private double calcEmmissionsSaved() {
        Analyzer a = new Analyzer();
        int avg = this.computerAverageConsumption();
        double total = a.calcTotalPower();
        double saved = avg - total;
        saved = saved * 0.000018;
        return 24* saved;
    }

    private int computeConsumption(int node){
        if(node == 0){
            return 300;
        }
        else if(node == 1){
            return 180;
        }
        else if(node == 2){
            return 15;
        }
        else if(node == 3) {
            return 870;
        }
        else {
            return 0;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_node_picker);
        initSpinners();
    }

    private void initSpinners(){
        Analyzer a = new Analyzer();
        Spinner spinner1 = (Spinner) findViewById(R.id.node1_spinner);
        
        // Create an ArrayAdapter using the string array and a default spinner layout
        if(a.stateOfNode(0) == 0){
            spinner1.setEnabled(false);
            spinner1.setClickable(false);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.node_options, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);

        Spinner spinner2 = (Spinner) findViewById(R.id.node2_spinner);
        if(a.stateOfNode(1) == 0){
            spinner1.setEnabled(false);
            spinner1.setClickable(false);
        }
        // Apply the adapter to the spinner
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(this);

        Spinner spinner3 = (Spinner) findViewById(R.id.node3_spinner);
        if(a.stateOfNode(2) == 0){
            spinner1.setEnabled(false);
            spinner1.setClickable(false);
        }
        // Apply the adapter to the spinner
        spinner3.setAdapter(adapter);
        spinner3.setOnItemSelectedListener(this);

        Spinner spinner4 = (Spinner) findViewById(R.id.node4_spinner);
        if(a.stateOfNode(3) == 0){
            spinner1.setEnabled(false);
            spinner1.setClickable(false);
        }
        // Apply the adapter to the spinner
        spinner4.setAdapter(adapter);
        spinner4.setOnItemSelectedListener(this);

        Spinner spinner5 = (Spinner) findViewById(R.id.node5_spinner);
        if(a.stateOfNode(4) == 0){
            spinner1.setEnabled(false);
            spinner1.setClickable(false);
        }
        // Apply the adapter to the spinner
        spinner5.setAdapter(adapter);
        spinner5.setOnItemSelectedListener(this);

        Spinner spinner6 = (Spinner) findViewById(R.id.node6_spinner);
        if(a.stateOfNode(6) == 0){
            spinner1.setEnabled(false);
            spinner1.setClickable(false);
        }
        // Apply the adapter to the spinner
        spinner6.setAdapter(adapter);
        spinner6.setOnItemSelectedListener(this);

    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        switch(parent.getId()){
            case(R.id.node1_spinner):
                node1 = pos;
                break;
            case(R.id.node2_spinner):
                node2 = pos;
                break;
            case(R.id.node3_spinner):
                node3 = pos;
                break;
            case(R.id.node4_spinner):
                node4 = pos;
                break;
            case(R.id.node5_spinner):
                node5 = pos;
                break;
            case(R.id.node6_spinner):
                node6 = pos;
                break;
        }
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    public void chart_onClick(View v){

    }

    public void home_onClick(View v){
        Intent send  = new Intent(this, MainActivity.class);
        send.putExtra("Average", percentageOfAvg());
        send.putExtra("Score", calculatorScore());
        startActivity(send);

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
