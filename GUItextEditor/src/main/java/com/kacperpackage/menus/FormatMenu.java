package main.java.com.kacperpackage.menus;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.handlers.FormatMenuExecutor;

import javax.swing.*;

public class FormatMenu {
    private JMenu formatMenu;
    private FormatMenuExecutor formatMenuExecutor;

    public FormatMenu(TextEditorGUI textEditorGUI) {
        formatMenu = new JMenu("Format");
        formatMenuExecutor = new FormatMenuExecutor(textEditorGUI, formatMenu);

        addFormatMenuItems();
    }

    public JMenu getFormatMenu() {
        return formatMenu;
    }

    private void addFormatMenuItems() {
        formatMenuExecutor.addMenuItems();
    }
}

