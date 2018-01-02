package pa4;
// Name: Kavish Jadwani
// USC NetID: jadwani
// CS 455 PA4
// Fall 2017
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * A dictionary of all anagram sets. Note: the processing is case-sensitive; so
 * if the dictionary has all lower case words, you will likely want any string
 * you test to have all lower case letters too, and likewise if the dictionary
 * words are all upper case.
 */
public class AnagramDictionary {

    private TreeMap<String, ArrayList<String>> mappedDictionary = new TreeMap<String, ArrayList<String>>();

    /**
     * Create an anagram dictionary from the list of words given in the file
     * indicated by fileName. PRE: The strings in the file are unique.
     *
     * @param fileName the name of the file to read from
     * @throws FileNotFoundException if the file is not found
     */
    public AnagramDictionary(String fileName) throws FileNotFoundException {
            readDictionaryFile(fileName);
    }

    /**
     * Get all anagrams of the given string. This method is case-sensitive. E.g.
     * "CARE" and "race" would not be recognized as anagrams.
     *
     * @param s string to process
     * @return a list of the anagrams of s
     *
     */
    public ArrayList<String> getAnagramsOf(String s) {
        return this.mappedDictionary.get(s);
    }

    /**
     * Get's the dictionary file and reads the file for the words in dictionary.
     * This method form a mapped dictionary out of the given dictionary text
     * file. The mapped dictionary has sorted string as it's key and the
     * corresponding values is an Array List of all the valid anagrams of the
     * key string.
     *
     * @param fileName the name of the file to read from
     * @throws IOException
     */
    private void readDictionaryFile(String fileName) throws FileNotFoundException {
        File inFile = new File(fileName);
        try (Scanner in = new Scanner(inFile)) {
            while (in.hasNextLine()) {
                String word = in.nextLine();
                if (word.contains(" ")) {
                    word = word.substring(0, word.length() - 1);
                }
                char[] content1 = word.toCharArray();
                java.util.Arrays.sort(content1);
                String sortedWord = new String(content1);
                if (mappedDictionary.get(sortedWord) == null) {
                    ArrayList<String> newList = new ArrayList<String>();
                    newList.add(word);
                    mappedDictionary.put(sortedWord, newList);
                } else {
                    ArrayList<String> oldList = mappedDictionary.get(sortedWord);
                    oldList.add(word);
                    mappedDictionary.put(sortedWord, oldList);
                }
            }
        }
    }
}
