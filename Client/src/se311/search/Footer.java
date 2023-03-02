package se311.search;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Footer extends OutputDecorator {

    public Footer(Output output) {
        super(output);
    }

    /**
     * Output the search results and the footer
     *
     * @param	keyword             the user-inputted keyword
     * @param	linesWithKeyword    all of the lines that contain the keyword
     */
    @Override
    public void outputSearchResults(String keyword, ArrayList<String> linesWithKeyword) {
        decoratedOutput.outputSearchResults(keyword, linesWithKeyword);
        outputFooter();
    }

    /**
     * Outputs the date and time as a footer to the search results
     *
     */
    private void outputFooter() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

}
