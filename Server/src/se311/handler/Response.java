package se311.handler;

import java.io.Serializable;
import java.util.ArrayList;

public class Response implements Serializable {

    ArrayList<String> matchingLines;
    int totalLines;
    int foundLines;

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

    public void addLine(String line) {
        matchingLines.add(line);
    }

    public void setMatchingLines(ArrayList<String> _matchingLines) {
        matchingLines = _matchingLines;
    }

    public void setTotalLines(int _totalLines) {
        totalLines = _totalLines;
    }

    public void setFoundLines(int _foundLines) {
        foundLines = _foundLines;
    }

    public ArrayList<String> getMatchingLines() {
        return matchingLines;
    }

    public int getTotalLines() {
        return totalLines;
    }

    public int getFoundLines() {
        return foundLines;
    }

}
