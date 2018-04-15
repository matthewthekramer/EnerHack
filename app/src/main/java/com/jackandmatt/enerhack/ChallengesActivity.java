package com.jackandmatt.enerhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChallengesActivity extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        if(expListView == null) Log.v("TEST", "IT IS NULL");
        else Log.v("TEST", "It is not null");
        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Hour of Darkness - 20 Epts");
        listDataHeader.add("1 Day 1 Node - 25 Epts");
        listDataHeader.add("Better than Average - 5 Epts");

        // Adding child data
        List<String> challenge1 = new ArrayList<String>();
        challenge1.add("Go a full hour without using ANY electricity");

        List<String> challenge2 = new ArrayList<String>();
        challenge2.add("Use only one node at a time for an entire day");

        List<String> challenge3 = new ArrayList<String>();
        challenge3.add("Beat the average american's power consumption in a day for the given devices you are using");

        listDataChild.put(listDataHeader.get(0), challenge1); // Header, Child data
        listDataChild.put(listDataHeader.get(1), challenge2);
        listDataChild.put(listDataHeader.get(2), challenge3);
    }

    public void chart_onClick(View v){

    }

    public void home_onClick(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void goal_onClick(View v){

    }

    public void challenges_onClick(View v){

    }

    public void impact_onClick(View v){

    }
}
