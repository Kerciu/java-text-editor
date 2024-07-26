package main.java.com.kacperpackage.Menus.Edit;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;

public class TextReplaceMenu {
    private TextEditorGUI textEditorGUI;
    private JMenu editMenu;

    public TextReplaceMenu(TextEditorGUI textEditorGUI, JMenu editMenu) {
        this.textEditorGUI = textEditorGUI;
        this.editMenu = editMenu;

        addReplaceMenuItem();
    }

    private void addReplaceMenuItem() {
        editMenu.add(createReplaceMenuItem());
    }

    private JMenuItem createReplaceMenuItem() {
        return new JMenuItem("Replace");
    }
}
