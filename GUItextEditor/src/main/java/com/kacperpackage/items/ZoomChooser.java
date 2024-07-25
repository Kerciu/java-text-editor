package main.java.com.kacperpackage.items;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZoomChooser {
    private JMenu zoomMenu;

    public ZoomChooser(JMenu zoomMenu) {
        this.zoomMenu = zoomMenu;
    }

    private void addZoomChooserItems() {
        zoomMenu.add(createZoomInItem());
        zoomMenu.add(createZoomOutItem());
        zoomMenu.add(createZoomRestoreItem());
    }

    private JMenuItem createZoomInItem() {
        return new JMenuItem("Zoom In");
    }

    private JMenuItem createZoomOutItem() {
        return new JMenuItem("Zoom Out");
    }

    private JMenuItem createZoomRestoreItem() {
        return new JMenuItem("Zoom Restore Default");
    }

    private void addZoomItemFunctionality(JMenuItem zoomMenuItem) {
        zoomMenuItem.addActionListener(
                createAppropriateActionListener(zoomMenuItem)
        );
    }

    private ActionListener createAppropriateActionListener(JMenuItem zoomMenuItem) {
        return switch (zoomMenuItem.getText()) {
            case "Zoom In" -> createZoomInActionListener(zoomMenuItem);
            case "Zoom Out" -> createZoomOutActionListener(zoomMenuItem);
            default -> createZoomRestoreActionListener(zoomMenuItem);
        };
    }

    private ActionListener createZoomInActionListener(JMenuItem zoomInMenuItem) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
    }

    private ActionListener createZoomOutActionListener(JMenuItem zoomOutMenuItem) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
    }

    private ActionListener createZoomRestoreActionListener(JMenuItem zoomRestoreMenuItem) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
    }
}
