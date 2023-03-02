package se311.handler;

import java.io.Serializable;
import java.util.ArrayList;

public class Response implements Serializable {

    private ArrayList<String> matchingLines;
    private int totalLines;
    private int foundLines;

    public Response() {
        matchingLines = new ArrayList<>();
        totalLines = 0;
        foundLines = 0;
    }

    public Response(ArrayList<String> _matchingLines, int _totalLines, int _foundLines) {
        matchingLines = _matchingLines;
        totalLines = _totalLines;
        foundLines = _foundLines;
    }

    /**
     * Add a single line to the list of matching lines
     *
     * @param   line 	The line to be added
     */
    public void addLine(String line) {
        matchingLines.add(line);
    }

    /**
     * Set the entire list of matching lines
     *
     * @param   _matchingLines 	A list of lines
     */
    public void setMatchingLines(ArrayList<String> _matchingLines) {
        matchingLines = _matchingLines;
    }

    /**
     * Set the number of total lines from the KWIC output
     *
     * @param   _totalLines 	The number of KWIC lines
     */
    public void setTotalLines(int _totalLines) {
        totalLines = _totalLines;
    }

    /**
     * Set the number of matching lines from the search output
     *
     * @param   _foundLines 	The number of matching lines
     */
    public void setFoundLines(int _foundLines) {
        foundLines = _foundLines;
    }

    /**
     * Get the list of matching lines
     *
     * @return                 The list of matching lines
     */
    public ArrayList<String> getMatchingLines() {
        return matchingLines;
    }

    /**
     * Get the number of total lines from the KWIC output
     *
     * @return                 The number of KWIC lines
     */
    public int getTotalLines() {
        return totalLines;
    }

    /**
     * Get the number of matching lines from the search output
     *
     * @return                 The number of matching lines
     */
    public int getFoundLines() {
        return foundLines;
    }

}
