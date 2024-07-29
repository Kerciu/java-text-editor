package main.java.com.kacperpackage.Menus.View;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.Items.ViewItems.StyleChooser;
import main.java.com.kacperpackage.Items.ViewItems.ZoomChooser;

import javax.swing.*;

public class StyleMenu {
    private TextEditorGUI textEditorGUI;
    private JMenu styleMenu;
    private JMenu viewMenu;

    public StyleMenu(TextEditorGUI textEditorGUI, JMenu viewMenu) {
        this.textEditorGUI = textEditorGUI;
        this.styleMenu = new JMenu("Style");
        this.viewMenu = viewMenu;

        new StyleChooser(textEditorGUI, styleMenu);

        initializeStyleMenu();
    }

    private void initializeStyleMenu() {
        viewMenu.add(styleMenu);
    }
}
