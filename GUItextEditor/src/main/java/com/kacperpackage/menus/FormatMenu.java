package main.java.com.kacperpackage.menus;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.handlers.FormatMenuExecuter;

import javax.swing.*;

public class FormatMenu {
    private JMenu formatMenu;
    private FormatMenuExecuter formatMenuExecuter;
    public FormatMenu(TextEditorGUI textEditorGUI) {
        formatMenu = new JMenu("Format");
        formatMenuExecuter = new FormatMenuExecuter(textEditorGUI, formatMenu);

        addFormatMenuItems();
    }

    public JMenu getFormatMenu() {
        return formatMenu;
    }

    private void addFormatMenuItems() {
        formatMenuExecuter.addTextWrapCheckBox();
        formatMenuExecuter.addTextAlignMenu();
        formatMenuExecuter.addFontMenu();
    }
}

