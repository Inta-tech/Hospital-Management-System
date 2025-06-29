package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ALL_Employee_info extends JFrame {

    ALL_Employee_info(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,390);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);






        JTable table = new JTable();
        table.setBounds(10,34,980,300);
        table.setBackground(new Color(109,164,170));
        table.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(table);


        try{
            conn c = new conn();
            String q = "select * from EMP_INFO";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e)
        {
            e.printStackTrace();
        }


        JLabel label1= new JLabel("Name");
        label1.setBounds(12,11,70,20);
        label1.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(label1);


        JLabel age= new JLabel("Age");
        age.setBounds(175,11,70,20);
        age.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(age);


        JLabel number= new JLabel("Phone Number");
        number.setBounds(337,11,150,20);
        number.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(number);


        JLabel Salary= new JLabel("Salary");
        Salary.setBounds(500,11,150,20);
        Salary.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(Salary);


        JLabel Gmail= new JLabel("Gmail");
        Gmail.setBounds(664,11,150,20);
        Gmail.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(Gmail);

        JLabel id= new JLabel("Nation ID");
        id.setBounds(829,11,150,20);
        id.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(id);


        JButton button = new JButton("BACK");
        button.setBounds(430,340,120,30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });




        setUndecorated(true);
        setSize(1000,400);
        setLocation(350,230);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ALL_Employee_info();
    }
}
