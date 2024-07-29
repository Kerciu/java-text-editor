package main.java.com.kacperpackage.Items.ViewItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import java.awt.*;

public class StyleModeSwitcher {
    private enum ModeToSwitch {
        DARK_MODE, LIGHT_MODE
    };

    public static void switchToDarkMode(TextEditorGUI textEditorGUI) {
        setModeRecursively(textEditorGUI.getContentPane(), ModeToSwitch.DARK_MODE);
        updateTextEditor(textEditorGUI);
    }

    public static void switchToLightMode(TextEditorGUI textEditorGUI) {
        setModeRecursively(textEditorGUI.getContentPane(), ModeToSwitch.LIGHT_MODE);
        updateTextEditor(textEditorGUI);
    }

    private static void updateTextEditor(TextEditorGUI textEditorGUI) {
        textEditorGUI.getContentPane().revalidate();
        textEditorGUI.getContentPane().repaint();
    }

    private static void setModeRecursively(Component component, ModeToSwitch modeToSwitch) {
        changeColorOfContents(component, modeToSwitch);

        if (component instanceof Container) {
            for (Component child : ((Container) component).getComponents()) {
                setModeRecursively(child, modeToSwitch);
            }
        }
    }

    private static void changeColorOfContents(Component component, ModeToSwitch modeToSwitch) {
        switch(modeToSwitch) {
            case DARK_MODE -> changeColorToDarkMode(component);
            case LIGHT_MODE -> changeColorToLightMode(component);
        }
    }

    private static void changeColorToDarkMode(Component component) {
        component.setBackground(Color.DARK_GRAY);
        component.setForeground(Color.WHITE);
    }

    private static void changeColorToLightMode(Component component) {
        component.setBackground(Color.WHITE);
        component.setForeground(Color.BLACK);
    }
}
