import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
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
        fileChooser.setCurrentDirectory(new File("src/assets"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));

        addGuiComponents();
    }

    private void addGuiComponents() {
        addToolBar();
        addTextArea();
    }

    private void addToolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);

        // ADD MENU BAR
        JMenuBar menuBar = new JMenuBar();
        toolBar.add(menuBar);

        // ADD MENUS
        menuBar.add(addFileMenu());

        add(toolBar, BorderLayout.NORTH);
    }

    private JMenu addFileMenu() {
        JMenu fileMenu = new JMenu("File");

        // "new file" functionality
        executeNewFunctionality(fileMenu);

        // "open file" functionality
        executeOpenFunctionality(fileMenu);

        // "save" functionality
        executeSaveFunctionality(fileMenu);

        // "save as" functionality
        executeSaveAsFunctionality(fileMenu);

        // "exit" functionality
        executeExitFunctionality(fileMenu);

        return fileMenu;
    }

    private void addTextArea() {
        textArea = new JTextArea();
        add(textArea, BorderLayout.CENTER);
    }

    private void executeNewFunctionality(JMenu fileMenu) {
        JMenuItem newMenuItem = new JMenuItem("New");


        // "new" resets everything
        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // set header title
                setTitle("Text Editor");
                // set text area
                textArea.setText("");
            }
        });

        fileMenu.add(newMenuItem);
    }

    private void executeOpenFunctionality(JMenu fileMenu) {
        JMenuItem openMenuItem = new JMenuItem("Open");
        fileMenu.add(openMenuItem);

        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.showOpenDialog(TextEditorGUI.this);
                try {
                    File selectedFile = fileChooser.getSelectedFile();
                    setTitle(selectedFile.getName());

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

                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    private void executeSaveFunctionality(JMenu fileMenu) {
        JMenuItem saveMenuItem = new JMenuItem("Save");
        fileMenu.add(saveMenuItem);
    }

    private void executeSaveAsFunctionality(JMenu fileMenu) {
        JMenuItem saveAsMenuItem = new JMenuItem("Save As");
        fileMenu.add(saveAsMenuItem);

        saveAsMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                fileChooser.showSaveDialog(TextEditorGUI.this);

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
                    setTitle(fileName);

                    // show message dialog
                    JOptionPane.showMessageDialog(TextEditorGUI.this, "Successfully saved file as "+fileName);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void executeExitFunctionality(JMenu fileMenu) {
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);
    }

}
