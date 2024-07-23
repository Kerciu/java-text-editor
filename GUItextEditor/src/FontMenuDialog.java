import javax.swing.*;
import java.awt.*;

public class FontMenuDialog extends JDialog {
    private TextEditorGUI source;

    public FontMenuDialog(TextEditorGUI source) {
        setTitle("Font Settings");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(425, 350);
        setLocationRelativeTo(source);
        setModal(true);

        setLayout(null);

        addMenuComponents();
    }

    private void addMenuComponents() {
        addFontChooser();
    }

    private void addFontChooser() {
        JLabel fontLabel = new JLabel("Font");
        fontLabel.setBounds(10, 5, 125, 10);
        add(fontLabel);

        // display current font and fonts available
        JPanel fontPanel = new JPanel();
        fontPanel.setBounds(10, 15, 125, 168);

        // display current font
        JTextField currentFontField = new JTextField(source.getTextArea().getFont().getFontName());
        currentFontField.setPreferredSize(new Dimension(125, 125));
        currentFontField.setEditable(false);
        fontPanel.add(currentFontField);

        add(fontPanel);
    }
}
