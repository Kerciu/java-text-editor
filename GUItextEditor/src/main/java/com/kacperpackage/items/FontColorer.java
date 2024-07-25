package main.java.com.kacperpackage.items;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;

public class FontColorer {
    private TextEditorGUI textEditorGUI;
    private FontMenuDialog fontMenuDialog;

    public FontColorer(TextEditorGUI textEditorGUI, FontMenuDialog fontMenuDialog) {
        this.textEditorGUI = textEditorGUI;
        this.fontMenuDialog = fontMenuDialog;
        initializeFontSizeComponents();
    }

    private void initializeFontSizeComponents() {
        
    }
}
