package se311.kwic;

import java.util.ArrayList;
import java.util.Collections;

public class KWICLine {

    private ArrayList<String> wordList;
    private String originalLine;

    // TA NOTE: instead of storing each original line, point to an instance of the original KWIC Line

    // Take a line as a String, store it, and convert the line to a KWIC line
    public KWICLine(String oriLine) {

        originalLine = oriLine;
        //oriLine = oriLine.replaceAll("\\p{Punct}", "");
        String oriLineNoPunct = oriLine.replaceAll("[,.?;!]", ""); // removes punctuation from the original line

        wordList = new ArrayList<>();
        String[] wordArr = oriLineNoPunct.split(" ");
        Collections.addAll(wordList, wordArr);

    }

    // Take a list of words, store it, and convert the list into a string
    public KWICLine(ArrayList<String> wrdLst) {
        wordList = wrdLst;
        originalLine = String.join(" ", wrdLst);
    }

    // Stores both the original line and the word list
    public KWICLine(String oriLine, ArrayList<String> wrdLst) {
        originalLine = oriLine;
        wordList = wrdLst;

    }

    /**
     * Insert a word into the list at a specific index
     *
     * @param	index	    the index to insert the word
     * @param	word	    the word to add to the list
     */
    public void insertWord(int index, String word) {
        wordList.add(index, word);
    }

    /**
     * Delete a word from the list
     *
     * @param	index	    the index of the word to delete
     */
    public void delWord(int index) {
        wordList.remove(index);
    }

    /**
     * Get a specific word from a line
     *
     * @param	index	    the index of the word in the list
     * @return				the word at the specified index in the list
     */
    public String getWord(int index) {
        return wordList.get(index);
    }

    /**
     * Get the entire list of words
     *
     * @return				the list of words
     */
    public ArrayList<String> getWordList() {
        return wordList;
    }

    /**
     * Get the original line of a KWIC line
     *
     * @return				the line as a String
     */
    public String getOriLine() {
        return originalLine;
    }

    /**
     * Count the number of words in the word list
     *
     * @return				the number of words in the list
     */
    public int wordCount() {
        return wordList.size();
    }

    /**
     * Get the word list as a String
     * NOTE: This differs from the original line since punctuation will have been removed
     *
     * @return				each word in the word list as a String separated by a space
     */
    public String getLineAsString() {
        return String.join(" ", getWordList());
    }

    /**
     * Clone a KWIC Line
     * Used by the shifter as to not edit the original line it is shifting
     *
     * @return				a clone of the KWIC Line object
     */
    public KWICLine clone() {
//        return new KWICLine(getOriLine(), getWordList().toArray(new String[0]).clone());
        return new KWICLine(getOriLine(), (ArrayList<String>) getWordList().clone());
    }

}
