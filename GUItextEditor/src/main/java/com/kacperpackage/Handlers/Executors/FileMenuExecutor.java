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

    public void newFile() {
        JMenuItem newMenuItem = new JMenuItem("New");

        // "new" resets everything
        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // set header title
                textEditorGUI.setTitle("Text Editor");
                // set text area
                textEditorGUI.getTextArea().setText("");
                // reset working file
                workingFile = null;
            }
        });

        fileMenu.add(newMenuItem);
    }

    public void openFile() {
        JMenuItem openMenuItem = new JMenuItem("Open");
        fileMenu.add(openMenuItem);

        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = textEditorGUI.getFileChooser().showOpenDialog(textEditorGUI);

                // execute code only if user pressed save button
                if (result != JFileChooser.APPROVE_OPTION) return;
                try {
                    File selectedFile = textEditorGUI.getFileChooser().getSelectedFile();

                    // update working file
                    workingFile = selectedFile;

                    textEditorGUI.setTitle(selectedFile.getName());

                    // read the file
                    FileReader fileReader = new FileReader(selectedFile);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    // store the text in a text area
                    StringBuilder stringBuilder = new StringBuilder();
                    String readText;
                    while ((readText = bufferedReader.readLine()) != null) {
                        // checks if there are lines to read in a text file
                        stringBuilder.append(readText + "\n");
                    }

                    // update gui text area
                    textEditorGUI.getTextArea().setText(stringBuilder.toString());

                    bufferedReader.close();
                    fileReader.close();

                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public void exitFile() {
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // dispose of gui
                textEditorGUI.dispose();
            }
        });

        fileMenu.add(exitMenuItem);
    }
}
