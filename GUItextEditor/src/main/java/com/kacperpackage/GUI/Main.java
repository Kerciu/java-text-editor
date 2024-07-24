package main.java.com.kacperpackage;

import javax.swing.*;
import main.java.com.kacperpackage.GUI.TextEditorGUI;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            /* used to make GUI more thread safe */
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
                    new TextEditorGUI().setVisible(true);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}