package main.java.com.kacperpackage.Items.FileItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;

public abstract class ActionPerformer {
    protected TextEditorGUI textEditorGUI;
    protected JMenu fileMenu;

    public ActionPerformer(TextEditorGUI textEditorGUI, JMenu fileMenu) {
        this.textEditorGUI = textEditorGUI;
        this.fileMenu = fileMenu;
    }

    public abstract void addItems();
}
