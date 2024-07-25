package main.java.com.kacperpackage.Items.EditItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.Items.FontItems.FontMenuDialog;
import main.java.com.kacperpackage.Menus.Edit.EditMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    private void createTextFinderDialog() {
        new TextFinderDialog(textEditorGUI).setVisible(true);
    }

    private JMenuItem createFindMenuItem() {
        JMenuItem findMenuItem = new JMenuItem("Find");
        findMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // launch font menu
                createTextFinderDialog();

            }
        });
        return findMenuItem;
    }

}
