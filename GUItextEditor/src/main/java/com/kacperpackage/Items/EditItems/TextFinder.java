package main.java.com.kacperpackage.Items.EditItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextFinder {
    private TextEditorGUI textEditorGUI;
    private JTextField patternTextField;
    private static final Color HIGHLIGHT_COLOR = Color.PINK;

    public TextFinder(TextEditorGUI textEditorGUI, TextFinderDialog textFinderDialog, JTextField textField) {
        this.textEditorGUI = textEditorGUI;
        this.patternTextField = textField;

        addWindowListener(textFinderDialog);
        addDocumentListener();
        parsePatternToSearchFor();
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

    private void addDocumentListener() {
        patternTextField.getDocument().addDocumentListener(
                createDocumentListener()
        );
    }

    private DocumentListener createDocumentListener() {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                parsePatternToSearchFor();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                parsePatternToSearchFor();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                parsePatternToSearchFor();
            }
        };
    }

    private void parsePatternToSearchFor() {
        String patternToSearch = patternTextField.getText();
        if (patternToSearch.isEmpty()) {
            removeHighlights();
            return;
        }
        int[] allOccurencesOfPattern = BoyerMoore.searchAllOccurences(textEditorGUI.getTextArea().getText(), patternToSearch);
        highlightAllOccurences(patternToSearch, allOccurencesOfPattern);
    }

    private void highlightAllOccurences(String pattern, int[] occurrences) {
        Highlighter highlighter = textEditorGUI.getTextArea().getHighlighter();
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(HIGHLIGHT_COLOR);

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
