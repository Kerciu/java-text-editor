import javax.swing.*;

public class FormatMenu {
    private JMenu formatMenu;
    private FormatMenuExecuter formatMenuExecuter;
    private JTextArea textArea;

    FormatMenu(TextEditorGUI textEditorGUI, JTextArea textArea) {
        this.textArea = textArea;
        formatMenu = new JMenu("Format");
        formatMenuExecuter = new FormatMenuExecuter(textEditorGUI, formatMenu, textArea);

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

