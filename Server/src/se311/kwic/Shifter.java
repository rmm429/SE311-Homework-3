package se311.kwic;

public class Shifter {

    private LineStorage stored;

    /**
     * Assign the passed Line Storage object to the local one
     *
     * @param	storageObj	    the Line Storage object
     */
    public void init(LineStorage storageObj) {
        stored = storageObj;
    }

    /**
     * Circular shift each of the stored lines
     */
    public void shiftAllLines() {

        int lineCount = stored.countTotalLines();
        for(int i = 0; i < lineCount; i++) {

            KWICLine oldLine = stored.getOneLine(i).clone();
            int wordCount = oldLine.wordCount();

            for (int j = 1; j < wordCount; j++) {

                KWICLine newLine = oldLine.clone(); // KWIC Line cloned as to not modify the original object
                String lastWord = newLine.getWord(wordCount - 1);
                newLine.insertWord(0, lastWord);
                newLine.delWord(wordCount);
                stored.addKWICLine(newLine);
                oldLine = newLine;

            }

        }
    }

    /**
     * Get the circular shifted lines
     *
     * @return				the circular shifted Line Storage object
     */
    public LineStorage getShiftLines() {
        return stored;
    }

}
