import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileMenuOpener {
    private TextEditorGUI textEditorGUI;
    private JFileChooser fileChooser;
    private JTextArea textArea;
    private JMenu fileMenu;
    private File workingFile;

    FileMenuOpener(TextEditorGUI textEditorGUI, JFileChooser fileChooser, JTextArea textArea, JMenu fileMenu, File workingFile) {
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

    public void exitFile() {
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);
    }
}
