package pa4;
// Name: Kavish Jadwani
// USC NetID: jadwani
// CS 455 PA4
// Fall 2017
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This contains the main method. The main class processes the command-line
 * argument and handles any processing errors.t will probably also have the main
 * command loop. Most of the other functionality will be delegated to other
 * object(s) created in main and their methods.
 *
 */
public class WordFinder {

    public static void main(String[] args) {
        String fileName; // intialize the variable with a blank string 
        try {
            if (args.length < 1) {
                fileName = "sowpods.txt";
                //System.out.println("ERROR: missing file name command line argument");
            } else {
                fileName = args[0];
            }
            AnagramDictionary dictOfAnagrams = new AnagramDictionary(fileName);// Generate a map of dictionary words 
            System.out.println("Type . to quit.");
            Scanner in = new Scanner(System.in);
            System.out.print("Rack?");
            String input = in.nextLine();
            while (!input.equals(".")) {
                char[] content = input.toCharArray();
                java.util.Arrays.sort(content);
                String inputToDisplay = new String(content);
                ArrayList<String> subsetsOfInput = Rack.generateSubsetsFromUSerInputString(input, 0);
                //Look for valid words in dictionary and put fetched words in in proper order and then print 
                ArrangeWordsInProperOrder arranger = new ArrangeWordsInProperOrder(subsetsOfInput, dictOfAnagrams, inputToDisplay);
                arranger.arrangeWords();
                arranger.printArrangedWordsWithScore();
                System.out.println("Rack?");
                input = in.nextLine();
            }
        } catch (FileNotFoundException exception) {
            System.out.println(exception);
        }
    }
}
