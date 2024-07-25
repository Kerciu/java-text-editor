package main.java.com.kacperpackage.menus;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.handlers.FileMenuExecutor;

import javax.swing.*;

public class FileMenu {
    private JMenu fileMenu;
    private FileMenuExecutor fileMenuExecutor;

    public FileMenu(TextEditorGUI textEditorGUI) {
        fileMenu = new JMenu("File");
        fileMenuExecutor = new FileMenuExecutor(textEditorGUI, fileMenu);
        addFileMenuItems();
    }

    public JMenu getFileMenu() {
        return fileMenu;
    }

    private void addFileMenuItems() {
        // "new file" functionality
        fileMenuExecutor.newFile();
        // "open file" functionality
        fileMenuExecutor.openFile();
        // "save" functionality
        fileMenuExecutor.saveFile();
        // "save as" functionality
        fileMenuExecutor.saveAsFile();
        // "exit" functionality
        fileMenuExecutor.exitFile();
    }
}
