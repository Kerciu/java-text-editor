package main.java.com.kacperpackage.Menus.Edit;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.Items.EditItems.TextFinderDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFindMenu {
    private final TextEditorGUI textEditorGUI;
    private final JMenu editMenu;

    public TextFindMenu(TextEditorGUI textEditorGUI, JMenu editMenu) {
        this.textEditorGUI = textEditorGUI;
        this.editMenu = editMenu;

        addFindMenuItem();
    }

    private void addFindMenuItem() {
        editMenu.add(createFindMenuItem());
    }

    private JMenuItem createFindMenuItem() {
        JMenuItem findMenuItem = new JMenuItem("Find");
        findMenuItem.addActionListener(
            createActionListener()
        );
        return findMenuItem;
    }

    private ActionListener createActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // launch font menu
                TextFinderDialog textFinderDialog = TextFinderDialog.getInstance(textEditorGUI);
                textFinderDialog.setVisible(true);
                textFinderDialog.toFront();
            }
        };
    }

}
