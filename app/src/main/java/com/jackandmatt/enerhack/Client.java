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
            address = InetAddress.getByName("192.168.1.236");
        } catch(UnknownHostException e) {
            System.out.println("couldn't find host");
        } catch(Exception e) {
            System.out.println("Exception with creating DatagramSocket");
        }
    }

    public String sendEcho(String msg) {
        buf = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 9931);
        try {
            socket.send(packet);
            System.out.println(packet.toString());
        } catch(IOException e) {
            System.out.println("IOexception");
        }
        buf = new byte[256];
        packet = new DatagramPacket(buf, buf.length);
        try {
            socket.receive(packet);
            System.out.println(packet.toString());
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
