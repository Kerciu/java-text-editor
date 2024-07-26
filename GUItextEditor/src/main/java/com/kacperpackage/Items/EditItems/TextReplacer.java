package main.java.com.kacperpackage.Items.EditItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextReplacer {
    private TextEditorGUI textEditorGUI;
    private JTextField patternTextField;
    private JTextField goalTextField;
    private static final Color HIGHLIGHT_COLOR = Color.PINK;

    public TextReplacer(TextEditorGUI textEditorGUI, TextReplacerDialog textReplacerDialog, JTextField textField, JTextField goalTextField) {
        this.textEditorGUI = textEditorGUI;
        this.patternTextField = textField;
        this.goalTextField = goalTextField;

        // addWindowListener(textReplacerDialog);
        // addDocumentListener();
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
                // removeHighlights();
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

    }


}
