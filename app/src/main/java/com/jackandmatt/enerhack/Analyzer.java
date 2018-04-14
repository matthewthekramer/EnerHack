package com.jackandmatt.enerhack;
/**
 * Created by Jack Long on 4/12/2018.
 */

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

    public void run() {
        String message = "";
        message = (packetAnalyzer("api/turnon/0"));
        System.out.println(message);
    }

    public String packetAnalyzer(String request) {
        String response = client.sendEcho(request);
        //Figure out how to analyze response packet into data you can use
        return response;
    }
}
