package main.java.com.kacperpackage.menus;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.handlers.EditMenuExecuter;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class EditMenu {
    private TextEditorGUI textEditorGUI;
    private JMenu editMenu;

    // manage undo and redo
    private UndoManager undoManager;

    private EditMenuExecuter editMenuExecuter;

    public EditMenu(TextEditorGUI textEditorGUI) {
        this.textEditorGUI = textEditorGUI;
        this.undoManager = new UndoManager();
        editMenu = new JMenu("Edit");
        editMenuExecuter = new EditMenuExecuter(this, undoManager);

        addEditListener();
        addUndoRedoOptions();
    }

    public JMenu getEditMenu() {
        return editMenu;
    }

    private void addUndoRedoOptions() {
        editMenuExecuter.undo();
        editMenuExecuter.redo();
    }

    public void addEditListener() {
        textEditorGUI.getTextArea().getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });
    }
}