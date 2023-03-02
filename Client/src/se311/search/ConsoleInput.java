package se311.search;

import java.util.Scanner;

public class ConsoleInput implements Input {

    /**
     * Gets a keyword provided by the user from console
     *
     * @return				the user-inputted keyword
     */
    public String getKeyword() {

        System.out.print("Enter a keyword to search: ");
        Scanner scanner = new Scanner(System.in);
        String keyword = scanner.nextLine();
        scanner.close();
        return keyword;

    }

}
