package se311.kwic;

import se311.loader.OptionReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInput implements Input {

    /**
     * Scan text from a file as input
     *
     * @param	storageObj	the object where the lines from the file will be stored
     */
    public void acceptInput(LineStorage storageObj) {

        String inputFile = OptionReader.getString("InputFileName"); // file name from config file

        try {

            Scanner scanner = new Scanner(new File(inputFile));

            while (scanner.hasNextLine()) {
                storageObj.addOneLine(scanner.nextLine());
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.err.println("ERROR: File not found!");
        }

    }

}
