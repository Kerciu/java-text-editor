package main.java.com.kacperpackage.Handlers.Executors;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.Items.FileItems.ExitActionPerformer;
import main.java.com.kacperpackage.Items.FileItems.NewFileActionPerformer;
import main.java.com.kacperpackage.Items.FileItems.OpenFileActionPerformer;
import main.java.com.kacperpackage.Items.FileItems.SaveFileActionPerformer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FileMenuExecutor implements Executor{
    private TextEditorGUI textEditorGUI;
    private JMenu fileMenu;
    private File workingFile;

    public FileMenuExecutor(TextEditorGUI textEditorGUI, JMenu fileMenu) {
        this.textEditorGUI = textEditorGUI;
        this.fileMenu = fileMenu;
        this.workingFile = null;
    }

    @Override
    public void addMenuItems() {
        new NewFileActionPerformer(textEditorGUI, fileMenu, workingFile);
        new OpenFileActionPerformer(textEditorGUI, fileMenu, workingFile);
        new SaveFileActionPerformer(textEditorGUI, fileMenu, workingFile);
        new ExitActionPerformer();
    }

    public File getWorkingFile() {
        return workingFile;
    }

    public void setWorkingFile(File workingFile) {
        this.workingFile = workingFile;
    }
}
