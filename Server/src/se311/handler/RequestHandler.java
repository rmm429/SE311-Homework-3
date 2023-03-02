package se311.handler;

import se311.kwic.KWICLine;
import se311.loader.OptionReader;
import se311.search.KeywordSearch;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

public class RequestHandler extends Thread {

    private Socket clientSocket;
    private ArrayList<KWICLine> sortedLines;

    public RequestHandler(Socket _clientSocket, ArrayList<KWICLine> _sortedLines) {
        clientSocket = _clientSocket;
        sortedLines = _sortedLines;
    }

    /**
     * Executes threaded actions upon a call by start()
     */
    public void run() {

        // Read from the config.properties file
        OptionReader.readOptions();

        try {

            // Create an InputStream to read the keyword from the Client
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            String keyword = (String) in.readObject();

            // Keyword Search object
            KeywordSearch searchObj = (KeywordSearch) OptionReader.getObjectFromKey("Search");
            ArrayList<KWICLine> linesWithKeyword = searchObj.searchForKeyword(keyword, sortedLines);

            // Store the found lines as a String ArrayList
            ArrayList<String> lines = new ArrayList<>();
            for(KWICLine line:linesWithKeyword) {
                lines.add(line.getLineAsString());
            }

            // Create an OutputStream to write the Response object to the Client
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            Response res = new Response(lines, sortedLines.size(), linesWithKeyword.size());
            out.writeObject(res);

            // Close the streams and the Client socket
            out.close();
            in.close();
            clientSocket.close();

        } catch (SocketException | SocketTimeoutException se) { // Client closed connection before performing search OR a 5-minute timeout occurred
            try { clientSocket.close(); } catch (IOException ioe) { ioe.printStackTrace(); } // close Client socket on Server side
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

}
