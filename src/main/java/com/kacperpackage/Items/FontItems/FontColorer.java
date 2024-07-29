package main.java.com.kacperpackage.Items.FontItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontColorer {
    private final TextEditorGUI textEditorGUI;
    private final FontMenuDialog fontMenuDialog;
    private JPanel currentColorBox;

    public FontColorer(TextEditorGUI textEditorGUI, FontMenuDialog fontMenuDialog) {
        this.textEditorGUI = textEditorGUI;
        this.fontMenuDialog = fontMenuDialog;
        initializeFontSizeComponents();
    }

    public JPanel getCurrentColorBox() {
        return currentColorBox;
    }

    private void initializeFontSizeComponents() {
        currentColorBox = createCurrentColorBox();
        fontMenuDialog.add(currentColorBox);

        JButton chooseColorButton = createChooseColorButton();
        fontMenuDialog.add(chooseColorButton);
    }

    private JPanel createCurrentColorBox() {
        JPanel newCurrentColorBox = new JPanel();
        newCurrentColorBox.setBounds(175, 200, 23, 23);
        newCurrentColorBox.setBackground(textEditorGUI.getTextArea().getForeground());
        newCurrentColorBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return newCurrentColorBox;
    }

    private JButton createChooseColorButton() {
        JButton chooseColorButton = new JButton("Choose Color");
        chooseColorButton.setBounds(10, 200, 150, 25);
        chooseColorButton.addActionListener(
                createActionListener()
        );
        return chooseColorButton;
    }

    private ActionListener createActionListener() {
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
