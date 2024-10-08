package main.java.com.kacperpackage.Menus.Edit;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.Items.EditItems.TextReplacerDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextReplaceMenu {
    private final TextEditorGUI textEditorGUI;
    private final JMenu editMenu;

    public TextReplaceMenu(TextEditorGUI textEditorGUI, JMenu editMenu) {
        this.textEditorGUI = textEditorGUI;
        this.editMenu = editMenu;

        addReplaceMenuItem();
    }

    private void addReplaceMenuItem() {
        editMenu.add(createReplaceMenuItem());
    }

    private JMenuItem createReplaceMenuItem() {
        JMenuItem replaceMenuItem = new JMenuItem("Replace");
        replaceMenuItem.addActionListener(
                createActionListener()
        );
        return replaceMenuItem;
    }

    private ActionListener createActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // launch font menu
                TextReplacerDialog textReplacerDialog = TextReplacerDialog.getInstance(textEditorGUI);
                textReplacerDialog.setVisible(true);
                textReplacerDialog.toFront();
            }
        };
    }
}
