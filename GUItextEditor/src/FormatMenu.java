import javax.swing.*;

public class FormatMenu {
    private JMenu formatMenu;
    private FormatMenuExecuter formatMenuExecuter;
    FormatMenu(TextEditorGUI textEditorGUI) {
        formatMenu = new JMenu("Format");
        formatMenuExecuter = new FormatMenuExecuter(textEditorGUI, formatMenu);

        addFormatMenuItems();
    }

    public JMenu getFormatMenu() {
        return formatMenu;
    }

    private void addFormatMenuItems() {

        formatMenuExecuter.addTextWrapCheckBox();
        formatMenuExecuter.addTextAlignMenu();
        formatMenuExecuter.addFontMenu();
    }
}

