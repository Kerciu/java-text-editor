package main.java.com.kacperpackage.Items.EditItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFinderDialog extends JDialog {
    private TextEditorGUI textEditorGUI;
    private JTextField patternTextField;
    private JButton patternFindButton;
    private static final Color HIGHLIGHT_COLOR = Color.PINK;

    public TextFinderDialog(TextEditorGUI textEditorGUI) {
        setTitle("FindPattern");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(425, 350);
        setLocationRelativeTo(textEditorGUI);
        setModal(true);

        setLayout(null);
        initializeComponents();
    }

    private void initializeComponents() {
        setLayout(new BorderLayout());

        JLabel findPatternLabel = createFindPatternLabel();
        patternTextField = createSearchPatternField();
        patternFindButton = createPatternFindButton();

        JPanel inputPanel = new JPanel();
        inputPanel.add(findPatternLabel);
        inputPanel.add(patternTextField);

        add(inputPanel, BorderLayout.CENTER);
        add(patternFindButton, BorderLayout.SOUTH);
        pack();

        setLocationRelativeTo(textEditorGUI);
    }

    private JLabel createFindPatternLabel() {
        return new JLabel("Enter Pattern to Find");
    }

    private JTextField createSearchPatternField() {
        return new JTextField(20);
    }

    private JButton createPatternFindButton() {
        JButton searchButton = new JButton("Find");
        searchButton.addActionListener(
                createButtonActionListener()
        );
        return searchButton;
    }

    private ActionListener createButtonActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parsePatternToSearchFor();
            }
        };
    }

    private void parsePatternToSearchFor() {
        String patternToSearch = patternTextField.getText();
        if (patternToSearch.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a pattern to find", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int[] allOccurencesOfPattern = BoyerMoore.searchAllOccurences(textEditorGUI.getTextArea().getText(), patternToSearch);
        highlightAllOccurences(patternToSearch, allOccurencesOfPattern);
    }

    private void highlightAllOccurences(String pattern, int[] occurrences) {

    }
}
