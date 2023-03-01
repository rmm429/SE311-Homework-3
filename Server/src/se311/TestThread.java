package se311;

import java.net.*;

public class TestThread {

    public static void main(String args[]) throws Exception {

        // Bind this server to a port
        ServerSocket server = new ServerSocket(2023);

        // Keep listening indefinitely until 'exit' received or program terminates
        while(true) {

            System.out.println("Waiting for Client request...");
            Socket client = server.accept();
            RequestHandler rh = new RequestHandler(client);
            rh.run();

        }

    }

}
