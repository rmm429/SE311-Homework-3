package se311;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Scanner;

public class Test {

    public static void main(String args[]) throws IOException {

        // Get the address information for the local host
        InetAddress localHost = InetAddress.getLocalHost();

        try {

            // Create a socket to connect to the server
            Socket socket = new Socket(localHost.getHostAddress(), 2023);

            // Create an InputStream to read from the Server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            System.out.println("Message from Server: " + in.readLine());


            // Create an OutputStream to write to the Server
            PrintStream out = new PrintStream(socket.getOutputStream());
            // Get user input
            Scanner input = new Scanner(System.in);
            while(input.hasNextLine()) {
                String line = input.nextLine();
                if(line.equalsIgnoreCase("exit")) {
                    break;
                }
                out.println(line);
            }

            in.close();
            out.close();
            socket.close();

        } catch (ConnectException e) {
            System.err.println("ERROR: Server not running.");
        }




    }

}
