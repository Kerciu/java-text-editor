import javax.swing.*;

public class FormatMenu {
    private TextEditorGUI textEditorGUI;
    private JMenu formatMenu;
    private FormatMenuExecuter formatMenuExecuter;

    FormatMenu(TextEditorGUI textEditorGUI) {
        this.textEditorGUI = textEditorGUI;
        formatMenu = new JMenu("Format");
        formatMenuExecuter = new FormatMenuExecuter(formatMenu);

        addFormatMenuItems();
    }

    public JMenu getFormatMenu() {
        return formatMenu;
    }

    private void addFormatMenuItems() {
        formatMenuExecuter.addTextWrapCheckBox();
    }
}

