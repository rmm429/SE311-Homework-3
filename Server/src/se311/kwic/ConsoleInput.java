package se311.kwic;

import java.util.Scanner;

public class ConsoleInput implements Input {

    /**
     * Scan text from the the console as input
     *
     * @param	storageObj	    the object where the entered lines will be stored
     */
    public void acceptInput(LineStorage storageObj) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your sentences: (enter a blank line to stop)");
        String curSentence = scanner.nextLine();

        while(true) { // will break when a blank line is entered

            if (curSentence.isEmpty()) { // blank line stops entry
                break;
            }

            storageObj.addOneLine(curSentence);
            curSentence = scanner.nextLine();
        }

    }

}
