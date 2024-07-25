package main.java.com.kacperpackage.items;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FontSizer {
    private TextEditorGUI textEditorGUI;
    private FontMenuDialog fontMenuDialog;
    private JTextField currentFontSizeField;

    public FontSizer(TextEditorGUI textEditorGUI, FontMenuDialog fontMenuDialog) {
        this.textEditorGUI = textEditorGUI;
        this.fontMenuDialog = fontMenuDialog;
        initializeFontSizeComponents();
    }

    private void initializeFontSizeComponents() {
        JLabel fontSizeLabel = createFontSizeLabel();
        fontMenuDialog.add(fontSizeLabel);

        JPanel fontSizePanel = createFontSizePanel();
        JPanel listOfFontSizesPanel = createListOfFontSizes();
        fontSizePanel.add(createScrollPane(listOfFontSizesPanel));
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
        currentFontSizeField = new JTextField(
                parseCurrentFontSizeToString(
                        getCurrentFontSize()
                )
        );

        currentFontSizeField.setPreferredSize(new Dimension(125, 25));
        currentFontSizeField.setEditable(false);
        return currentFontSizeField;
    }

    private JPanel createListOfFontSizes() {
        JPanel listOfFontSizesPanel = new JPanel();
        listOfFontSizesPanel.setLayout(new BoxLayout(listOfFontSizesPanel, BoxLayout.Y_AXIS));
        listOfFontSizesPanel.setBackground(Color.WHITE);
        displayListOfAvailableFonts(listOfFontSizesPanel);
        return listOfFontSizesPanel;
    }

    private void displayListOfAvailableFonts(JPanel listOfFontSizesPanel) {
        // from 8 to 72 with 2-sized laps
        for (int i = 8; i < 73; i += 2) {
            JLabel fontSizeValueLabel = new JLabel(Integer.toString(i));
            fontSizeValueLabel.addMouseListener(
                    createMouseListener(fontSizeValueLabel)
            );
            listOfFontSizesPanel.add(fontSizeValueLabel);
        }
    }

    private JScrollPane createScrollPane(JPanel listOfFontSizesPanel) {
        JScrollPane scrollPane = new JScrollPane(listOfFontSizesPanel);
        scrollPane.setPreferredSize(new Dimension(125, 125));
        return scrollPane;
    }

    private void initializeFontSizePanelComponents(JPanel fontSizePanel) {
        fontSizePanel.add(createCurrentFontSizeField());
    }

    private MouseAdapter createMouseListener(JLabel fontSizeValueLabel) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentFontSizeField.setText(fontSizeValueLabel.getText());
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                fontSizeValueLabel.setOpaque(true);
                fontSizeValueLabel.setBackground(Color.PINK);
                fontSizeValueLabel.setForeground(Color.WHITE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                fontSizeValueLabel.setBackground(null);
                fontSizeValueLabel.setForeground(null);
            }
        };
    }
}
