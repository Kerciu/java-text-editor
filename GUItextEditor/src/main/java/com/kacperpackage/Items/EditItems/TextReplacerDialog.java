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
    private JTextField goalTextField;
    private JButton patternReplaceButton;
    private JButton patternFindButton;

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
        JLabel replaceWithPatternLabel = createReplaceWithPatternLabel();
        goalTextField= createReplacePatternField();
        patternFindButton = createPatternFindButton();
        patternReplaceButton = createPatternReplaceButton();

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        
        inputPanel.add(replacePatternLabel);
        inputPanel.add(patternTextField);
        inputPanel.add(replaceWithPatternLabel);
        inputPanel.add(goalTextField);

        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(patternFindButton);
        inputPanel.add(patternReplaceButton);

        add(inputPanel, BorderLayout.CENTER);
        pack();

        new TextFindManager(textEditorGUI, this);
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

    private JLabel createReplaceWithPatternLabel() {
        return new JLabel("Enter Pattern to Replace with");
    }

    private JTextField createSearchPatternField() {
        return new JTextField(20);
    }

    private JTextField createReplacePatternField() {
        return new JTextField(20);
    }

    private JButton createPatternReplaceButton() {
        JButton searchButton = new JButton("Replace");
        searchButton.addActionListener(
                createReplaceButtonActionListener()
        );
        return searchButton;
    }

    private JButton createPatternFindButton() {
        JButton findButton = new JButton("Find");
        findButton.addActionListener(
                createFindButtonActionListener()
        );
        return findButton;
    }

    private ActionListener createReplaceButtonActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replacePattern();
            }
        };
    }

    private ActionListener createFindButtonActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextParser.parsePatternToSearchFor(textEditorGUI, patternTextField);
            }
        };
    }

    private void replacePattern() {
        String patternToReplace = patternTextField.getText();
        String replacementText = goalTextField.getText();

        if (patternToReplace.isEmpty() || replacementText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Both fields must be filled out", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String textContent = textEditorGUI.getTextArea().getText();
        textContent = textContent.replaceAll(patternToReplace, replacementText);
        textEditorGUI.getTextArea().setText(textContent);
    }

    @Override
    public void dispose() {
        super.dispose();
        instance = null;
    }
}
