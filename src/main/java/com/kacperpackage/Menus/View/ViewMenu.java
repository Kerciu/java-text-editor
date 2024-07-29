package main.java.com.kacperpackage.Menus.View;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.Handlers.Executors.ViewMenuExecutor;

import javax.swing.*;

public class ViewMenu {
    private final TextEditorGUI textEditorGUI;
    private final JMenu viewMenu;
    private final ViewMenuExecutor viewMenuExecutor;

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