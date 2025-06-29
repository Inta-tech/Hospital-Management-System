package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Search_room extends JFrame {

    Choice choice ;

    JTable table;

    Search_room()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel Search = new JLabel("Search For Room");
        Search.setBounds(250,11,186,31);
        Search.setForeground(Color.WHITE);
        Search.setFont(new Font("tahoma",Font.BOLD,20));
        panel.add(Search);


        JLabel Status = new JLabel("Status :");
        Status.setBounds(50,73,120,20);
        Status.setForeground(Color.WHITE);
        Status.setFont(new Font("tahoma",Font.BOLD,20));
        panel.add(Status);


        choice = new Choice();
        choice.setBounds(170,73,160,30);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);


        table = new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(90,156,163));
        table.setForeground(Color.WHITE);
        panel.add(table);


        try{
            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel Room = new JLabel("Room Number");
        Room.setBounds(1,155,186,31);
        Room.setForeground(Color.WHITE);
        Room.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(Room);


        JLabel AO = new JLabel("Status");
        AO.setBounds(177,155,186,31);
        AO.setForeground(Color.WHITE);
        AO.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(AO);


        JLabel paid = new JLabel("Paid");
        paid.setBounds(350,155,186,31);
        paid.setForeground(Color.WHITE);
        paid.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(paid);


        JLabel bedType = new JLabel("Bed Type");
        bedType.setBounds(525,155,186,31);
        bedType.setForeground(Color.WHITE);
        bedType.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(bedType);


        JButton search = new JButton("Search");
        search.setBounds(175,420,100,20);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        panel.add(search);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from room where Availability = '"+choice.getSelectedItem()+"'";

                try{
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception a)
                {
                    a.printStackTrace();
                }


            }
        });



        JButton BACK = new JButton("BACK");
        BACK.setBounds(350,420,100,20);
        BACK.setBackground(Color.BLACK);
        BACK.setForeground(Color.WHITE);
        panel.add(BACK);
        BACK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(400,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Search_room();
    }
}
