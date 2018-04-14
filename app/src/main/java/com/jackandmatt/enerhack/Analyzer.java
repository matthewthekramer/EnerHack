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

    public void run() throws InterruptedException {
        String message = "";
        int i = 0;
        while(running) {
            if(i < 9) {
                message = packetAnalyzer("api/turnon/" + i);
                System.out.println(message);
                i++;
            }
            message = (packetAnalyzer("api/getnodestatus/all"));
            System.out.println(message);
            TimeUnit.SECONDS.sleep(5);
        }
    }

    public String packetAnalyzer(String request) {
        String response = client.sendEcho(request);
        //Figure out how to analyze response packet into data you can use
        return response;
    }

    public void turnOff() {
        this.running = false;
    }
}
