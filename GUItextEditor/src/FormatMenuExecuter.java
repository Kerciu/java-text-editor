import javax.swing.*;

public class FormatMenuExecuter {
    private JMenu formatMenu;

    FormatMenuExecuter(JMenu formatMenu) {
        this.formatMenu = formatMenu;
    }

    public void addTextWrapCheckBox() {
        JCheckBoxMenuItem textWrapCheckBox = new JCheckBoxMenuItem("Text Wrap");
        formatMenu.add(textWrapCheckBox);
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
