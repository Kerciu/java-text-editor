import javax.swing.*;

public class MenuBarHandler {
    private TextEditorGUI textEditorGUI;
    private JTextArea textArea;
    private JFileChooser fileChooser;
    private JMenuBar menuBar;
    private FileMenu fileMenu;
    private EditMenu editMenu;
    private FormatMenu formatMenu;

    MenuBarHandler(TextEditorGUI textEditorGUI, JTextArea textArea, JMenuBar menuBar, JFileChooser fileChooser) {
        this.textEditorGUI = textEditorGUI;
        this.textArea = textArea;
        this.fileChooser = fileChooser;
        this.menuBar = menuBar;

        addMenuItems(menuBar);
    }

    private void addMenuItems(JMenuBar menuBar) {
        addFileMenu(menuBar);
        addEditMenu(menuBar);
        addFormatMenu(menuBar);
    }

    private void addFileMenu(JMenuBar menuBar) {
        fileMenu = new FileMenu(textEditorGUI, textArea, fileChooser);
        menuBar.add(fileMenu.getFileMenu());
    }

    private void addEditMenu(JMenuBar menuBar) {
        editMenu = new EditMenu(textEditorGUI, textArea);
        menuBar.add(editMenu.getEditMenu());
    }

    private void addFormatMenu(JMenuBar menuBar) {
        formatMenu = new FormatMenu(textArea);
        menuBar.add(formatMenu.getFormatMenu());
    }
}
