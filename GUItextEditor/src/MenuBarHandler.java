import javax.swing.*;

public class MenuBarHandler {
    private TextEditorGUI textEditorGUI;
    private JMenuBar menuBar;
    private FileMenu fileMenu;
    private EditMenu editMenu;
    private FormatMenu formatMenu;

    MenuBarHandler(TextEditorGUI textEditorGUI, JMenuBar menuBar) {
        this.textEditorGUI = textEditorGUI;
        this.menuBar = menuBar;

        addMenuItems(menuBar);
    }

    private void addMenuItems(JMenuBar menuBar) {
        addFileMenu(menuBar);
        addEditMenu(menuBar);
        addFormatMenu(menuBar);
    }

    private void addFileMenu(JMenuBar menuBar) {
        fileMenu = new FileMenu(textEditorGUI);
        menuBar.add(fileMenu.getFileMenu());
    }

    private void addEditMenu(JMenuBar menuBar) {
        editMenu = new EditMenu(textEditorGUI);
        menuBar.add(editMenu.getEditMenu());
    }

    private void addFormatMenu(JMenuBar menuBar) {
        formatMenu = new FormatMenu(textEditorGUI);
        menuBar.add(formatMenu.getFormatMenu());
    }
}
