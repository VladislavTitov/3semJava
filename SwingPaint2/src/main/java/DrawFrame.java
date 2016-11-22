import observe.Observable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawFrame extends JFrame implements ActionListener{

    JButton fill;
    JSlider slider;
    JButton clear;
    JButton mirror;
    JButton turn;
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

        turn = new JButton("Turn");
        turn.addActionListener(this);

        controls.add(fill);
        controls.add(slider);
        controls.add(clear);
        controls.add(mirror);
        controls.add(turn);

        JScrollPane scrollPane = new JScrollPane(drawArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        getContentPane().add(controls, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        pack();
        setSize(600, 600);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fill){
            drawArea.fill();
        }else if (e.getSource() == clear){
            drawArea.clear();
        }
    }
}
