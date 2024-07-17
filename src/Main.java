import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class CustomerTable extends JFrame implements ActionListener {

    private JTable customerTable;
    private JButton previousButton, nextButton;
    private int currentRecord;

    private String[][] customerData = {
            {"01", "Danith", "Sineon", "097"},
            {"02", "Mai", "love", "088"},
            {"03", "Jing", "Jork", "099"},
            {"04", "Jab", "Hing", "010"},
            {"05", "Jing", "hab", "0926"}
    };

    public CustomerTable() {
        super("Customer Information");

        customerTable = new JTable(customerData, new String[]{"ID", "Last Name", "First Name", "Phone"});
        customerTable.setEnabled(false);

        previousButton = new JButton("Previous");
        nextButton = new JButton("Next");

        previousButton.addActionListener(this);
        nextButton.addActionListener(this);

        currentRecord = 0;

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.add(new JScrollPane(customerTable), BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);

        setSize(500, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Previous")) {

            if (currentRecord > 0) {
                currentRecord--;
                updateTable();
            }
        } else if (command.equals("Next")) {

            if (currentRecord < customerData.length - 1) {
                currentRecord++;
                updateTable();
            }
        }
    }

    private void updateTable() {

        customerTable.getSelectionModel().setSelectionInterval(currentRecord, currentRecord);
    }

    public static void main(String[] args) {
        new CustomerTable();
    }
}