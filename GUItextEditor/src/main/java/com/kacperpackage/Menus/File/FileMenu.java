package main.java.com.kacperpackage.Menus.File;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.Handlers.Executors.FileMenuExecutor;

import javax.swing.*;

public class FileMenu {
    private TextEditorGUI textEditorGUI;
    private JMenu fileMenu;

    public FileMenu(TextEditorGUI textEditorGUI) {
        this.textEditorGUI = textEditorGUI;
        fileMenu = new JMenu("File");
        addFileMenuItems();
    }

    public JMenu getFileMenu() {
        return fileMenu;
    }

    private void addFileMenuItems() {
        new FileMenuExecutor(textEditorGUI, fileMenu);
    }
}
