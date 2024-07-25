package main.java.com.kacperpackage.items;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontColorer {
    private TextEditorGUI textEditorGUI;
    private FontMenuDialog fontMenuDialog;

    public FontColorer(TextEditorGUI textEditorGUI, FontMenuDialog fontMenuDialog) {
        this.textEditorGUI = textEditorGUI;
        this.fontMenuDialog = fontMenuDialog;
        initializeFontSizeComponents();
    }

    private void initializeFontSizeComponents() {
        JPanel currentColorBox = createCurrentColorBox();
        fontMenuDialog.add(currentColorBox);

        JButton chooseColorButton = createChooseColorButton(currentColorBox);
        fontMenuDialog.add(chooseColorButton);
    }

    private JPanel createCurrentColorBox() {
        JPanel currentColorBox = new JPanel();
        currentColorBox.setBounds(175, 200, 23, 23);
        currentColorBox.setBackground(textEditorGUI.getTextArea().getForeground());
        currentColorBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return currentColorBox;
    }

    private JButton createChooseColorButton(JPanel currentColorBox) {
        JButton chooseColorButton = new JButton("Choose Color");
        chooseColorButton.setBounds(10, 200, 150, 25);
        chooseColorButton.addActionListener(
                createActionListener(currentColorBox)
        );
        return chooseColorButton;
    }

    private ActionListener createActionListener(JPanel currentColorBox) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = extractColorFromDialog();
                currentColorBox.setBackground(color);
            }
        };
    }

    private Color extractColorFromDialog() {
        return JColorChooser.showDialog(null, "Select a color", Color.BLACK);
    }

}
