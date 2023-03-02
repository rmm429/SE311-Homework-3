package se311;

import se311.loader.*;
import se311.kwic.*;
import se311.handler.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Controller {	
	
	public static void main(String[] args) throws IOException {

		final int serverPort = 2023;
		final int clientTimeout = 300000; // 5-minute Client timeout

		// Read from the config.properties file
		OptionReader.readOptions();

		// KWIC Input object
		Input kwicInputObj = (Input) OptionReader.getObjectFromKey("Input");

		// Line Storage object
		LineStorage storageObj = (LineStorage) OptionReader.getObjectFromKey("Storage");
		kwicInputObj.acceptInput(storageObj);

		// Shifter object
		Shifter shiftObj = (Shifter) OptionReader.getObjectFromKey("Shifter");
		shiftObj.init(storageObj);
		shiftObj.shiftAllLines();
		LineStorage shiftedLines = shiftObj.getShiftLines();

		// Sorter object
		Sorter sortObj = (Sorter) OptionReader.getObjectFromKey("Sorter");
		sortObj.sortLines(shiftedLines);
		ArrayList<KWICLine> sortedLines = sortObj.getSortedLines();

		// KWIC Output object
		Output kwicOutputObj = (Output) OptionReader.getObjectFromKey("Output");
		kwicOutputObj.outputLines(sortedLines);

		// Bind this Server to a port (local host)
		ServerSocket server = new ServerSocket(serverPort);

		// Request handler that will handle multiple Clients
		while(true) {
			System.out.println("\nWaiting for Client request...");
			Socket client = server.accept();
			client.setSoTimeout(clientTimeout); // wait 5 minutes for a Client request
			System.out.println("Client connected!");
			RequestHandler requestHandler = new RequestHandler(client, sortedLines);
			requestHandler.start();
		}

	}
}
	
