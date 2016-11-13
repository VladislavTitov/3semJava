import pojo.AllWeather;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Main {

    static String cityName;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Font font = new Font("Verdana", Font.PLAIN, 11);

        /*Menu*/

        JMenuBar bar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        menuFile.setFont(font);
        menuFile.addSeparator();

        JMenuItem itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuFile.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuFile.add(itemExit);

        JMenu aboutMenu = new JMenu("About");
        aboutMenu.setFont(font);

        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.setFont(font);
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(null, "Автор: Титов Владислав, 11-502"));

        aboutMenu.add(aboutItem);

        bar.add(menuFile);
        bar.add(aboutMenu);

        /*Panels*/

        JPanel panelRight = new JPanel();
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));

        Button btnRed = new Button("Show Red");
        btnRed.addActionListener(e -> frame.getContentPane().setBackground(Color.RED));
        Button btnTime = new Button("Show Time");
        btnTime.addActionListener(e -> JOptionPane.showMessageDialog(null, new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())));
        Button btnWeather = new Button("Show weather");

        JTextField textField = new JTextField();
        btnWeather
                .addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String cityName = JOptionPane.showInputDialog(
                                textField,
                                "Введите город",
                                "Weather",
                                JOptionPane.PLAIN_MESSAGE);

                        AllWeather weather = CityWeather.getWeather(cityName);

                        JOptionPane.showMessageDialog(
                                null,
                                weather.getName() + "\n" +
                                        Math.round(weather.getMain().getTemp() - 273.15) + " °C\n" +
                                        weather.getWeather().get(0).getDescription()

                        );


                    }
                });



        panelRight.add(btnRed);
        panelRight.add(btnTime);
        panelRight.add(btnWeather);


        frame.getContentPane().add(panelRight, BorderLayout.EAST);
        frame.setJMenuBar(bar);
        frame.setBounds(300, 300, 500, 500);
        frame.setVisible(true);
    }
}
