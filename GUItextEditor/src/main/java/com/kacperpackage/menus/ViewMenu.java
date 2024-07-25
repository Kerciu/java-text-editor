package main.java.com.kacperpackage.menus;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.handlers.ViewMenuExecutor;

import javax.swing.*;

public class ViewMenu {
    private TextEditorGUI textEditorGUI;
    private JMenu viewMenu;
    private ViewMenuExecutor viewMenuExecutor;

    public ViewMenu(TextEditorGUI textEditorGUI) {
        this.textEditorGUI = textEditorGUI;
        viewMenu = new JMenu("View");
        viewMenuExecutor = new ViewMenuExecutor(textEditorGUI, viewMenu);

        addViewMenuItems();
    }

    public JMenu getViewMenu() {
        return viewMenu;
    }

    private void addViewMenuItems() {
        viewMenuExecutor.addMenuItems();
    }
}