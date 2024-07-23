import javax.swing.*;

public class FormatMenuExecuter {
    private TextEditorGUI textEditorGUI;
    private JMenu formatMenu;
    private JTextArea textArea;

    FormatMenuExecuter(TextEditorGUI textEditorGUI, JMenu formatMenu, JTextArea textArea) {
        this.textEditorGUI = textEditorGUI;
        this.formatMenu = formatMenu;
        this.textArea = textArea;
    }

    public void addTextWrapCheckBox() {
        new TextWrap(formatMenu, textArea);
    }

    public void addTextAlignMenu() {
        new TextAlignMenu(formatMenu, textArea);
    }

    public void addFontMenu() {
        new FontMenu(textEditorGUI, formatMenu, textArea);
    }
}
