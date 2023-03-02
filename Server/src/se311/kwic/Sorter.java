package se311.kwic;

import java.util.ArrayList;
import java.util.Collections;

public class Sorter {

    private ArrayList<KWICLine> lines;

    /**
     * Alphabetically sort the stored lines
     *
     * @param	shiftedLines    the circular shifted lines
     */
    public void sortLines(LineStorage shiftedLines) {

        lines = shiftedLines.getAllLines();

        int lineCount = lines.size();

        for (int i = 0; i < lineCount; i++) {

            for (int j = i + 1; j < lineCount; j++) {
                String curLine = lines.get(i).getLineAsString();
                String nextLine =  lines.get(j).getLineAsString();

                if(curLine.compareToIgnoreCase(nextLine) > 0) { // Uppercase and lowercase letters will be treated the same
                    Collections.swap(lines, i, j);
                }
            }

        }
    }

    /**
     * Get the sorted lines
     *
     * @return				a list of the sorted KWIC Lines
     */
    public ArrayList<KWICLine> getSortedLines() {
        return lines;
    }

}
