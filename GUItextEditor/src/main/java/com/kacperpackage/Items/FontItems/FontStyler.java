package main.java.com.kacperpackage.Items.FontItems;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FontStyler {
    private TextEditorGUI textEditorGUI;
    private FontMenuDialog fontMenuDialog;
    private JTextField currentFontStyleField;

    public FontStyler(TextEditorGUI textEditorGUI, FontMenuDialog fontMenuDialog) {
        this.textEditorGUI = textEditorGUI;
        this.fontMenuDialog = fontMenuDialog;
        initializeFontStyleComponents();
    }

    public JTextField getCurrentFontStyleField() {
        return currentFontStyleField;
    }

    private void initializeFontStyleComponents() {
        JLabel fontStyleLabel = createFontStyleLabel();
        fontMenuDialog.add(fontStyleLabel);

        JPanel fontStylePanel = createFontStylePanel();
        fontMenuDialog.add(fontStylePanel);
    }

    private JLabel createFontStyleLabel() {
        JLabel fontStyleLabel = new JLabel("Font Style");
        fontStyleLabel.setBounds(145, 5, 125, 10);
        return fontStyleLabel;
    }

    private JPanel createFontStylePanel() {
        JPanel fontStylePanel = new JPanel();
        fontStylePanel.setBounds(145, 15, 125, 160);

        String currentFontStyleText = getCurrentFontStyleText();
        currentFontStyleField = createCurrentFontStyleField(currentFontStyleText);
        fontStylePanel.add(currentFontStyleField);

        JPanel listOfFontStylesPanel = createFontStylesListPanel();
        JScrollPane scrollPane = createScrollPane(listOfFontStylesPanel);
        fontStylePanel.add(scrollPane);

        return fontStylePanel;
    }

    private JTextField createCurrentFontStyleField(String text) {
        JTextField field = new JTextField(text);
        field.setPreferredSize(new Dimension(125, 25));
        field.setEditable(false);
        return field;
    }

    private JPanel createFontStylesListPanel() {
        JPanel listOfFontStylesPanel = new JPanel();
        listOfFontStylesPanel.setLayout(new BoxLayout(listOfFontStylesPanel, BoxLayout.Y_AXIS));
        listOfFontStylesPanel.setBackground(Color.WHITE);

        addFontStyleToPanel(listOfFontStylesPanel, "Plain", Font.PLAIN);
        addFontStyleToPanel(listOfFontStylesPanel, "Bold", Font.BOLD);
        addFontStyleToPanel(listOfFontStylesPanel, "Italic", Font.ITALIC);
        addFontStyleToPanel(listOfFontStylesPanel, "Bold Italic", Font.BOLD | Font.ITALIC);

        return listOfFontStylesPanel;
    }

    private JScrollPane createScrollPane(JPanel panel) {
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(125, 125));
        return scrollPane;
    }

    private void addFontStyleToPanel(JPanel panel, String styleText, int fontStyle) {
        JLabel styleLabel = new JLabel(styleText);
        styleLabel.setFont(new Font("Dialog", fontStyle, 12));
        styleLabel.addMouseListener(createFontStyleMouseListener(styleLabel));
        panel.add(styleLabel);
    }

    private MouseAdapter createFontStyleMouseListener(JLabel styleLabel) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentFontStyleField.setText(styleLabel.getText());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                styleLabel.setOpaque(true);
                styleLabel.setBackground(Color.PINK);
                styleLabel.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                styleLabel.setBackground(null);
                styleLabel.setForeground(null);
            }
        };
    }

    private String getCurrentFontStyleText() {
        int currentFontStyle = textEditorGUI.getTextArea().getFont().getStyle();
        return switch (currentFontStyle) {
            case Font.PLAIN -> "Plain";
            case Font.BOLD -> "Bold";
            case Font.ITALIC -> "Italic";
            default -> "Bold Italic";
        };
    }
}
