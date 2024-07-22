import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FileMenu {
    private TextEditorGUI textEditorGUI;
    private JTextArea textArea;
    private JFileChooser fileChooser;
    private JMenu fileMenu;
    private FileMenuOpener fileMenuOpener;
    private FileMenuSaver fileMenuSaver;
    private File workingFile;

    FileMenu(TextEditorGUI textEditorGUI, JTextArea textArea, JFileChooser fileChooser) {
        this.textEditorGUI = textEditorGUI;
        this.textArea = textArea;
        this.fileChooser = fileChooser;
        fileMenu = new JMenu("File");
        fileMenuOpener = new FileMenuOpener(textEditorGUI, fileChooser, textArea, fileMenu, workingFile);
        fileMenuSaver = new FileMenuSaver(textEditorGUI, fileChooser, textArea, fileMenu, workingFile);
        addFileMenuItems();
    }

    public JMenu getFileMenu() {
        return fileMenu;
    }

    private void addFileMenuItems() {
        // "new file" functionality
        fileMenuOpener.newFile();
        // "open file" functionality
        fileMenuOpener.openFile();
        // "save" functionality
        fileMenuSaver.saveFile();
        // "save as" functionality
        fileMenuSaver.saveAsFile();
        // "exit" functionality
        fileMenuOpener.exitFile();
    }
}
