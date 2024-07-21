import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            /* used to make GUI more thread safe */
            @Override
            public void run() {
                new TextEditorGUI().setVisible(true);
            }
        });
    }
}