import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditMenu {
    private TextEditorGUI textEditorGUI;
    private JTextArea textArea;
    private JMenu editMenu;

    // manage undo and redo
    private UndoManager undoManager;

    EditMenu(TextEditorGUI textEditorGUI, JTextArea textArea) {
        this.textEditorGUI = textEditorGUI;
        this.textArea = textArea;
        this.undoManager = new UndoManager();
        editMenu = new JMenu("Edit");

        addEditListener();
        addUndoRedoOptions();
    }

    public JMenu getEditMenu() {
        return editMenu;
    }

    private void addUndoRedoOptions() {
        undo();
        redo();
    }

    public void undo() {
        JMenuItem undoMenuItem = new JMenuItem("Undo");
        undoMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // if there are any edits undo them
                if(undoManager.canUndo()) {
                    undoManager.undo();
                }
            }
        });
        editMenu.add(undoMenuItem);
    }

    public void redo() {
        JMenuItem redoMenuItem = new JMenuItem("Redo");
        redoMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (undoManager.canRedo()) {
                    undoManager.redo();
                }
            }
        });
        editMenu.add(redoMenuItem);
    }

    public void addEditListener() {
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });
    }
}
