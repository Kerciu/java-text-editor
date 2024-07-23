import javax.swing.*;

public class TextAlignMenu {
    private JMenu formatMenu;
    private JTextArea textArea;
    private JMenu textAlignMenu;

    TextAlignMenu(JMenu formatMenu, JTextArea textArea) {
        this.formatMenu = formatMenu;
        this.textArea = textArea;
        textAlignMenu = new JMenu("Text Align");

        addTextAlignMenuItems();
    }

    public JMenu getTextAlignMenu() {
        return textAlignMenu;
    }

    private void addTextAlignMenuItems() {
        new TextAlignMenuItem("Left", this, textArea);
        new TextAlignMenuItem("Right", this, textArea);

        formatMenu.add(textAlignMenu);
    }
}
