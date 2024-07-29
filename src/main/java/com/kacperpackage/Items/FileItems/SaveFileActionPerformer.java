package main.java.com.kacperpackage.Items.FileItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class SaveFileActionPerformer extends ActionPerformer{
    private File workingFile;

    public SaveFileActionPerformer(TextEditorGUI textEditorGUI, JMenu fileMenu, File workingFile) {
        super(textEditorGUI, fileMenu);
        this.workingFile = workingFile;

        addItems();
    }

    @Override
    public void addItems() {
        fileMenu.add(createSaveFileMenuItem());
        fileMenu.add(createSaveAsFileMenuItem());
    }

    private JMenuItem createSaveFileMenuItem() {
        JMenuItem saveMenuItem = new JMenuItem("Save");
        addSaveFileFunctionality(saveMenuItem);
        return saveMenuItem;
    }

    private JMenuItem createSaveAsFileMenuItem() {
        JMenuItem saveAsMenuItem = new JMenuItem("Save As");
        addSaveAsFileFunctionality(saveAsMenuItem);
        return saveAsMenuItem;
    }

    private void addSaveFileFunctionality(JMenuItem saveMenuItem) {
        saveMenuItem.addActionListener(
            createSaveFileActionListener()
        );
    }

    private void addSaveAsFileFunctionality(JMenuItem saveAsMenuItem) {
        saveAsMenuItem.addActionListener(
            createSaveAsFileActionListener()
        );
    }

    private ActionListener createSaveFileActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performSaveFileAction();
            }
        };
    }

    private void performSaveFileAction() {
        // if workingFile == null perform saveAs functinality
        if (workingFile == null) {
            performSaveAsFileAction();
            return;
        }

        try {
            // write to working file
            FileWriter fileWriter = new FileWriter(workingFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(textEditorGUI.getTextArea().getText());
            bufferedWriter.close();
            fileWriter.close();

        } catch(Exception e1) {
            e1.printStackTrace();
        }
    }

    private ActionListener createSaveAsFileActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performSaveAsFileAction();
            }
        };
    }

    private void performSaveAsFileAction() {
        int result = textEditorGUI.getFileChooser().showSaveDialog(textEditorGUI);
        // execute code only if user pressed save button
        if (result != JFileChooser.APPROVE_OPTION) return;
        try {
            // if no txt extension, we need to append it into file
            File selectedFile = textEditorGUI.getFileChooser().getSelectedFile();
            String fileName = selectedFile.getName();
            Boolean isTxtExtension = (fileName.substring(fileName.length() - 4).equalsIgnoreCase(".txt"));

            if (!isTxtExtension) {
                selectedFile = new File(selectedFile.getAbsoluteFile() + ".txt");
            }


            // create new file
            selectedFile.createNewFile();

            // supply file with user-typed contents
            FileWriter fileWriter = new FileWriter(selectedFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(textEditorGUI.getTextArea().getText());

            bufferedWriter.close();
            fileWriter.close();

            // update title header of gui to the saved text file
            textEditorGUI.setTitle(fileName);

            // update working file
            workingFile = selectedFile;

            // show message dialog
            JOptionPane.showMessageDialog(textEditorGUI, "Successfully saved file as "+fileName);

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
