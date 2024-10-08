package main.java.com.kacperpackage.Items.FormatItems;

import main.java.com.kacperpackage.Menus.Format.TextAlignMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAlignMenuItem {
    private final String direction;
    private final TextAlignMenu textAlignMenu;
    private final JTextArea textArea;

    public TextAlignMenuItem(String direction, TextAlignMenu textAlignMenu, JTextArea textArea) {
        if (!direction.equals("Left") && !direction.equals("Right")) {
            throw new RuntimeException("Invalid direction: "+direction);
        }
        this.direction = direction;
        this.textAlignMenu = textAlignMenu;
        this.textArea = textArea;

        executeAccordingToDirection();
    }

    private void executeAccordingToDirection() {
        JMenuItem alignTextMenuItem = new JMenuItem(direction);
        alignTextMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(direction) {
                    case "Left":
                        textArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                        textArea.setAlignmentX(Component.LEFT_ALIGNMENT);
                        break;
                    case "Right":
                        textArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                        textArea.setAlignmentX(Component.RIGHT_ALIGNMENT);
                        break;
                }
            }
        });
        textAlignMenu.getTextAlignMenu().add(alignTextMenuItem);
    }
}
