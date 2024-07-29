package main.java.com.kacperpackage.Items.ViewItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StyleChooser {
    private TextEditorGUI textEditorGUI;
    private JMenu styleMenu;

    public StyleChooser(TextEditorGUI textEditorGUI, JMenu styleMenu) {
        this.textEditorGUI = textEditorGUI;
        this.styleMenu = styleMenu;

        addStyleChooserItems();
    }

    private void addStyleChooserItems() {
        styleMenu.add(createDarkModeMenuItem());
        styleMenu.add(createLightModeMenuItem());
    }

    private JMenuItem createDarkModeMenuItem() {
        JMenuItem darkModeMenuItem = new JMenuItem("Dark Mode");
        addMenuItemFunctionality(darkModeMenuItem);
        return darkModeMenuItem;
    }

    private JMenuItem createLightModeMenuItem() {
        JMenuItem darkModeMenuItem = new JMenuItem("Light Mode");
        addMenuItemFunctionality(darkModeMenuItem);
        return darkModeMenuItem;
    }

    private void addMenuItemFunctionality(JMenuItem menuItem) {
        menuItem.addActionListener(createActionListener(menuItem));
    }

    private ActionListener createActionListener(JMenuItem menuItem) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (menuItem.getText()) {
                    case "Dark Mode" -> StyleModeSwitcher.switchToDarkMode(textEditorGUI);
                    case "Light Mode" -> StyleModeSwitcher.switchToLightMode(textEditorGUI);
                }
            }
        };
    }
}
