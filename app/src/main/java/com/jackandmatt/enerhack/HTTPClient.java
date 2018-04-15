package com.jackandmatt.enerhack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;


public class HTTPClient {
    URL url;
    HttpURLConnection connection;
    private double dailyValue;
    HTTPClient() throws IOException {
        dailyValue = 0.0;
        url = new URL("http://192.168.1.100:8080");
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
    }

    public double getDaily() {
        return dailyValue;
    }

    public void updateDaily() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String input;
        input = in.readLine();
        if(input != null) {
            dailyValue = Double.parseDouble(input);
        }
    }

}
