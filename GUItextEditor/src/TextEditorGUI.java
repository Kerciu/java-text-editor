import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.concurrent.ExecutionException;

public class TextEditorGUI extends JFrame {
    // file explorer
    private JFileChooser fileChooser;
    private JTextArea textArea;

    public TextEditorGUI() {
        super("Text Editor");
        setSize(480, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // fileChooser set up
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("GUItextEditor/src/assets"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));

        addGuiComponents();
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JFileChooser getFileChooser() {
        return fileChooser;
    }

    private void addGuiComponents() {
        addTextArea();
        addToolBar();
    }

    private void addToolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);

        // ADD MENU BAR
        JMenuBar menuBar = new JMenuBar();
        toolBar.add(menuBar);

        // ADD MENUS
        new MenuBarHandler(this, menuBar);

        add(toolBar, BorderLayout.NORTH);
    }

    private void addTextArea() {
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }
}
