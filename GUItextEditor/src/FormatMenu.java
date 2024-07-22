import javax.swing.*;

public class FormatMenu {
    private TextEditorGUI textEditorGUI;
    private JMenu formatMenu;

    FormatMenu(TextEditorGUI textEditorGUI) {
        this.textEditorGUI = textEditorGUI;
        formatMenu = new JMenu("Format");
    }

    public JMenu getFormatMenu() {
        return formatMenu;
    }
}
