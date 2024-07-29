package main.java.com.kacperpackage.Handlers.MenuBar;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.Menus.Edit.EditMenu;
import main.java.com.kacperpackage.Menus.File.FileMenu;
import main.java.com.kacperpackage.Menus.Format.FormatMenu;
import main.java.com.kacperpackage.Menus.View.ViewMenu;

import javax.swing.*;

public class MenuBarHandler {
    private final TextEditorGUI textEditorGUI;
    private FileMenu fileMenu;
    private EditMenu editMenu;
    private FormatMenu formatMenu;
    private ViewMenu viewMenu;

    public MenuBarHandler(TextEditorGUI textEditorGUI, JMenuBar menuBar) {
        this.textEditorGUI = textEditorGUI;

        addMenuItems(menuBar);
    }

    private void addMenuItems(JMenuBar menuBar) {
        addFileMenu(menuBar);
        addEditMenu(menuBar);
        addFormatMenu(menuBar);
        addViewMenu(menuBar);
    }

    private void addFileMenu(JMenuBar menuBar) {
        fileMenu = new FileMenu(textEditorGUI);
        menuBar.add(fileMenu.getFileMenu());
    }

    private void addEditMenu(JMenuBar menuBar) {
        editMenu = new EditMenu(textEditorGUI);
        menuBar.add(editMenu.getEditMenu());
    }

    private void addFormatMenu(JMenuBar menuBar) {
        formatMenu = new FormatMenu(textEditorGUI);
        menuBar.add(formatMenu.getFormatMenu());
    }

    private void addViewMenu(JMenuBar menuBar) {
        viewMenu = new ViewMenu(textEditorGUI);
        menuBar.add(viewMenu.getViewMenu());
    }
}
