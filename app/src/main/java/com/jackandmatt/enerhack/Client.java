package com.jackandmatt.enerhack;

/**
 * Created by Jack Long on 4/12/2018.
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Client {
    private DatagramSocket socket;
    private InetAddress address;
    private byte[] buf;

    public Client() {
        try {
            socket = new DatagramSocket();
            address = InetAddress.getByName("localhost"); //TODO find host's name and replace
        } catch(UnknownHostException e) {
            e.getMessage();
        } catch(Exception e) {
            System.out.println("Exception with creating DatagramSocket");
        }
    }

    public String sendEcho(String msg) {
        buf = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
        try {
            socket.send(packet);
        } catch(IOException e) {
            e.getMessage();
        }
        packet = new DatagramPacket(buf, buf.length);
        try {
            socket.receive(packet);
        } catch(IOException e) {
            e.getMessage();
        }
        String received = new String(
                packet.getData(), 0, packet.getLength());
        return received;
    }

    public void close() {
        socket.close();
    }
}
