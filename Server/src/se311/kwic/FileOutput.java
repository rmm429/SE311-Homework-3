package se311.kwic;

import se311.loader.OptionReader;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileOutput implements Output {

    /**
     * Output all of the stored lines to a file
     *
     * @param	lines	    the object where the sorted lines are stored
     */
    public void outputLines(ArrayList<KWICLine> lines) {

        String outputFile = OptionReader.getString("OutputFileName"); // output file name from config file

        try {

            FileWriter fileWriter = new FileWriter(outputFile, false);

            for(int i = 0; i < lines.size(); i++) {
                fileWriter.write(lines.get(i).getLineAsString());
                if(i != lines.size() - 1) { // separates each line with a newline except for the last line
                    fileWriter.write("\n");
                }
            }

            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
