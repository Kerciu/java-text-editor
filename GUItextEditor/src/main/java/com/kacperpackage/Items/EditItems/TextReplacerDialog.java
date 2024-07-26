package main.java.com.kacperpackage.Items.EditItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextReplacerDialog extends JDialog {
    private static TextReplacerDialog instance;
    private TextEditorGUI textEditorGUI;
    private JTextField patternTextField;
    private JButton patternReplaceButton;

    public TextReplacerDialog(TextEditorGUI textEditorGUI) {
        this.textEditorGUI = textEditorGUI;
        setTitle("Replace Pattern");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(425, 350);
        setLocationRelativeTo(textEditorGUI);

        setLayout(null);
        initializeComponents();
    }

    private void initializeComponents() {
        setLayout(new BorderLayout());

        JLabel replacePatternLabel = createReplacePatternLabel();
        patternTextField = createSearchPatternField();
        patternReplaceButton = createPatternReplaceButton();

        JPanel inputPanel = new JPanel();
        inputPanel.add(replacePatternLabel);
        inputPanel.add(patternTextField);

        add(inputPanel, BorderLayout.CENTER);
        add(patternReplaceButton, BorderLayout.SOUTH);
        pack();
    }

    public static TextReplacerDialog getInstance(TextEditorGUI textEditorGUI) {
        if (instance == null) {
            instance = new TextReplacerDialog(textEditorGUI);
        }
        return instance;
    }

    private JLabel createReplacePatternLabel() {
        return new JLabel("Enter Pattern to Replace");
    }

    private JTextField createSearchPatternField() {
        return new JTextField(20);
    }

    private JButton createPatternReplaceButton() {
        JButton searchButton = new JButton("Replace");
        searchButton.addActionListener(
                createButtonActionListener()
        );
        return searchButton;
    }

    private ActionListener createButtonActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TextReplacer(textEditorGUI, TextReplacerDialog.this, patternTextField);
            }
        };
    }

    @Override
    public void dispose() {
        super.dispose();
        instance = null;
    }
}
