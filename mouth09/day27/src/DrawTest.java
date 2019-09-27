import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class DrawTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new DrawFrame();
            frame.setTitle("DrawTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    private static class DrawFrame extends JFrame {
        private DrawFrame() {
            add(new DrawComponent());
            pack();
        }
    }

    private static class DrawComponent extends JComponent {
        private static final int DEFAULT_WIDTH = 400;
        private static final int DEFAULT_HEIGHT = 400;

        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;

            double leftX = 100;
            double topY = 100;
            double width = 200;
            double height = 150;

            //draw rectangle
            Rectangle2D rectangle = new Rectangle2D.Double(leftX, topY, width, height);
            g2.draw(rectangle);

            //draw ellipse
            Ellipse2D ellipse = new Ellipse2D.Double();
            ellipse.setFrame(rectangle);
            g2.draw(ellipse);
            /*g2.setPaint(Color.RED);
            g2.fill(ellipse);*/

            //draw line
            Line2D line = new Line2D.Double(leftX, topY, leftX + width, topY + height);
            g2.draw(line);

            //draw circle
            double centerX = rectangle.getCenterX();
            double centerY = rectangle.getCenterY();
            double radius = 150;

            Ellipse2D circle = new Ellipse2D.Double();
            circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
            g2.draw(circle);
        }

        public Dimension getPreferredSize() {
            return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }
    }
}
