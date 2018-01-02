package pa4;


public class ScoreTable {

    private static final int scoreLevel1 = 1;
    private static final char[] level1Chars = {'A', 'E', 'I', 'O', 'U', 'L', 'N', 'S', 'T', 'R', 'a', 'e', 'i', 'o', 'u', 'l', 'n', 's', 't', 'r'};
    private static final int scoreLevel2 = 2;
    private static final char[] level2Chars = {'D', 'G', 'd', 'g'};
    private static final int scoreLevel3 = 3;
    private static final char[] level3Chars = {'B', 'C', 'M', 'P', 'b', 'c', 'm', 'p'};
    private static final int scoreLevel4 = 4;
    private static final char[] level4Chars = {'F', 'H', 'V', 'W', 'Y', 'f', 'h', 'v', 'w', 'y'};
    private static final int scoreLevel5 = 5;
    private static final char[] level5Chars = {'K', 'k'};
    private static final int scoreLevel6 = 8;
    private static final char[] level6Chars = {'J', 'X', 'j', 'x'};
    private static final int scoreLevel7 = 10;
    private static final char[] level7Chars = {'Q', 'Z', 'q', 'z'};
    private static int[] SCORE_BOARD = new int[128];

    public ScoreTable() {
        generateScoreTable();
    }

    private static void generateScoreTable() {
        for (char chars : level1Chars) {
            SCORE_BOARD[chars] = scoreLevel1;
        }
        for (char chars : level2Chars) {
            SCORE_BOARD[chars] = scoreLevel2;
        }
        for (char chars : level3Chars) {
            SCORE_BOARD[chars] = scoreLevel3;
        }
        for (char chars : level4Chars) {
            SCORE_BOARD[chars] = scoreLevel4;
        }
        for (char chars : level5Chars) {
            SCORE_BOARD[chars] = scoreLevel5;
        }
        for (char chars : level6Chars) {
            SCORE_BOARD[chars] = scoreLevel6;
        }
        for (char chars : level7Chars) {
            SCORE_BOARD[chars] = scoreLevel7;
        }

    }

    /**
     * This method calculates the score of the string and returns the score
     *
     * @param s the string whose score is to be calculated
     * @return the score of the string
     */
    public int findScoreOf(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += SCORE_BOARD[s.charAt(i)];
        }
        return sum;
    }
}
