/**
 *  https://www.geeksforgeeks.org/problems/generate-all-binary-strings/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
 */

public class GenerateAllBinaryStrings {

    public static List<String> generateBinaryStrings(int n) {
        List<String > res = new ArrayList<>();

        generateStrings(n, "", res);

        return res;
    }

    public static void generateStrings(int n, String currentString, List<String > res) {
        if (currentString.length() == n) {
            res.add(currentString);
            return;
        }

        generateStrings(n, currentString + "0", res);

        if (currentString.isEmpty() || currentString.charAt(currentString.length() - 1) != '1') {
            generateStrings(n, currentString + "1", res);
        }

        return;
    }
}