package main.java.com.kacperpackage.Items.EditItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.Menus.Edit.EditMenu;

import javax.swing.*;

public class TextReplacer {
    private TextEditorGUI textEditorGUI;
    private JMenu editMenu;

    public TextReplacer(TextEditorGUI textEditorGUI, JMenu editMenu) {
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
