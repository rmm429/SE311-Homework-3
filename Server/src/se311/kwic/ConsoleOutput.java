package se311.kwic;

import java.util.ArrayList;

public class ConsoleOutput implements Output {

    /**
     * Output all of the stored lines to console
     *
     * @param	lines	    the object where the sorted lines are stored
     */
    public void outputLines(ArrayList<KWICLine> lines) {

        for(KWICLine line:lines) {
            System.out.println(line.getLineAsString());
        }

    }

}
