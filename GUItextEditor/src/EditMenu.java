import javax.swing.*;

public class EditMenu {
    private TextEditorGUI textEditorGUI;
    private JTextArea textArea;
    private JMenu editMenu;

    EditMenu(TextEditorGUI textEditorGUI, JTextArea textArea) {
        this.textEditorGUI = textEditorGUI;
        this.textArea = textArea;
        editMenu = new JMenu("Edit");
    }

    public JMenu getEditMenu() {
        return editMenu;
    }
}
