package main.java.com.kacperpackage.Menus.Edit;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.Handlers.Executors.EditMenuExecutor;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class EditMenu {
    private final TextEditorGUI textEditorGUI;
    private final JMenu editMenu;
    private final EditMenuExecutor editMenuExecutor;

    public EditMenu(TextEditorGUI textEditorGUI) {
        this.textEditorGUI = textEditorGUI;
        editMenu = new JMenu("Edit");
        editMenuExecutor = new EditMenuExecutor(textEditorGUI, this);

        addUndoRedoOptions();
    }

    public JMenu getEditMenu() {
        return editMenu;
    }

    private void addUndoRedoOptions() {
        editMenuExecutor.addMenuItems();
    }
}
