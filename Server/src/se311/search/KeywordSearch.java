package se311.search;

import se311.kwic.KWICLine;
import java.util.ArrayList;

public class KeywordSearch {

    private ArrayList<KWICLine> linesWithKeyword;

    public KeywordSearch() {
        linesWithKeyword = new ArrayList<>();
    }

    /**
     * Searches for the keyword amongst the sorted lines and returns those lines
     *
     * @param	keyword             the user-inputted keyword
     * @param	sortedLines         all of the lines, sorted
     */
    public ArrayList<KWICLine> searchForKeyword(String keyword, ArrayList<KWICLine> sortedLines) {

        for(KWICLine line:sortedLines) {
            if (line.getWordList().contains(keyword)) { // Case-sensitive
                linesWithKeyword.add(line);
            }
        }

        return linesWithKeyword;

    }

}
