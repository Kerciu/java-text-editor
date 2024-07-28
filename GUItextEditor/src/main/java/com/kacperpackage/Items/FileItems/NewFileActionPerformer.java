package main.java.com.kacperpackage.Items.FileItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewFileActionPerformer {
    public void newFile() {
        JMenuItem newMenuItem = new JMenuItem("New");

        // "new" resets everything
        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // set header title
                textEditorGUI.setTitle("Text Editor");
                // set text area
                textEditorGUI.getTextArea().setText("");
                // reset working file
                workingFile = null;
            }
        });

        fileMenu.add(newMenuItem);
    }

    private void addItems() {
    }

    private JMenuItem createExitMenuItem() {

    }

    private void addExitMenuItemFunctionality() {

    }

    private ActionListener addExitActionListener() {

    }

    private void performExitFunctionality() {

    }
}
