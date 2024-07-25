package main.java.com.kacperpackage.Items.EditItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.Menus.Edit.EditMenu;

import javax.swing.*;

public class TextFinder {
    private TextEditorGUI textEditorGUI;
    private JMenu editMenu;

    public TextFinder(TextEditorGUI textEditorGUI, JMenu editMenu) {
        this.textEditorGUI = textEditorGUI;
        this.editMenu = editMenu;

        addFindMenuItem();
    }

    private void addFindMenuItem() {
        editMenu.add(createFindMenuItem());
    }

    private JMenuItem createFindMenuItem() {
        return new JMenuItem("Find");
    }

}
