package main.java.com.kacperpackage.items;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import java.awt.*;

public class FontStyler {
    private TextEditorGUI textEditorGUI;
    private FontMenuDialog fontMenuDialog;

    public FontStyler(TextEditorGUI textEditorGUI, FontMenuDialog fontMenuDialog) {
        this.textEditorGUI = textEditorGUI;
        this.fontMenuDialog = fontMenuDialog;
        addFontStyleComponents();
    }

    private void addFontStyleComponents() {
        JLabel fontStyleLabel = new JLabel("Font Style");
        fontStyleLabel.setBounds(145, 5, 125, 10);
        fontMenuDialog.add(fontStyleLabel);

        // display the current font style and all available ones
        JPanel fontStylePanel = new JPanel();
        fontStylePanel.setBounds(145, 15, 25, 168);

        // get current font style
        int currentFontStyle = textEditorGUI.getTextArea().getFont().getStyle();
        String currentFontStyleText;

        switch(currentFontStyle) {
            case Font.PLAIN -> currentFontStyleText = "Plain";
            case Font.BOLD -> currentFontStyleText = "Bold";
            case Font.ITALIC -> currentFontStyleText = "Italic";
            default -> currentFontStyleText = "Bold Italic";
        }

        JTextField currentFontStyleField = new JTextField(currentFontStyleText);
        currentFontStyleField.setPreferredSize(new Dimension(125, 25));
        currentFontStyleField.setEditable(false);
        fontStylePanel.add(currentFontStyleField);

        // display list of all font style available
        JPanel listOfFontStylesPanel = new JPanel();

        // make the layout have only one column
        listOfFontStylesPanel.setLayout(new BoxLayout(listOfFontStylesPanel, BoxLayout.Y_AXIS));
        listOfFontStylesPanel.setBackground(Color.WHITE);

        // list of font styles
        displayFontStyles(listOfFontStylesPanel, "Plain", Font.PLAIN, 12);
        displayFontStyles(listOfFontStylesPanel, "Bold", Font.BOLD, 12);
        displayFontStyles(listOfFontStylesPanel, "Italic", Font.ITALIC, 12);
        displayFontStyles(listOfFontStylesPanel, "Bold Italic", Font.BOLD | Font.ITALIC, 12);

        fontStylePanel.add(listOfFontStylesPanel);

        fontMenuDialog.add(fontStylePanel);
    }

    private void displayFontStyles(JPanel listOfFontStylesPanel, String styleText, int which, int size) {
        JLabel style = new JLabel(styleText);
        style.setFont(new Font("Dialog", which, size));
        listOfFontStylesPanel.add(style);
    }
}
