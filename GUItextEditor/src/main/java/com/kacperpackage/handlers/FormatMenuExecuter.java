package main.java.com.kacperpackage.handlers;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.items.TextWrap;
import main.java.com.kacperpackage.menus.*;

import javax.swing.*;

public class FormatMenuExecuter {
    private TextEditorGUI textEditorGUI;
    private JMenu formatMenu;

    public FormatMenuExecuter(TextEditorGUI textEditorGUI, JMenu formatMenu) {
        this.textEditorGUI = textEditorGUI;
        this.formatMenu = formatMenu;
    }

    public void addTextWrapCheckBox() {
        new TextWrap(textEditorGUI, formatMenu);
    }

    public void addTextAlignMenu() {
        new TextAlignMenu(textEditorGUI, formatMenu);
    }

    public void addFontMenu() {
        new FontMenu(textEditorGUI, formatMenu);
    }
}
