import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class FileMenuSaver {
    private TextEditorGUI textEditorGUI;
    private JFileChooser fileChooser;
    private JTextArea textArea;
    private JMenu fileMenu;

    FileMenuSaver(TextEditorGUI textEditorGUI, JFileChooser fileChooser, JTextArea textArea, JMenu fileMenu) {
        this.textEditorGUI = textEditorGUI;
        this.fileChooser = fileChooser;
        this.textArea = textArea;
        this.fileMenu = fileMenu;
    }

    public void saveFile() {
        JMenuItem saveMenuItem = new JMenuItem("Save");
        fileMenu.add(saveMenuItem);
    }

    public void saveAsFile() {
        JMenuItem saveAsMenuItem = new JMenuItem("Save As");
        fileMenu.add(saveAsMenuItem);

        saveAsMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                fileChooser.showSaveDialog(textEditorGUI);

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

                    // show message dialog
                    JOptionPane.showMessageDialog(textEditorGUI, "Successfully saved file as "+fileName);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
