package main.java.com.kacperpackage.Items.EditItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextFinder {
    private TextEditorGUI textEditorGUI;
    private JTextField patternTextField;

    public TextFinder(TextEditorGUI textEditorGUI, TextFinderDialog textFinderDialog, JTextField textField) {
        this.textEditorGUI = textEditorGUI;
        this.patternTextField = textField;

        addWindowListener(textFinderDialog);
        parsePatternToSearchFor(textFinderDialog);
    }

    private void addWindowListener(TextFinderDialog textFinderDialog) {
        textFinderDialog.addWindowListener(
                createWindowListener()
        );
    }

    private WindowAdapter createWindowListener() {
        return new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                removeHighlights();
            }
        };
    }

    private void parsePatternToSearchFor(TextFinderDialog textFinderDialog) {
        String patternToSearch = patternTextField.getText();
        if (patternToSearch.isEmpty()) {
            JOptionPane.showMessageDialog(textFinderDialog, "Please enter a pattern to find", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int[] allOccurencesOfPattern = BoyerMoore.searchAllOccurences(textEditorGUI.getTextArea().getText(), patternToSearch);
        highlightAllOccurences(patternToSearch, allOccurencesOfPattern);
    }

    private void highlightAllOccurences(String pattern, int[] occurrences) {
        Highlighter highlighter = textEditorGUI.getTextArea().getHighlighter();
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.PINK);

        highlighter.removeAllHighlights();

        int startIndex;
        int endIndex;
        for (int i = 0; i < occurrences.length; ++i) {
            try {
                startIndex = occurrences[i];
                endIndex = startIndex + pattern.length();
                highlighter.addHighlight(startIndex, endIndex, painter);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }

    private void removeHighlights() {
        Highlighter highlighter = textEditorGUI.getTextArea().getHighlighter();
        highlighter.removeAllHighlights();
    }
}
