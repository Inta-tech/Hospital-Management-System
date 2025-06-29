package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Patient_discharge extends JFrame {

    JButton b1;

    Patient_discharge() {



        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);


        JLabel label = new JLabel("Check Out");
        label.setBounds(30,20,150,20);
        label.setFont(new Font("tahoma",Font.BOLD,20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel label2 = new JLabel("Customer ID");
        label2.setBounds(30,80,150,20);
        label2.setFont(new Font("tahoma",Font.BOLD,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);


     ///   Choice for dropdown box

        Choice choice = new Choice();
        choice.setBounds(200,80,150,20);
        panel.add(choice);


        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("Number"));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }


        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(30,130,150,20);
        label3.setFont(new Font("tahoma",Font.BOLD,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);


        JLabel RNO = new JLabel();
        RNO.setBounds(200,130,150,20);
        RNO.setFont(new Font("tahoma",Font.BOLD,14));
        RNO.setForeground(Color.WHITE);
        panel.add(RNO);


        JLabel label4 = new JLabel("In Time");
        label4.setBounds(30,180,300,20);
        label4.setFont(new Font("tahoma",Font.BOLD,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);


        JLabel InTime = new JLabel();
        InTime.setBounds(200,180,300,20);
        InTime.setFont(new Font("tahoma",Font.BOLD,14));
        InTime.setForeground(Color.WHITE);
        panel.add(InTime);


        JLabel label5 = new JLabel("Out Time");
        label5.setBounds(30,230,150,20);
        label5.setFont(new Font("tahoma",Font.BOLD,14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);


        Date date = new Date();

        JLabel OutTime = new JLabel(""+date);
        OutTime.setBounds(200,230,300,20);
        OutTime.setFont(new Font("tahoma",Font.BOLD,14));
        OutTime.setForeground(Color.WHITE);
        panel.add(OutTime);

        JButton discharge = new JButton("DISCHARGE");
        discharge.setBounds(100,300,120,30);
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();

                try{
                    c.statement.executeUpdate("delete from patient_info where Number ='"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("Update room set Availability = 'Available' where room_no = '"+RNO.getText()+"'");

                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);

                }catch (Exception w)
                {
                    w.printStackTrace();
                }
            }
        });



        JButton Check = new JButton("CHECK");
        Check.setBounds(250,300,120,30);
        Check.setBackground(Color.BLACK);
        Check.setForeground(Color.WHITE);
        panel.add(Check);

        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();

                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from patient_info where Number = '"+choice.getSelectedItem()+"'");

                    while(resultSet.next())
                    {
                        RNO.setText(resultSet.getString("Room_Number"));
                        InTime.setText(resultSet.getString("Time"));

                    }
                }catch (Exception E)
                {
                    E.printStackTrace();
                }

            }
        });



        JButton BACK = new JButton("BACK");
        BACK.setBounds(400,300,120,30);
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
        setSize(800,400);
        setLayout(null);
        setLocation(350,200);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Patient_discharge();
    }
}
