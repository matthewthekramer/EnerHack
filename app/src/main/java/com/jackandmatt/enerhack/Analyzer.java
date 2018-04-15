package com.jackandmatt.enerhack;


/**
 * Created by Jack Long on 4/12/2018.
 */
import java.util.concurrent.TimeUnit;


public class Analyzer {
    private Client client;
    private boolean running;



    public void setRunning(boolean tOrf) {
        this.running = tOrf;
    }


    Analyzer() {
        client = new Client();
        running = true;
    }

    /**
     * parses the values of the nodes from the JSON data
     * @param msg
     * @return
     */
    public double[] parseVals(String msg) {
        double[] vals = new double[8];
        int startArray = msg.indexOf('[');
        int endarray = msg.indexOf(']');
        String temp = msg.substring(startArray + 1, endarray);
        String[] tempArray = temp.split(",");
        for(int i = 0; i < 8; i++)
        {
            vals[i] = Double.parseDouble(tempArray[i]);
        }
        return vals;
    }

    /**
     * calculates the total power consumption of all nodes
     * @return
     */
    public double calcTotalPower() {
        String message = packetAnalyzer("api/getacpoweractive/all");
        //System.out.println(message);
        double[] vals = this.parseVals(message);
        double total = 0.0;
        for(int i = 0; i < vals.length; i++)
        {
            total += total + vals[i];
        }
        return total;
    }
    /**
     * calculates node that with highest power consumption
     * @return
     */
    public int calcMostUsedNode() {
        String message = packetAnalyzer("api/getacpoweractive/all");
        //System.out.println(message);
        double[] vals = this.parseVals(message);
        double max = 0;
        int maxNode = 0;
        for(int i = 0; i < vals.length; i++)
        {
            if(vals[i] >= max)
            {
                max = vals[i];
                maxNode = i;
            }
        }

        return maxNode;
    }
    /**
     * method that turns of a particular node
     * @param node
     */
    public void turnOffNode(int node) {
        String message = packetAnalyzer("api/turnoff/" + node);
        System.out.println(message);
    }
    /**
     * method that turns off all nodes
     */
    public void turnOffAll() {
        String message = packetAnalyzer("api/turnoff/all");
        System.out.println(message);
    }

    /**
     * runs continuously updating total power consumption
     * @throws InterruptedException
     */
    public void run() throws InterruptedException {
        String message = "";
        //message = (packetAnalyzer("api/getacpoweractive/all"));
        System.out.println(message);
        TimeUnit.SECONDS.sleep(5);

    }
    /**
     * sends packets to server and analyzes what is received
     * @param request
     * @return
     */
    public String packetAnalyzer(String request) {
        String response = client.sendEcho(request);
        //Figure out how to analyze response packet into data you can use
        return response;
    }
}
