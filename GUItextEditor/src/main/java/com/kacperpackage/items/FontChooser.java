package main.java.com.kacperpackage.items;


import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FontChooser {
    private TextEditorGUI textEditorGUI;
    private JTextField currentFontField;

    FontChooser(TextEditorGUI textEditorGUI, JPanel fontPanel) {
        this.textEditorGUI = textEditorGUI;
        displayFontChooseFields(fontPanel);
    }

    public void displayFontChooseFields(JPanel fontPanel) {
        displayCurrentFont(fontPanel);
        displayAvailableFonts(fontPanel);
    }

    private void displayCurrentFont(JPanel fontPanel) {
        currentFontField = new JTextField(textEditorGUI.getTextArea().getFont().getFontName());
        currentFontField.setPreferredSize(new Dimension(125, 25));
        currentFontField.setEditable(false);
        fontPanel.add(currentFontField);
    }

    private void displayAvailableFonts(JPanel fontPanel) {
        JPanel listOfFontsPanel = new JPanel();
        listOfFontsPanel.setLayout(new BoxLayout(listOfFontsPanel, BoxLayout.Y_AXIS));

        // make font panel scrollable
        JScrollPane scrollPane = new JScrollPane(listOfFontsPanel);
        scrollPane.setPreferredSize(new Dimension(125, 125));

        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = graphicsEnvironment.getAvailableFontFamilyNames();

        // for each font display them
        for(String s : fontNames) {
            JLabel fontNameLabel = new JLabel(s);
            listOfFontsPanel.add(fontNameLabel);

            fontNameLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // when clicked, set currentFontField to font name
                    currentFontField.setText(s);
                }

                public void mouseEntered(MouseEvent e) {
                    // highlight over font name when mouse hover over them
                    fontNameLabel.setOpaque(true);
                    fontNameLabel.setBackground(Color.PINK);
                    fontNameLabel.setForeground(Color.WHITE);
                }

                public void mouseExited(MouseEvent e) {
                    // stop the highlight
                    fontNameLabel.setBackground(null);
                    fontNameLabel.setForeground(null);
                }
            });
        }

        fontPanel.add(scrollPane);
    }
}
