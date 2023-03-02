package se311;

import se311.loader.*;
import se311.search.*;
import se311.handler.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

public class Controller {

    public static void main(String[] args) throws IOException {

        final int serverPort = 2023;
        // Get the address information for the local host
        InetAddress localHost = InetAddress.getLocalHost();
        // Set to null here for exception handling if server cannot be reached
        Socket socket = null;

        // Read from the config.properties file
        OptionReader.readOptions();

        try {

            // Create a socket to connect to the server
            System.out.println("Connecting to Server...");
            socket = new Socket(localHost.getHostAddress(), serverPort);
            System.out.println("Connected to Server!\n");

            // Search Input object
            Input searchInputObj = (Input) OptionReader.getObjectFromKey("Input");
            String keyword = searchInputObj.getKeyword();

            // Create an OutputStream to write the keyword to the Server
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(keyword);

            // Create an InputStream to read the Response object from the Server
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Response res = (Response) in.readObject();

            // Search Output object
            Output searchOutputObj = (Output) OptionReader.getObjectFromKey("Output");

            /*
                I could not get the below to work with the provided object loader since the constructors of the decorators require parameters
                The abstract decorator class and footer decorator constructors take one parameter & the header takes two
                The provided object loader does not give an option to accept constructors with parameters
                Also, because the Output Decorator is abstract, using an object loader will not allow me to access the extended methods of the header and footer
                I tried many methods and am quite unfamiliar with object loaders and decorators
                I expect this will dock my grade, but I can explain what issues I was getting if you would like for clarification
             */
            // Determine if a header and/or footer will be added to the search results
            String addHeader = OptionReader.getString("AddHeader");
            String addFooter = OptionReader.getString("AddFooter");
            if(addHeader.equalsIgnoreCase("true")) {
                searchOutputObj = new Header(searchOutputObj, res.getTotalLines(), res.getFoundLines());
            }
            if (addFooter.equalsIgnoreCase("true")) {
                searchOutputObj = new Footer(searchOutputObj);
            }

            // Output the search results (with decorators if requested)
            searchOutputObj.outputSearchResults(keyword, res.getMatchingLines());

            // Close the streams and socket
            in.close();
            out.close();
            socket.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SocketException se) { // cannot reach Server
            System.err.println("ERROR: Server cannot be reached!");
            System.err.println("Either the Server is offline or a search was not performed within 5 minutes");
            if (socket != null) { socket.close(); } // Close connection to Server
        }

    }

}
