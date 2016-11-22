import observe.Observable;
import observe.Observer;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class ColorChooser extends JPanel
        implements ChangeListener, Observable {

    private List<Observer> observers;
    private JColorChooser chooser;

    public ColorChooser() {
        super(new BorderLayout());
        observers = new ArrayList<Observer>();

        chooser = new JColorChooser();
        chooser.getSelectionModel().addChangeListener(this);
        chooser.setBorder(BorderFactory.createTitledBorder(
                "Choose Text Color"));
        add(chooser);

    }

    public void stateChanged(ChangeEvent e) {
        Color newColor = chooser.getColor();
        notifyObservers(newColor);
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(Color color) {
        for (Observer observer :
                observers) {
            observer.setColor(color);
        }
    }

    public static ColorChooser createAndShowGUI() {
        JFrame frame = new JFrame("ColorChooser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        ColorChooser newContentPane = new ColorChooser();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
        return newContentPane;
    }
}
