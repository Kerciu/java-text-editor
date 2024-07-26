package main.java.com.kacperpackage.Handlers.Executors;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.Menus.Edit.EditMenu;
import main.java.com.kacperpackage.Menus.Edit.TextFindMenu;
import main.java.com.kacperpackage.Menus.Edit.TextReplaceMenu;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditMenuExecutor implements Executor{
    private TextEditorGUI textEditorGUI;
    private EditMenu editMenu;

    // manage undo and redo
    private UndoManager undoManager;

    public EditMenuExecutor(TextEditorGUI textEditorGUI, EditMenu editMenu) {
        this.textEditorGUI = textEditorGUI;
        this.editMenu = editMenu;
        undoManager = new UndoManager();
        addEditListener();
    }

    @Override
    public void addMenuItems() {
        editMenu.getEditMenu().add(createUndoMenuItem());
        editMenu.getEditMenu().add(createRedoMenuItem());
        addFindMenuItem();
        addReplaceMenuItem();

    }

    public JMenuItem createUndoMenuItem() {
        JMenuItem undoMenuItem = new JMenuItem("Undo");
        undoMenuItem.addActionListener(
                createUndoActionListener()
        );
        return undoMenuItem;
    }

    public JMenuItem createRedoMenuItem() {
        JMenuItem redoMenuItem = new JMenuItem("Redo");
        redoMenuItem.addActionListener(
                createRedoActionListener()
        );
        return redoMenuItem;
    }

    public void addFindMenuItem() {
        new TextFindMenu(textEditorGUI, editMenu.getEditMenu());
    }

    public void addReplaceMenuItem() {
        new TextReplaceMenu(textEditorGUI, editMenu.getEditMenu());
    }

    public ActionListener createUndoActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // if there are any edits undo them
                if(undoManager.canUndo()) {
                    undoManager.undo();
                }
            }
        };
    }

    public ActionListener createRedoActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (undoManager.canRedo()) {
                    undoManager.redo();
                }
            }
        };
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
