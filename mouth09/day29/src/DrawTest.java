import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class DrawTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new MyFrame();
            frame.setTitle("MyFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    public static class MyFrame extends JFrame {
        public MyFrame() {
            add(new MyComponent());
            pack();
        }
    }

    private static class MyComponent extends JComponent {
        private static final int DEFAULT_WIDTH = 400;
        private static final int DEFAULT_HEIGHT = 400;

        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;

            String message = "Hello World !";

            Font f = new Font("Serif", Font.BOLD, 36);
            g2.setFont(f);

            FontRenderContext context = g2.getFontRenderContext();
            Rectangle2D bounds = f.getStringBounds(message, context);

            double x = (getWidth() - bounds.getCenterX()) / 2;
            double y = (getHeight() - bounds.getCenterY()) / 2;

            double ascent = -bounds.getY();
            double baseY = y + ascent;

            g2.drawString(message, (int)x, (int)baseY);

            g2.setPaint(Color.LIGHT_GRAY);
            g2.draw(new Line2D.Double(x, baseY, x + bounds.getWidth(), baseY));

            Rectangle2D rect = new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight());
            g2.draw(rect);
        }

        public Dimension getPreferredSize() {
            return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }
    }
}
