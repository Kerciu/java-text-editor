package main.java.com.kacperpackage.Menus.View;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.Items.ViewItems.ZoomChooser;

import javax.swing.*;

public class ZoomMenu {
    private final TextEditorGUI textEditorGUI;
    private final JMenu viewMenu;
    private final JMenu zoomMenu;
    private final ZoomChooser zoomChooser;

    public ZoomMenu(TextEditorGUI textEditorGUI, JMenu viewMenu) {
        this.textEditorGUI = textEditorGUI;
        this.zoomMenu = new JMenu("Zoom");
        this.zoomChooser = new ZoomChooser(textEditorGUI, zoomMenu);
        this.viewMenu = viewMenu;

        initializeZoomMenu();
    }

    public JMenu getZoomMenu() {
        return zoomMenu;
    }

    private void initializeZoomMenu() {
        viewMenu.add(zoomMenu);
    }
}
