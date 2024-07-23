import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextWrap {
    private JMenu formatMenu;
    private JTextArea textArea;

    TextWrap(JMenu formatMenu, JTextArea textArea) {
        this.formatMenu = formatMenu;
        this.textArea = textArea;
    }

    public void wrapText() {
        JCheckBoxMenuItem textWrapCheckBox = new JCheckBoxMenuItem("Text Wrap");
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
    }
}
