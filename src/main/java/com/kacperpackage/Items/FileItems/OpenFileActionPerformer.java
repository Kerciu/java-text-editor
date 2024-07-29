package main.java.com.kacperpackage.Items.FileItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class OpenFileActionPerformer extends ActionPerformer{
    private File workingFile;

    public OpenFileActionPerformer(TextEditorGUI textEditorGUI, JMenu fileMenu, File workingFile) {
        super(textEditorGUI, fileMenu);
        this.workingFile = workingFile;

        addItems();
    }

    @Override
    public void addItems() {
        fileMenu.add(createOpenMenuItem());
    }

    private JMenuItem createOpenMenuItem() {
        JMenuItem openMenuItem = new JMenuItem("Open");
        addOpenMenuItemFunctionality(openMenuItem);
        return openMenuItem;
    }

    private void addOpenMenuItemFunctionality(JMenuItem openMenuItem) {
        openMenuItem.addActionListener(
                createOpenActionListener()
        );
    }

    private ActionListener createOpenActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOpenFunctionality();
            }
        };
    }

    private void performOpenFunctionality() {
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

}
