package pa4;
// Name: Kavish Jadwani
// USC NetID: jadwani
// CS 455 PA4
// Fall 2017
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * A Rack of Scrabble tiles
 */
public class Rack {

    /**
     * Finds all subsets of the multiset starting at position k in unique and
     * mult. unique and mult describe a multiset such that mult[i] is the
     * multiplicity of the char unique.charAt(i). PRE: mult.length must be at
     * least as big as unique.length() 0 <= k <= unique.length() @param uniq
     *
     * ue a string of unique letters @param mult the multiplicity of each letter
     * from unique.
     * @p
     *
     * a
     * ram k the start index for finding subsets
     * @return all subsets of the indicated multiset
     * @author Claire Bono
     */
    private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
        ArrayList<String> allCombos = new ArrayList<>();

        if (k == unique.length()) {  // multiset is empty
            allCombos.add("");
            return allCombos;
        }
        // get all subsets of the multiset without the first unique char
        ArrayList<String> restCombos = allSubsets(unique, mult, k + 1);

        // prepend all possible numbers of the first char (i.e., the one at position k) 
        // to the front of each string in restCombos.  Suppose that char is 'a'...

        String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
        for (int n = 0; n <= mult[k]; n++) {
            for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets 
                // we found in the recursive call
                // create and add a new string with n 'a's in front of that subset
                allCombos.add(firstPart + restCombos.get(i));
            }
            firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
        }
        return allCombos;
    }

    /**
     * This method will take a string as input parameter and generate all
     * subsets possible from the user input string and return the array list of
     * subsets
     *
     * @param t the user input
     * @param k the start index for finding subsets
     * @return returns array list of all subsets
     */
    public static ArrayList<String> generateSubsetsFromUSerInputString(String t, int k) {
        char[] character1 = t.toCharArray();
        java.util.Arrays.sort(character1);
        String s = new String(character1);
        TreeMap<Character, Integer> map = new TreeMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), 1);
            } else {
                int n = map.get(s.charAt(i));
                n++;
                map.put(s.charAt(i), n);
            }
        }
        char[] unique = new char[map.size()];
        int[] mult = new int[map.size()];
        int j = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            unique[j] = (char) entry.getKey();
            mult[j] = (int) entry.getValue();
            j++;
        }
        return allSubsets(new String(unique), mult, k);
    }
}
