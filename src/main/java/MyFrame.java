import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyFrame extends JFrame {

    private MyPanel panel;

    public MyFrame() {
        setTitle("MyRPGMaker");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);


        panel = new MyPanel();
        setContentPane(panel);

        // comment the line below to display the exit button
        //go();

        /* Setting an exit button */
        JButton button = new JButton("Quit");
        button.addActionListener(actionEvent -> System.exit(0));
        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);
        gl.setAutoCreateContainerGaps(true);
        gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(button));
        gl.setVerticalGroup(gl.createSequentialGroup().addComponent(button));


        /* Setting icon */
        /* Note : image took from internet with rights for utilisation */
        ImageIcon icon = null;
        try {
            icon = new ImageIcon(ImageIO.read(new File("src/main/resources/img/icon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setIconImage(icon.getImage());


        /* Creating menus */
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;

        //Create the menu bar
        menuBar = new JMenuBar();

        //Build the first menu
        menu = new JMenu("A menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
        menuBar.add(menu);

        setJMenuBar(menuBar);

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
