package se311;

import java.io.*;
import java.net.*;
import java.util.Date;

public class RequestHandler extends Thread {

    private Socket clientSocket = null;

    public RequestHandler(Socket _clientSocket) {
        clientSocket = _clientSocket;
    }

    public void run() {

        try {

            // Create an OutputStream to write to the Client
            PrintStream out = new PrintStream(clientSocket.getOutputStream());
            out.println("Time from server: " + new Date());

            // Create an InputStream to read from the Client
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String line;
            while((line = in.readLine()) != null) {
                System.out.println("Message from Client: " + line);
            }

            out.close();
            in.close();
            clientSocket.close();

        } catch (IOException ioex) {
            ioex.printStackTrace();
        }

    }


}
