import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditMenuExecuter {
    private EditMenu editMenu;
    private UndoManager undoManager;

    EditMenuExecuter(EditMenu editMenu, UndoManager undoManager) {
        this.editMenu = editMenu;
        this.undoManager = undoManager;
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
        editMenu.getEditMenu().add(undoMenuItem);
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
        editMenu.getEditMenu().add(redoMenuItem);
    }
}
