import observe.Observable;
import observe.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.AffineTransform;

public class DrawArea extends JComponent implements Observer{
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    Image image;
    Graphics2D g2;
    Color currentColor = Color.black;

    private int currentX, currentY, oldX, oldY;

    public DrawArea(Observable observable) {
        setDoubleBuffered(false);
        observable.registerObserver(this);
        setSize(1000, 1000);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                g2.setColor(currentColor);
                oldX = e.getX();
                oldY = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();

                if (g2 != null){
                    g2.drawLine(currentX, currentY, oldX, oldY);
                    repaint();

                    oldX = currentX;
                    oldY = currentY;
                }
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image == null) {
            image = createImage(600, 600);
            g2 = (Graphics2D) image.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
            /*g2.drawRect(700, 100, 300, 200);
            *//*AffineTransform transform = g2.getTransform();
            AffineTransform newTrans = new AffineTransform();
            newTrans.rotate(-0.3);
            g2.transform(transform);
            g2.setStroke(new BasicStroke(5f));
            g2.drawRect(700, 100, 300, 200);
            g2.setTransform(transform);
            g2.drawRect(700, 100, 300, 200);*//*
            g2.rotate(Math.PI/2);
            g2.translate(0, -600);*/
        }
        g.drawImage(image, 0, 0, null);
    }

    public void clear() {
        g2.setPaint(Color.white);
        g2.fillRect(0, 0, 600, 600);
        g2.setPaint(Color.black);
        repaint();
    }

    public void fill(){
        System.out.println("this is fill()");
        g2.setColor(currentColor);
        g2.fillRect(0, 0, 600, 600);
        repaint();
    }

    public void setColor(Color color) {
        currentColor = color;
    }

    public void setBrushSize(int size){
        float sizeF = (float) size;
        g2.setStroke(new BasicStroke(sizeF, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }
}
