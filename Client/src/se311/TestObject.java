package se311;

import java.io.*;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TestObject {

    public static void main(String args[]) throws IOException {

        // Get the address information for the local host
        InetAddress localHost = InetAddress.getLocalHost();

        try {

            // Create a socket to connect to the server
            Socket socket = new Socket(localHost.getHostAddress(), 2023);

            // Create an InputStream to read from the Server
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            System.out.println("Message from Server: " + in.readObject());

            // Create an OutputStream to write to the Server
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            // Get user input
            Scanner input = new Scanner(System.in);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                out.writeObject(line);
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            Response res = (Response) in.readObject();
            for(String line:res.getMatchingLines()) {
                System.out.println(line);
            }
            System.out.println(res.getTotalLines());
            System.out.println(res.getFoundLines());

            in.close();
            out.close();
            socket.close();

        } catch (ConnectException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
