package main.java.com.kacperpackage.Handlers.Executors;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.Items.FormatItems.TextWrap;
import main.java.com.kacperpackage.Menus.Format.FontMenu;
import main.java.com.kacperpackage.Menus.Format.TextAlignMenu;

import javax.swing.*;

public class FormatMenuExecutor implements Executor{
    private final TextEditorGUI textEditorGUI;
    private final JMenu formatMenu;

    public FormatMenuExecutor(TextEditorGUI textEditorGUI, JMenu formatMenu) {
        this.textEditorGUI = textEditorGUI;
        this.formatMenu = formatMenu;
    }

    @Override
    public void addMenuItems() {
        addTextWrapCheckBox();
        addTextAlignMenu();
        addFontMenu();
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
