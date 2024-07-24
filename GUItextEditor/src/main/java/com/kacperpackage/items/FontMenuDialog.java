package main.java.com.kacperpackage.items;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        addFontMenuDialogComponents();
    }

    private void addFontMenuDialogComponents() {
        JLabel fontLabel = new JLabel("Font");
        fontLabel.setBounds(10, 5, 125, 10);
        add(fontLabel);

        // display current font and fonts available
        JPanel fontPanel = new JPanel();
        fontPanel.setBounds(10, 15, 125, 250);

        // display current and available fonts
        addMenuComponents(fontPanel);
        add(fontPanel);
    }

    private void addMenuComponents(JPanel fontPanel) {
        addFontChooser(fontPanel);
        addFontStyler();
        addFontSizer();
    }

    private void addFontChooser(JPanel fontPanel) {
        new FontChooser(textEditorGUI, fontPanel);
    }

    private void addFontStyler() {
        new FontStyler(textEditorGUI, this);
    }

    private void addFontSizer() {
        new FontSizer(textEditorGUI, this);
    }
}
