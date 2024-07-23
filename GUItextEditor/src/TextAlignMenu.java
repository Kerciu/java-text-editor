import javax.swing.*;

public class TextAlignMenu {
    private TextEditorGUI textEditorGUI;
    private JMenu formatMenu;
    private JMenu textAlignMenu;

    TextAlignMenu(TextEditorGUI textEditorGUI, JMenu formatMenu) {
        this.textEditorGUI = textEditorGUI;
        this.formatMenu = formatMenu;
        textAlignMenu = new JMenu("Text Align");

        addTextAlignMenuItems();
    }

    public JMenu getTextAlignMenu() {
        return textAlignMenu;
    }

    private void addTextAlignMenuItems() {
        new TextAlignMenuItem("Left", this, textEditorGUI.getTextArea());
        new TextAlignMenuItem("Right", this, textEditorGUI.getTextArea());

        formatMenu.add(textAlignMenu);
    }
}
