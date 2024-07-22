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
}
