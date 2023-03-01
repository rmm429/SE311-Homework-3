package se311;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TestObject {

    public static void main(String args[]) throws Exception {

        // Bind this server to a port
        ServerSocket server = new ServerSocket(2023);

        // Keep listening indefinitely until 'exit' received or program terminates
        while(true) {

            System.out.println("Waiting for Client request...");
            // Create a socket object which will talk to the client
            Socket client = server.accept();

            // Create an OutputStream to write to the Client
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            out.writeObject("Time from Server: " + new Date());

            // Create an InputStream to read from the Client
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            try {
                while(true) {
                    System.out.println("Message from Client: " + in.readObject());
                }
            } catch (EOFException e) {}

            out.close();
            in.close();
            client.close();

        }

    }

}
