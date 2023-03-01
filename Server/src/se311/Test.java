package se311;

import java.io.*;
import java.net.*;
import java.util.Date;

public class Test {

    public static void main(String args[]) throws Exception {

        // Bind this server to a port
        ServerSocket server = new ServerSocket(2023);

        // Keep listening indefinitely until 'exit' received or program terminates
        while(true) {

            System.out.println("Waiting for Client request...");
            // Create a socket object which will talk to the client
            Socket client = server.accept();

            // Create an OutputStream to write to the Client
            PrintStream out = new PrintStream(client.getOutputStream());
            out.println("Time from server: " + new Date());

            // Create an InputStream to read from the Client
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            String line;
            while((line = in.readLine()) != null) {
                System.out.println("Message from Client: " + line);
            }

            out.close();
            in.close();
            client.close();

        }

    }

}
