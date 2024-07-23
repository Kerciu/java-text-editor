import javax.swing.*;

public class FontMenuDialog extends JDialog {
    private TextEditorGUI source;

    public FontMenuDialog(TextEditorGUI source) {
        setTitle("Font Settings");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(425, 350);
        setLocationRelativeTo(source);

        setLayout(null);
    }
}
