import observe.Observable;
import observe.Observer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawArea extends JComponent implements Observer{
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    Image image;
    Graphics2D g2;
    Graphics2D g2Component;
    Color currentColor = Color.black;
    int corner = 0;
    int quarter = 0;
    boolean isAnimate = false;
    JFileChooser chooser;
    BufferedImage bufImage;

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

        chooser = new JFileChooser(System.getProperty("user.dir"));

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
        if (isAnimate) {
            g2Component.rotate(Math.toRadians(corner++), IMAGE_WIDTH / 2, IMAGE_HEIGHT / 2);
            g2Component.drawImage(image, 0, 0, null);
            repaint();
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
    int oldCorner;
    public void animate(){
        oldCorner = corner;
        isAnimate = true;
        repaint();
    }

    public void stopAnimate(){
        isAnimate = false;
        corner = oldCorner;
        repaint();
    }

    public void choose(){
        int ret = chooser.showDialog(null, "Open file");
        if (ret == JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();
            try {
                bufImage = ImageIO.read(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int newWidth;
            int newHeight;
            if (bufImage.getHeight() > bufImage.getWidth()) {
                newHeight = image.getHeight(null);
                newWidth = bufImage.getWidth()*image.getHeight(null)/bufImage.getHeight();
            }else {
                newWidth = image.getWidth(null);
                newHeight = image.getWidth(null)*bufImage.getHeight()/bufImage.getWidth();
            }

            g2.drawImage(bufImage, 0, 0, newWidth, newHeight, null);
            repaint();
        }
    }

}
