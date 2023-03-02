package se311.kwic;

import java.util.ArrayList;

public interface LineStorage {

    void addOneLine(String line);
    void addKWICLine(KWICLine line);
    KWICLine getOneLine(int index);
    ArrayList<KWICLine> getAllLines();
    int countTotalLines();

}
