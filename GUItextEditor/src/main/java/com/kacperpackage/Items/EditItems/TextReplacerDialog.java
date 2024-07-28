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
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);

        JLabel replacePatternLabel = createReplacePatternLabel();
        patternTextField = createSearchPatternField();
        JLabel replaceWithPatternLabel = createReplaceWithPatternLabel();
        goalTextField= createReplacePatternField();
        patternFindButton = createPatternFindButton();
        patternReplaceButton = createPatternReplaceButton();

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(replacePatternLabel, gridBagConstraints);

        gridBagConstraints.gridy = 1;
        add(patternTextField, gridBagConstraints);

        gridBagConstraints.gridy = 2;
        add(replaceWithPatternLabel, gridBagConstraints);

        gridBagConstraints.gridy = 3;
        add(goalTextField, gridBagConstraints);

        JPanel buttonLayoutPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonLayoutPanel.add(patternFindButton);
        buttonLayoutPanel.add(patternReplaceButton);

        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        add(buttonLayoutPanel, gridBagConstraints);
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
        return new JLabel("Enter Pattern to Find");
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
        JButton replaceButton = new JButton("Replace");
        replaceButton.addActionListener(
                createReplaceButtonActionListener()
        );
        replaceButton.setPreferredSize(new Dimension(80, 25));
        return replaceButton;
    }

    private JButton createPatternFindButton() {
        JButton findButton = new JButton("Find");
        findButton.addActionListener(
                createFindButtonActionListener()
        );
        findButton.setPreferredSize(new Dimension(80, 25));
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
