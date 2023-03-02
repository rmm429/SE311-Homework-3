package se311.search;

import java.util.ArrayList;

public abstract class OutputDecorator implements Output {

    protected Output decoratedOutput;

    public OutputDecorator(Output output) {
        decoratedOutput = output;
    }

    /**
     * Outputs the result of searching for lines with the provided keyword
     * Calls the method of the instantiated Output object passed in previously
     *
     * @param	keyword             the user-inputted keyword
     * @param	linesWithKeyword    all of the lines that contain the keyword
     */
    public void outputSearchResults(String keyword, ArrayList<String> linesWithKeyword) {
        decoratedOutput.outputSearchResults(keyword, linesWithKeyword);
    }

}
