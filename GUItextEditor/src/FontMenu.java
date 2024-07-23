import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontMenu {
    private JMenu formatMenu;
    private JTextArea textArea;
    private JMenu fontMenu;
    private TextEditorGUI textEditorGUI;

    FontMenu(TextEditorGUI textEditorGUI, JMenu formatMenu, JTextArea textArea) {
        this.textEditorGUI = textEditorGUI;
        this.formatMenu = formatMenu;
        this.textArea = textArea;
        fontMenu = new JMenu("Font");

        addFontMenuItems();
    }

    public JMenu getFontMenu() {
        return fontMenu;
    }

    private void addFontMenuItems() {
        JMenuItem fontMenuItem = new JMenuItem("Font...");
        fontMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // launch font menu
                new FontMenuDialog(textEditorGUI).setVisible(true);

            }
        });
        fontMenu.add(fontMenuItem);
        formatMenu.add(fontMenu);
    }
}
