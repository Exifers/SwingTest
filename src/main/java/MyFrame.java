import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    private MyPanel panel;

    public MyFrame() {
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        panel = new MyPanel();
        setContentPane(panel);
        go();
    }

    private void go() {
        while (true) {
            panel.i += 1;
            try {
                Thread.sleep(20); /* 20 ms = 50 fps */
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            panel.repaint();
            Toolkit.getDefaultToolkit().sync();
        }
    }

}
