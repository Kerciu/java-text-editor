package main.java.com.kacperpackage.Items.FileItems;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitActionPerformer extends ActionPerformer{
    public void exitFile() {
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // dispose of gui
                textEditorGUI.dispose();
            }
        });

        fileMenu.add(exitMenuItem);
    }

    private void addItems() {
        formatMenu.add();
    }

    private JMenuItem createExitMenuItem() {

    }

    private void addExitMenuItemFunctionality() {

    }

    private ActionListener addExitActionListener() {

    }

    private void performExitFunctionality() {

    }
}
