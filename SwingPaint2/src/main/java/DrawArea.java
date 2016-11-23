import observe.Observable;
import observe.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawArea extends JComponent implements Observer{
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    Image image;
    Graphics2D g2;
    Graphics2D g2Component;
    Color currentColor = Color.black;
    int corner = 0;
    int quarter = 0;

    public static final int IMAGE_WIDTH = 900;
    public static final int IMAGE_HEIGHT = 900;

    private int currentX, currentY, oldX, oldY;

    public DrawArea(Observable observable) {
        setDoubleBuffered(false);
        observable.registerObserver(this);


        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                g2.setColor(currentColor);
                if (quarter == 0) {
                    oldX = e.getX();
                    oldY = e.getY();
                }else if (quarter == 90){
                    oldX = e.getY();
                    oldY = IMAGE_HEIGHT - e.getX();
                }else if (quarter == 180){
                    oldX = IMAGE_WIDTH - e.getX();
                    oldY = IMAGE_HEIGHT - e.getY();
                }else if (quarter == 270){
                    oldX = IMAGE_WIDTH - e.getY();
                    oldY = e.getX();
                }
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (quarter == 0) {
                    currentX = e.getX();
                    currentY = e.getY();
                }else if (quarter == 90){
                    currentX = e.getY();
                    currentY = IMAGE_HEIGHT - e.getX();
                }else if (quarter == 180){
                    currentX = IMAGE_WIDTH - e.getX();
                    currentY = IMAGE_HEIGHT - e.getY();
                }else if (quarter == 270){
                    currentX = IMAGE_WIDTH - e.getY();
                    currentY = e.getX();
                }

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
        g2Component = (Graphics2D) g;

        if (image == null) {
            image = createImage(IMAGE_WIDTH, IMAGE_HEIGHT);
            g2 = (Graphics2D) image.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }



        g2Component.rotate(Math.toRadians(quarter), IMAGE_WIDTH / 2, IMAGE_HEIGHT / 2);
        g2Component.drawImage(image, 0, 0, null);

    }

    public void clear() {
        g2.setPaint(Color.white);
        g2.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        g2.setPaint(Color.black);
        repaint();
    }

    public void fill(){
        System.out.println("this is fill()");
        g2.setColor(currentColor);
        g2.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        repaint();
    }

    public void setColor(Color color) {
        currentColor = color;
    }

    public void setBrushSize(int size){
        float sizeF = (float) size;
        g2.setStroke(new BasicStroke(sizeF, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }

    public void turn(){
        corner += 90;
        quarter = corner % 360;
        repaint();
    }
}
