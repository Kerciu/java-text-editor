package main.java.com.kacperpackage.Items.ViewItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZoomChooser {
    private final TextEditorGUI textEditorGUI;
    private final JMenu zoomMenu;

    private enum zoomDirection{
        ZOOM_IN, ZOOM_OUT, ZOOM_RESTORE
    }

    private static final int zoomDefaultSize = 12;

    public ZoomChooser(TextEditorGUI textEditorGUI, JMenu zoomMenu) {
        this.textEditorGUI = textEditorGUI;
        this.zoomMenu = zoomMenu;

        addZoomChooserItems();
    }

    private void addZoomChooserItems() {
        zoomMenu.add(createZoomInItem());
        zoomMenu.add(createZoomOutItem());
        zoomMenu.add(createZoomRestoreItem());
    }

    private JMenuItem createZoomInItem() {
        JMenuItem zoomInMenuItem = new JMenuItem("Zoom In");
        addZoomItemFunctionality(zoomInMenuItem);
        return zoomInMenuItem;
    }

    private JMenuItem createZoomOutItem() {
        JMenuItem zoomOutMenuItem = new JMenuItem("Zoom Out");
        addZoomItemFunctionality(zoomOutMenuItem);
        return zoomOutMenuItem;
    }

    private JMenuItem createZoomRestoreItem() {
        JMenuItem zoomRestoreMenuItem = new JMenuItem("Zoom Restore Default");
        addZoomItemFunctionality(zoomRestoreMenuItem);
        return zoomRestoreMenuItem;
    }

    private void addZoomItemFunctionality(JMenuItem zoomMenuItem) {
        zoomMenuItem.addActionListener(
                createAppropriateActionListener(zoomMenuItem)
        );
    }

    private ActionListener createAppropriateActionListener(JMenuItem zoomMenuItem) {
        return switch (zoomMenuItem.getText()) {
            case "Zoom In" -> createZoomInActionListener();
            case "Zoom Out" -> createZoomOutActionListener();
            default -> createZoomRestoreActionListener();
        };
    }

    private ActionListener createZoomInActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNewFontInOrderToZoom(zoomDirection.ZOOM_IN);
            }
        };
    }

    private ActionListener createZoomOutActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNewFontInOrderToZoom(zoomDirection.ZOOM_OUT);
            }
        };
    }

    private ActionListener createZoomRestoreActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNewFontInOrderToZoom(zoomDirection.ZOOM_RESTORE);
            }
        };
    }

    private Font getCurrentFont() {
        return textEditorGUI.getTextArea().getFont();
    }

    private void setNewFontInOrderToZoom(zoomDirection direction) {
        Font currentFont = getCurrentFont();
        JTextArea textArea = textEditorGUI.getTextArea();

        int newSize = switch (direction) {
            case ZOOM_IN -> currentFont.getSize() + 1;
            case ZOOM_OUT -> Math.max(currentFont.getSize() - 1, 1);
            case ZOOM_RESTORE -> zoomDefaultSize;
        };

        textArea.setFont(new Font(currentFont.getName(), currentFont.getStyle(), newSize));
    }
}
