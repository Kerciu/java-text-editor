package main.java.com.kacperpackage.Items.FileItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitActionPerformer extends ActionPerformer{
    public ExitActionPerformer(TextEditorGUI textEditorGUI, JMenu fileMenu) {
        super(textEditorGUI, fileMenu);
        addItems();
    }

    @Override
    public void addItems() {
        fileMenu.add(
            createExitMenuItem()
        );
    }

    private JMenuItem createExitMenuItem() {
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        addExitMenuItemFunctionality(exitMenuItem);
        return exitMenuItem;
    }

    private void addExitMenuItemFunctionality(JMenuItem exitMenuItem) {
        exitMenuItem.addActionListener(
                createExitActionListener()
        );
    }

    private ActionListener createExitActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performExitFunctionality();
            }
        };
    }

    private void performExitFunctionality() {
        // dispose of gui
        textEditorGUI.dispose();
    }
}
