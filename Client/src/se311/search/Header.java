package se311.search;

import java.util.ArrayList;

public class Header extends OutputDecorator {

    private int totalRecords;
    private int foundRecords;

    // accepts the total number of records and found records upon construction
    public Header(Output output, int recs, int found) {
        super(output);
        totalRecords = recs;
        foundRecords = found;
    }

    /**
     * Output the header and the search results
     *
     * @param	keyword             the user-inputted keyword
     * @param	linesWithKeyword    all of the lines that contain the keyword
     */
    @Override
    public void outputSearchResults(String keyword, ArrayList<String> linesWithKeyword) {
        outputHeader();
        decoratedOutput.outputSearchResults(keyword, linesWithKeyword);
    }

    /**
     * Outputs the number of results within the total number of records as a header to the search results
     *
     */
    private void outputHeader() {
        System.out.println("[" + foundRecords + "] results are found in [" + totalRecords + "] records");
    }

}
