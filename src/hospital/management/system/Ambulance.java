package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends JFrame {

    Ambulance()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 1150, 590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10, 40, 1100, 450);  // Wider table
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(table);

        try {
            conn c = new conn();
            String q = "select * from Ambulance";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Adjusted label positions and widths
        JLabel id = new JLabel("Name");
        id.setBounds(10, 13, 80, 14);
        id.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(id);

        JLabel number = new JLabel("Gender");
        number.setBounds(232, 13, 100, 14);
        number.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(number);

        JLabel name = new JLabel("Car Name");
        name.setBounds(452, 13, 180, 14); // Extended width for long names
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(name);

        JLabel gender = new JLabel("Status");
        gender.setBounds(670, 13, 100, 14);
        gender.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(gender);

        JLabel disease = new JLabel("Location");
        disease.setBounds(892, 13, 100, 14);
        disease.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(disease);



        JButton button = new JButton("BACK");
        button.setBounds(500, 510, 120, 30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setSize(1150, 600);
        setLayout(null);
        setLocation(200, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ambulance();
    }
}
