package se311.kwic;

import java.util.ArrayList;

public class BasicLineStorage implements LineStorage {

    //private HashMap<String, KWICLine> storedLines;
    private ArrayList<KWICLine> storedLines;

    public BasicLineStorage() {
        storedLines = new ArrayList<>();
    }

    /**
     * Add a line that is of type String to the list
     *
     * @param	line	    the line to be added
     */
    public void addOneLine(String line) {
        KWICLine curKWICLine = new KWICLine(line);
        storedLines.add(curKWICLine);
    }

    /**
     * Add a line that is of type KWICLine to the list
     *
     * @param	line	    the line to be added
     */
    public void addKWICLine(KWICLine line) {
        storedLines.add(line);
    }

    /**
     * Get a specific line from the list
     *
     * @param	index	    the index of the line
     * @return              the KWIC line object
     */
    public KWICLine getOneLine(int index) {
        return storedLines.get(index);
    }

    /**
     * Get the entire list of lines
     *
     * @return              the list of KWIC lines
     */
    public ArrayList<KWICLine> getAllLines() {
        return storedLines;
    }

    /**
     * Count the number of lines in the list
     *
     * @return              the number of lines in the list
     */
    public int countTotalLines() {
        return storedLines.size();
    }

}
