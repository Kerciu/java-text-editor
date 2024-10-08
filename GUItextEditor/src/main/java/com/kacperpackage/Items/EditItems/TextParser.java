package main.java.com.kacperpackage.Items.EditItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;

public class TextParser {
    private static final Color HIGHLIGHT_COLOR = Color.ORANGE;

    public static void parsePatternToSearchFor(TextEditorGUI textEditorGUI, JTextField patternTextField) {
        String patternToSearch = patternTextField.getText();
        if (patternToSearch.isEmpty()) {
            removeHighlights(textEditorGUI);
            return;
        }

        int[] allOccurencesOfPattern = BoyerMoore.searchAllOccurences(textEditorGUI.getTextArea().getText(), patternToSearch);
        highlightAllOccurences(textEditorGUI, patternToSearch, allOccurencesOfPattern);

    }

    private static void highlightAllOccurences(TextEditorGUI textEditorGUI, String pattern, int[] occurrences) {
        Highlighter highlighter = textEditorGUI.getTextArea().getHighlighter();
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(HIGHLIGHT_COLOR);

        highlighter.removeAllHighlights();

        int startIndex;
        int endIndex;
        for (int occurrence : occurrences) {
            try {
                startIndex = occurrence;
                endIndex = startIndex + pattern.length();
                highlighter.addHighlight(startIndex, endIndex, painter);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }

    public static void removeHighlights(TextEditorGUI textEditorGUI) {
        Highlighter highlighter = textEditorGUI.getTextArea().getHighlighter();
        highlighter.removeAllHighlights();
    }
}
