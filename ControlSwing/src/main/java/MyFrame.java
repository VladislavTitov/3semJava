import models.User;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class MyFrame extends JFrame{

    public MyFrame() throws HeadlessException {
        super("Control");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel motherPanel = new JPanel(new BorderLayout());

        JPanel boxPanel = new JPanel();
        GridBagLayout grid = new GridBagLayout();
        boxPanel.setLayout(grid);
        GridBagConstraints constraints = new GridBagConstraints();
        /*boxPanel.add();*/

        JLabel labelSur = new JLabel("Enter surname");
        final JTextField textField = new JTextField(20);
        JLabel labelName = new JLabel("Enter name");
        final JTextField textFieldName = new JTextField(20);
        JLabel labelAge = new JLabel("Enter age");
        final JTextField textFieldAge = new JTextField(2);

        final JCheckBox checkBox = new JCheckBox("Married?");

        boxPanel.add(labelSur);
        boxPanel.add(textField);

        boxPanel.add(labelName);
        boxPanel.add(textFieldName);

        boxPanel.add(labelAge);
        boxPanel.add(textFieldAge);

        boxPanel.add(checkBox);

        JButton buttonSave = new JButton("Save");
        buttonSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                User newUser = new User.Builder()
                    .setSurname(textField.getText())
                    .setName(textFieldName.getText())
                    .setAge(Integer.parseInt(textFieldAge.getText()))
                    .setMarried(checkBox.isSelected())
                    .build();
            }
        });




        MyModel model = new MyModel();
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);


        add(boxPanel, BorderLayout.EAST);
        add(scrollPane, BorderLayout.CENTER);
        pack();
        setBounds(0, 0, 1920, 1080);
        setVisible(true);
    }

    class MyModel implements TableModel{

        private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

        private java.util.List<User> users;

        public MyModel() {
            updateUsers(new ArrayList<User>());
        }

        public void updateUsers(List<User> users){
            this.users = users;
        }

        public int getRowCount() {
            return users.size();
        }

        public int getColumnCount() {
            return 5;
        }

        public String getColumnName(int columnIndex) {
            switch (columnIndex){
                case 0:
                    return "id";
                case 1:
                    return "Surname";
                case 2:
                    return "Name";
                case 3:
                    return "Age";
                case 4:
                    return "Married";
                default:
                    return "don't know";
            }

        }

        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex){
                case 0:
                case 3:
                    return Integer.class;
                case 1:
                case 2:
                    return String.class;
                case 4:
                    return Boolean.class;
                default:
                    return String.class;
            }
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {

            User user = users.get(rowIndex);

            switch (columnIndex){
                case 0:
                    return user.getId();
                case 1:
                    return user.getSurname();
                case 2:
                    return user.getName();
                case 3:
                    return user.getAge();
                case 4:
                    return user.isMarried();
                default:
                    return "don't know";
            }

        }

        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        }

        public void addTableModelListener(TableModelListener l) {
            listeners.add(l);
        }

        public void removeTableModelListener(TableModelListener l) {
            listeners.remove(l);
        }
    }
}
