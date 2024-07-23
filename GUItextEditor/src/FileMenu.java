import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FileMenu {
    private JMenu fileMenu;
    private FileMenuExecuter fileMenuExecuter;

    FileMenu(TextEditorGUI textEditorGUI) {
        fileMenu = new JMenu("File");
        fileMenuExecuter = new FileMenuExecuter(textEditorGUI, fileMenu);
        addFileMenuItems();
    }

    public JMenu getFileMenu() {
        return fileMenu;
    }

    private void addFileMenuItems() {
        // "new file" functionality
        fileMenuExecuter.newFile();
        // "open file" functionality
        fileMenuExecuter.openFile();
        // "save" functionality
        fileMenuExecuter.saveFile();
        // "save as" functionality
        fileMenuExecuter.saveAsFile();
        // "exit" functionality
        fileMenuExecuter.exitFile();
    }
}
