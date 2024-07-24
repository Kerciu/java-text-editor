package main.java.com.kacperpackage.menus;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.handlers.FileMenuExecuter;

import javax.swing.*;

public class FileMenu {
    private JMenu fileMenu;
    private FileMenuExecuter fileMenuExecuter;

    public FileMenu(TextEditorGUI textEditorGUI) {
        fileMenu = new JMenu("File");
        fileMenuExecuter = new FileMenuExecuter(textEditorGUI, fileMenu);
        addFileMenuItems();
    }

    public JMenu getFileMenu() {
        return fileMenu;
    }

    private void addFileMenuItems() {
        // "new file" functionality
        fileMenuExecuter.newFile();
        // "open file" functionality
        fileMenuExecuter.openFile();
        // "save" functionality
        fileMenuExecuter.saveFile();
        // "save as" functionality
        fileMenuExecuter.saveAsFile();
        // "exit" functionality
        fileMenuExecuter.exitFile();
    }
}
