import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextWrap {
    private JMenu formatMenu;
    private JTextArea textArea;
    JCheckBoxMenuItem textWrapCheckBox;

    TextWrap(JMenu formatMenu, JTextArea textArea) {
        this.formatMenu = formatMenu;
        this.textArea = textArea;

        wrapText();
    }

    public JCheckBoxMenuItem getWrapper() {
        return textWrapCheckBox;
    }

    private void wrapText() {
        textWrapCheckBox = new JCheckBoxMenuItem("Text Wrap");
        textWrapCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isChecked = textWrapCheckBox.getState();

                if (isChecked) {
                    textArea.setLineWrap(true);
                    textArea.setWrapStyleWord(true);
                }
                else {
                    // unwrap words
                    textArea.setLineWrap(false);
                    textArea.setWrapStyleWord(false);
                }
            }
        });

        formatMenu.add(textWrapCheckBox);
    }
}
