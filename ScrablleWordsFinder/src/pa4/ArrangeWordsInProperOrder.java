package pa4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.NavigableMap;

/**
 * This class looks for the rack subsets in the anagram dictionary and on each
 * successful rack subset search, all the corresponding valid words from the
 * anagram dictionary are mapped to a final result map which has scores as keys
 * and array list of strings with same scores as values.
 */
public class ArrangeWordsInProperOrder {

    private TreeMap<Integer, ArrayList<String>> resultMap = new TreeMap<Integer, ArrayList<String>>();
    AnagramDictionary dict;
    ArrayList<String> subsetsOfInput;
    String userInput;
    int countOfPossibleWords;

    public ArrangeWordsInProperOrder(ArrayList<String> rackSubset, AnagramDictionary dictionary, String userString) {
        dict = dictionary;
        subsetsOfInput = rackSubset;
        countOfPossibleWords = 0;
        userInput = userString;
    }

    /**
     * This method searches for all the anagrams for each of the rack subset.
     * After successful dictionary search for a rack subset, score is calculated
     * for that rack subset and the corresponding array list from the dictionary
     * is added to a result map which maps subset score as keys and the array
     * list of valid words having the same scores as values.
     */
    public void arrangeWords() {
        ScoreTable scoreBoard = new ScoreTable();
        for (int k = 0; k < subsetsOfInput.size(); k++) {
            String dictionarySearch = subsetsOfInput.get(k);
            ArrayList<String> solvedWords = new ArrayList<String>();
            if (dict.getAnagramsOf(dictionarySearch) != null) {
                solvedWords.addAll(dict.getAnagramsOf(dictionarySearch));
            }
            if (solvedWords != null) {
                countOfPossibleWords += solvedWords.size();
                int sum = scoreBoard.findScoreOf(dictionarySearch);
                Collections.sort(solvedWords);
                if (this.resultMap.get(sum) == null) {
                    this.resultMap.put(sum, solvedWords);
                } else {
                    ArrayList<String> oldWords = resultMap.get(sum);
                    oldWords.addAll(solvedWords);
                    Collections.sort(oldWords);
                    resultMap.put(sum, oldWords);
                }
            }

        }
    }

    /**
     * This method prints the contents of result map in the proper format as
     * mentioned in the project specification.
     */
    public void printArrangedWordsWithScore() {
        System.out.println("We can make " + countOfPossibleWords + " words from \"" + userInput + "\"");
        if (countOfPossibleWords > 0) {
            System.out.println("All of the words with their scores (sorted by score):");
        }
        NavigableMap nmap = resultMap.descendingMap();
        for (Map.Entry<Integer, ArrayList<String>> entry : this.resultMap.descendingMap().entrySet()) {

            ArrayList<String> finalResult = entry.getValue();

            for (int i = 0; i < finalResult.size(); i++) {
                System.out.println(entry.getKey() + ": " + finalResult.get(i));
            }
        }
    }
}
