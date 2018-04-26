import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    public static int i = 0;
    private long previous;

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(new Color(81, 81, 81));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(new Color(255, 255, 0));
        g.fillRect((int) (10 + i), 10, 100, 100);
    }
}
