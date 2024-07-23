import javax.swing.*;

public class FormatMenuExecuter {
    private JMenu formatMenu;
    private JTextArea textArea;

    FormatMenuExecuter(JMenu formatMenu, JTextArea textArea) {
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
        JMenu fontMenu = new JMenu("Font");
        formatMenu.add(fontMenu);
    }
}
