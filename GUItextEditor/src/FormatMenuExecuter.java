import javax.swing.*;

public class FormatMenuExecuter {
    private JMenu formatMenu;
    private JTextArea textArea;

    FormatMenuExecuter(JMenu formatMenu, JTextArea textArea) {
        this.formatMenu = formatMenu;
        this.textArea = textArea;
    }

    public void addTextWrapCheckBox() {
        TextWrap textWrap = new TextWrap(formatMenu, textArea);
    }

    public void addTextAlignMenu() {
        JMenu textAlignMenu = new JMenu("Text Align");
        formatMenu.add(textAlignMenu);
    }

    public void addFontMenu() {
        JMenu fontMenu = new JMenu("Font");
        formatMenu.add(fontMenu);
    }
}
