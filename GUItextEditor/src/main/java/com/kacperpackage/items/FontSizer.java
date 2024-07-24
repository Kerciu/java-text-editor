package main.java.com.kacperpackage.items;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import java.awt.*;

public class FontSizer {
    private TextEditorGUI textEditorGUI;
    private FontMenuDialog fontMenuDialog;

    public FontSizer(TextEditorGUI textEditorGUI, FontMenuDialog fontMenuDialog) {
        this.textEditorGUI = textEditorGUI;
        this.fontMenuDialog = fontMenuDialog;
        initializeFontSizeComponents();
    }

    private void initializeFontSizeComponents() {
        JLabel fontSizeLabel = createFontSizeLabel();
        fontMenuDialog.add(fontSizeLabel);

        JPanel fontSizePanel = createFontSizePanel();
        fontMenuDialog.add(fontSizePanel);
    }

    private JLabel createFontSizeLabel() {
        JLabel fontSizeLabel = new JLabel("Font Size");
        fontSizeLabel.setBounds(275, 5, 125, 10);

        return fontSizeLabel;
    }

    private JPanel createFontSizePanel() {
        JPanel fontSizePanel = new JPanel();
        fontSizePanel.setBounds(275, 15, 125, 160);
        initializeFontSizePanelComponents(fontSizePanel);

        return fontSizePanel;
    }

    private int getCurrentFontSize() {
        return textEditorGUI.getTextArea().getFont().getSize();
    }

    private String parseCurrentFontSizeToString(int currentFontSize) {
        return Integer.toString(currentFontSize);
    }

    private JTextField createCurrentFontSizeField() {
        JTextField currentFontSizeField = new JTextField(
                parseCurrentFontSizeToString(
                        getCurrentFontSize()
                )
        );

        currentFontSizeField.setPreferredSize(new Dimension(125, 25));
        return currentFontSizeField;
    }

    private void initializeFontSizePanelComponents(JPanel fontSizePanel) {
        fontSizePanel.add(createCurrentFontSizeField());
    }
}
