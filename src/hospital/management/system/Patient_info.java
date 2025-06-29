package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Patient_info extends JFrame {

    Patient_info(){

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
            String q = "select * from Patient_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Adjusted label positions and widths
        JLabel id = new JLabel("ID");
        id.setBounds(10, 13, 80, 14);
        id.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(id);

        JLabel number = new JLabel("Number");
        number.setBounds(150, 13, 100, 14);
        number.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(number);

        JLabel name = new JLabel("Name");
        name.setBounds(290, 13, 180, 14); // Extended width for long names
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(name);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(423, 13, 100, 14);
        gender.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(gender);

        JLabel disease = new JLabel("Disease");
        disease.setBounds(560, 13, 100, 14);
        disease.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(disease);

        JLabel room = new JLabel("Room");
        room.setBounds(700, 13, 100, 14);
        room.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(room);

        JLabel time = new JLabel("Time");
        time.setBounds(840, 13, 100, 14);
        time.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(time);

        JLabel deposite = new JLabel("Deposite");
        deposite.setBounds(975, 13, 100, 14);
        deposite.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(deposite);

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
        new Patient_info();
    }
}
