package main.java.com.kacperpackage.Items.EditItems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoyerMoore {
    private static final int numOfCharsInPattern = 256;

    private static void badCharHeuristic(char[] pattern, int[] badCharTable) {
        Arrays.fill(badCharTable, -1);
        for (int i = 0; i < pattern.length; ++i) {
            badCharTable[pattern[i]] = i;
        }
    }

    public static int boyerMooreSearch(String text, String pattern) {
        char[] textCharArray = text.toCharArray();
        char[] patternCharArray = pattern.toCharArray();

        int textLength = text.length();
        int patternLength = pattern.length();

        int[] badCharTable = new int[numOfCharsInPattern];
        badCharHeuristic(patternCharArray, badCharTable);

        int shift = 0; // shift of the pattern with respect to text

        while (shift <= (textLength - patternLength)) {
            int j = patternLength - 1;

            // reduce index j of pattern while characters of pattern and text are matching at this shift
            while (j >= 0 && patternCharArray[j] == textCharArray[shift + j]) {
                j--;
            }

            // if the pattern is present at current shift, then index j will become -1 after the above loop
            if (j < 0) {
                // pattern found at shift
                // store the shift value before continuing
                int foundAtShift = shift;

                // shift the pattern so that the next character in text aligns with the last occurrence of it in pattern
                // the condition shift + patternLength < textLength is necessary for the case when pattern occurs at the end of text
                shift += (shift + patternLength < textLength) ? patternLength - badCharTable[textCharArray[shift + patternLength]] : 1;

                return foundAtShift;
            } else {
                // shift the pattern so that the bad character in text aligns with the last occurrence of it in pattern
                shift += Math.max(1, j - badCharTable[textCharArray[shift + j]]);
            }

        }
        return  -1;
    }

    public static int[] searchAllOccurences(String text, String pattern) {
        char[] textCharArray = text.toCharArray();
        char[] patternCharArray = pattern.toCharArray();

        int textLength = text.length();
        int patternLength = pattern.length();

        int[] badCharTable = new int[numOfCharsInPattern];
        badCharHeuristic(patternCharArray, badCharTable);

        List<Integer> occurrences = new ArrayList<>();
        int shift = 0; // shift of the pattern with respect to text

        while (shift <= (textLength - patternLength)) {
            int foundAtShift = boyerMooreSearch(new String(textCharArray, shift, textLength - shift), pattern);
            if (foundAtShift == -1) {
                break;
            }

            occurrences.add(shift + foundAtShift);
            // move to the next position after the found occurrence
            shift += foundAtShift + patternLength;
        }

        // convert list to array and return
        return occurrences.stream().mapToInt(i -> i).toArray();
    }
}
