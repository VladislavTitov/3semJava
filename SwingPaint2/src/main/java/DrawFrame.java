import observe.Observable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.metal.MetalScrollButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawFrame extends JFrame implements ActionListener{

    JButton fill;
    JSlider slider;
    JButton clear;
    JButton mirror;
    JButton turnRight;
    JButton animate;
    JButton choose;
    DrawArea drawArea;


    public DrawFrame(Observable observable) throws HeadlessException {
        super("Paint");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        drawArea = new DrawArea(observable);

        JPanel controls = new JPanel();

        fill = new JButton("Fill");
        fill.addActionListener(this);

        slider = new JSlider(JSlider.HORIZONTAL, 0, 20, 1);
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider)e.getSource();
                if (!slider.getValueIsAdjusting()){
                    drawArea.setBrushSize(slider.getValue());
                }
            }
        });

        clear = new JButton("Clear");
        clear.addActionListener(this);

        mirror = new JButton("Reflect");
        mirror.addActionListener(this);

        turnRight = new JButton("Turn right");
        turnRight.addActionListener(this);

        animate = new JButton("Animate");
        animate.addActionListener(this);

        choose = new JButton("Choose file");
        choose.addActionListener(this);

        controls.add(fill);
        controls.add(slider);
        controls.add(clear);
        controls.add(mirror);
        controls.add(turnRight);
        controls.add(animate);
        controls.add(choose);

        getContentPane().add(controls, BorderLayout.NORTH);
        getContentPane().add(drawArea, BorderLayout.CENTER);


        pack();
        setSize(900, 1000);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fill){
            drawArea.fill();
        }else if (e.getSource() == clear) {
            drawArea.clear();
        }else if (e.getSource() == turnRight){
            drawArea.turn();
        }else if (e.getSource() == animate){
            if (animate.getText().equals("Animate")){
                animate.setText("Stop");
                drawArea.animate();
            }else {
                animate.setText("Animate");
                drawArea.stopAnimate();
            }
        }else if (e.getSource() == choose){
            drawArea.choose();
        }
    }
}
