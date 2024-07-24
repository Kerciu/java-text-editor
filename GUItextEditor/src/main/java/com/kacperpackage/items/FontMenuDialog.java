package main.java.com.kacperpackage.items;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import java.awt.*;

public class FontMenuDialog extends JDialog {
    private TextEditorGUI textEditorGUI;

    public FontMenuDialog(TextEditorGUI textEditorGUI) {
        this.textEditorGUI = textEditorGUI;
        setTitle("Font Settings");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(425, 350);
        setLocationRelativeTo(textEditorGUI);
        setModal(true);

        setLayout(null);

        addMenuComponents();
    }

    private void addMenuComponents() {
        addFontChooser();
    }

    private void addFontChooser() {
        JLabel fontLabel = new JLabel("Font");
        fontLabel.setBounds(10, 5, 125, 10);
        add(fontLabel);

        // display current font and fonts available
        JPanel fontPanel = new JPanel();
        fontPanel.setBounds(10, 15, 125, 250);

        // display current font
        displayCurrentFont(fontPanel);

        // display available fonts
        displayAvailableFonts(fontPanel);

        add(fontPanel);
    }

    private void displayCurrentFont(JPanel fontPanel) {
        JTextField currentFontField = new JTextField(textEditorGUI.getTextArea().getFont().getFontName());
        currentFontField.setPreferredSize(new Dimension(125, 125));
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
        }

        fontPanel.add(scrollPane);
    }
}
