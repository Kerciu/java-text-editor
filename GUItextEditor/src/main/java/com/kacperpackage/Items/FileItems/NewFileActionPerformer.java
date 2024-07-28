package main.java.com.kacperpackage.Items.FileItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class NewFileActionPerformer extends ActionPerformer{
    private File workingFile;

    public NewFileActionPerformer(TextEditorGUI textEditorGUI, JMenu fileMenu, File workingFile) {
        super(textEditorGUI, fileMenu);
        this.workingFile = workingFile;
        addItems();
    }

    @Override
    public void addItems() {
        fileMenu.add(createNewMenuItem());
    }

    private JMenuItem createNewMenuItem() {
        JMenuItem newMenuItem = new JMenuItem("New");
        addNewMenuItemFunctionality(newMenuItem);
        return newMenuItem;
    }

    private void addNewMenuItemFunctionality(JMenuItem newMenuItem) {
        newMenuItem.addActionListener(
                createNewActionListener()
        );
    }

    private ActionListener createNewActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performNewFunctionality();
            }
        };
    }

    private void performNewFunctionality() {
        // set header title
        textEditorGUI.setTitle("Text Editor");
        // set text area
        textEditorGUI.getTextArea().setText("");
        // reset working file
        workingFile = null;
    }
}
