import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FileMenuExecuter {
    private TextEditorGUI textEditorGUI;
    private JFileChooser fileChooser;
    private JTextArea textArea;
    private JMenu fileMenu;
    private File workingFile;

    FileMenuExecuter(TextEditorGUI textEditorGUI, JFileChooser fileChooser, JTextArea textArea, JMenu fileMenu, File workingFile) {
        this.textEditorGUI = textEditorGUI;
        this.fileChooser = fileChooser;
        this.textArea = textArea;
        this.fileMenu = fileMenu;
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
                textArea.setText("");
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
                int result = fileChooser.showOpenDialog(textEditorGUI);

                // execute code only if user pressed save button
                if (result != JFileChooser.APPROVE_OPTION) return;
                try {
                    File selectedFile = fileChooser.getSelectedFile();

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
                    textArea.setText(stringBuilder.toString());

                    bufferedReader.close();
                    fileReader.close();

                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public void saveFile() {
        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // if workingFile == null perform saveAs functinality
                if (workingFile == null) saveMenuItem.doClick();
                if (workingFile == null) return;

                try {
                    // write to working file
                    FileWriter fileWriter = new FileWriter(workingFile);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(textArea.getText());
                    bufferedWriter.close();
                    fileWriter.close();

                } catch(Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        fileMenu.add(saveMenuItem);
    }

    public void saveAsFile() {
        JMenuItem saveAsMenuItem = new JMenuItem("Save As");
        fileMenu.add(saveAsMenuItem);

        saveAsMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result = fileChooser.showSaveDialog(textEditorGUI);
                // execute code only if user pressed save button
                if (result != JFileChooser.APPROVE_OPTION) return;
                try {
                    // if no txt extension, we need to append it into file
                    File selectedFile = fileChooser.getSelectedFile();
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
                    bufferedWriter.write(textArea.getText());

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
