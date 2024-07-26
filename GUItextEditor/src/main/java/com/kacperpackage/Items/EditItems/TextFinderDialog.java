package main.java.com.kacperpackage.Items.EditItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFinderDialog extends JDialog {
    private static TextFinderDialog instance;
    private TextEditorGUI textEditorGUI;
    private JTextField patternTextField;
    private JButton patternFindButton;

    public TextFinderDialog(TextEditorGUI textEditorGUI) {
        this.textEditorGUI = textEditorGUI;
        setTitle("FindPattern");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(425, 350);
        setLocationRelativeTo(textEditorGUI);

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
    }

    public static TextFinderDialog getInstance(TextEditorGUI textEditorGUI) {
        if (instance == null) {
            instance = new TextFinderDialog(textEditorGUI);
        }
        return instance;
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
                new TextFinder(textEditorGUI, TextFinderDialog.this, patternTextField);
            }
        };
    }

    @Override
    public void dispose() {
        super.dispose();
        instance = null;
    }
}
