package main.java.com.kacperpackage.Items.EditItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextFinder {
    private TextEditorGUI textEditorGUI;
    private JTextField patternTextField;

    public TextFinder(TextEditorGUI textEditorGUI, TextFinderDialog textFinderDialog, JTextField patternTextField) {
        this.textEditorGUI = textEditorGUI;
        this.patternTextField = patternTextField;

        addWindowListener(textFinderDialog);
        addDocumentListener();
        TextParser.parsePatternToSearchFor(textEditorGUI, patternTextField);
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
                TextParser.removeHighlights(textEditorGUI);
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
                TextParser.parsePatternToSearchFor(textEditorGUI, patternTextField);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                TextParser.parsePatternToSearchFor(textEditorGUI, patternTextField);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                TextParser.parsePatternToSearchFor(textEditorGUI, patternTextField);
            }
        };
    }


}
