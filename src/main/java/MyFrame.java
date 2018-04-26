import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    private MyPanel panel;

    public MyFrame() {
        setTitle("MyRPGMaker");
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        panel = new MyPanel();
        setContentPane(panel);
        //go();

        JButton button = new JButton("Button");
        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);
        gl.setAutoCreateContainerGaps(true);
        gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(button));
        gl.setVerticalGroup(gl.createSequentialGroup().addComponent(button));

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
            Toolkit.getDefaultToolkit().sync(); /* Is compulsory to have smooth animations */
        }
    }

}
