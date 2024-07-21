import javax.swing.*;
import java.awt.*;

public class TextEditorGUI extends JFrame {
    public TextEditorGUI() {
        super("TextEditor");
        setSize(480, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addGuiComponents();
    }

    private void addGuiComponents() {
        addToolBar();
        addTextArea();
    }

    private void addToolBar() {
        JToolBar toolBar = new JToolBar();

        // ADD MENU BAR
        JMenuBar menuBar = new JMenuBar();
        toolBar.add(menuBar);

        // ADD MENUS
        menuBar.add(addFileMenu());

        add(toolBar, BorderLayout.NORTH);
    }

    private JMenu addFileMenu() {
        JMenu fileMenu = new JMenu("File");

        // "new file" functionality
        JMenuItem newMenuItem = new JMenuItem("New");
        fileMenu.add(newMenuItem);

        // "open file" functionality
        JMenuItem openMenuItem = new JMenuItem("Open");
        fileMenu.add(openMenuItem);

        // "save" functionality
        JMenuItem saveMenuItem = new JMenuItem("Save");
        fileMenu.add(saveMenuItem);

        // "save as" functionality
        JMenuItem saveAsMenuItem = new JMenuItem("Save As");
        fileMenu.add(saveAsMenuItem);

        // "exit" functionality
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);

        return fileMenu;
    }

    private void addTextArea() {
        JTextArea textArea = new JTextArea();
        add(textArea, BorderLayout.CENTER);
    }

}
