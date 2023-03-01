package se311;

import java.net.ServerSocket;
import java.net.Socket;

public class TestThreadObject {

    public static void main(String args[]) throws Exception {

        // Bind this server to a port
        ServerSocket server = new ServerSocket(2023);

        // Keep listening indefinitely until 'exit' received or program terminates
        while(true) {

            System.out.println("Waiting for Client request...");
            Socket client = server.accept();
            RequestHandlerObject rh = new RequestHandlerObject(client);
            rh.run();

        }

    }

}
