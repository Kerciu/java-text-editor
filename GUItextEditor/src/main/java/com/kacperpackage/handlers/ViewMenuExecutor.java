package main.java.com.kacperpackage.handlers;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.menus.ZoomMenu;

import javax.swing.*;

public class ViewMenuExecutor {
    private TextEditorGUI textEditorGUI;
    private JMenu viewMenu;

    public ViewMenuExecutor(TextEditorGUI textEditorGUI, JMenu viewMenu) {
        this.textEditorGUI = textEditorGUI;
        this.viewMenu = viewMenu;
    }

    public void addViewMenuItems() {
        addZoomMenu();
    }

    private void addZoomMenu() {
        new ZoomMenu(textEditorGUI, viewMenu);
    }
}
