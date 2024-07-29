package main.java.com.kacperpackage.Handlers.Executors;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.Menus.View.StyleMenu;
import main.java.com.kacperpackage.Menus.View.ZoomMenu;

import javax.swing.*;

public class ViewMenuExecutor implements Executor{
    private TextEditorGUI textEditorGUI;
    private JMenu viewMenu;

    public ViewMenuExecutor(TextEditorGUI textEditorGUI, JMenu viewMenu) {
        this.textEditorGUI = textEditorGUI;
        this.viewMenu = viewMenu;
    }

    @Override
    public void addMenuItems() {
        addZoomMenu();
        addStyleMenu();
    }

    private void addZoomMenu() {
        new ZoomMenu(textEditorGUI, viewMenu);
    }

    private void addStyleMenu() { new StyleMenu(textEditorGUI, viewMenu); }
}
