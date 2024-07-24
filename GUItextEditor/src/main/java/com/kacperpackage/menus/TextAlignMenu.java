package main.java.com.kacperpackage.menus;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.TextAlignMenuItem;

import javax.swing.*;

public class TextAlignMenu {
    private TextEditorGUI textEditorGUI;
    private JMenu formatMenu;
    private JMenu textAlignMenu;

    public TextAlignMenu(TextEditorGUI textEditorGUI, JMenu formatMenu) {
        this.textEditorGUI = textEditorGUI;
        this.formatMenu = formatMenu;
        textAlignMenu = new JMenu("Text Align");

        addTextAlignMenuItems();
    }

    public JMenu getTextAlignMenu() {
        return textAlignMenu;
    }

    private void addTextAlignMenuItems() {
        new TextAlignMenuItem("Left", this, textEditorGUI.getTextArea());
        new TextAlignMenuItem("Right", this, textEditorGUI.getTextArea());

        formatMenu.add(textAlignMenu);
    }
}
