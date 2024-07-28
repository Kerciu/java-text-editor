package main.java.com.kacperpackage.Items.EditItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextFindManager {
    private TextEditorGUI textEditorGUI;

    public TextFindManager(TextEditorGUI textEditorGUI, JDialog textFinderDialog) {
        this.textEditorGUI = textEditorGUI;

        addWindowListener(textFinderDialog);
        addTextAreaDocumentListener();
    }

    private void addWindowListener(JDialog textFinderDialog) {
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

    private void addTextAreaDocumentListener() {
        textEditorGUI.getTextArea().getDocument().addDocumentListener(
                new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        TextParser.removeHighlights(textEditorGUI);
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        TextParser.removeHighlights(textEditorGUI);
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        TextParser.removeHighlights(textEditorGUI);
                    }
                }
        );
    }
}
