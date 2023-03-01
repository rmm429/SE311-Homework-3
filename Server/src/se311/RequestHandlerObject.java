package se311;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

public class RequestHandlerObject {

    private Socket clientSocket = null;

    public RequestHandlerObject(Socket _clientSocket) {
        clientSocket = _clientSocket;
    }

    public void run() {

        try {

            // Create an OutputStream to write to the Client
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            out.writeObject("Time from Server: " + new Date());

            // Create an InputStream to read from the Client
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            ArrayList<String> lines = new ArrayList<>();
            while(true) {
                String message = (String) in.readObject();
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println("Message from Client: " + message);
                lines.add(message);
            }

            Response res = new Response(lines, 10, 5);
            out.writeObject(res);

            out.close();
            in.close();
            clientSocket.close();

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

}
