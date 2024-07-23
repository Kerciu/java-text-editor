import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontMenu {
    private TextEditorGUI textEditorGUI;
    private JMenu formatMenu;
    private JMenu fontMenu;

    FontMenu(TextEditorGUI textEditorGUI, JMenu formatMenu) {
        this.textEditorGUI = textEditorGUI;
        this.formatMenu = formatMenu;
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
