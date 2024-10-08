package main.java.com.kacperpackage.MainClass;

import javax.swing.*;
import main.java.com.kacperpackage.GUI.TextEditorGUI;

public class MainClass {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            /* used to make GUI more thread safe */
            @Override
            public void run() {
                try {
                    new TextEditorGUI().setVisible(true);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}