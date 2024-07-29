package main.java.com.kacperpackage.Items.FormatItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextWrap {
    private final TextEditorGUI textEditorGUI;
    private final JMenu formatMenu;
    JCheckBoxMenuItem textWrapCheckBox;

    public TextWrap(TextEditorGUI textEditorGUI, JMenu formatMenu) {
        this.textEditorGUI = textEditorGUI;
        this.formatMenu = formatMenu;

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
                    textEditorGUI.getTextArea().setLineWrap(true);
                    textEditorGUI.getTextArea().setWrapStyleWord(true);
                }
                else {
                    // unwrap words
                    textEditorGUI.getTextArea().setLineWrap(false);
                    textEditorGUI.getTextArea().setWrapStyleWord(false);
                }
            }
        });

        formatMenu.add(textWrapCheckBox);
    }
}
