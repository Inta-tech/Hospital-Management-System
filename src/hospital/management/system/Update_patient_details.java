package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_patient_details extends JFrame {


    Update_patient_details()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);

        JLabel label = new JLabel(imageIcon1);
        label.setBounds(630,60,300,300);
        panel.add(label);

        JLabel label1 =new JLabel("Update Patient Details");
        label1.setBounds(124,11,250,25);
        label1.setFont(new Font("tahoma",Font.BOLD,20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);


        JLabel label2 =new JLabel("Name :");
        label2.setBounds(25,88,80,14);
        label2.setFont(new Font("tahoma",Font.BOLD,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);


        Choice choice = new Choice();
        choice.setBounds(248,85,220,30);
        panel.add(choice);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while(resultSet.next())
            {
                choice.add(resultSet.getString("Name"));
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }


        JLabel label3 =new JLabel("Room Number :");
        label3.setBounds(25,129,150,14);
        label3.setFont(new Font("tahoma",Font.BOLD,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);


        JTextField textField = new JTextField();
        textField.setBounds(248,129,220,20);
        panel.add(textField);


        JLabel label4 =new JLabel("In Time :");
        label4.setBounds(25,174,150,14);
        label4.setFont(new Font("tahoma",Font.BOLD,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);


        JTextField textFieldIntime = new JTextField();
        textFieldIntime.setBounds(248,174,220,20);
        panel.add(textFieldIntime);


        JLabel label5 =new JLabel("Amount Paid (TK) : ");
        label5.setBounds(25,216,150,14);
        label5.setFont(new Font("tahoma",Font.BOLD,14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textFieldITK = new JTextField();
        textFieldITK.setBounds(248,216,220,20);
        panel.add(textFieldITK);


        JLabel label6 =new JLabel("Pending Amount (TK) : ");
        label6.setBounds(25,260,200,20);
        label6.setFont(new Font("tahoma",Font.BOLD,14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textFieldITKPENDING = new JTextField();
        textFieldITKPENDING.setBounds(248,260,220,20);
        panel.add(textFieldITKPENDING);


        JButton check = new JButton("CHECK");
        check.setBounds(281,378,150,25);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from patient_info where Name ='"+id+"'";

                try{
                    conn c = new conn();

                    ResultSet resultSet = c.statement.executeQuery(q);

                    while(resultSet.next())
                    {
                        textField.setText(resultSet.getString("Room_Number"));
                        textFieldIntime.setText(resultSet.getString("Time"));
                        textFieldITK.setText(resultSet.getString("Deposite"));

                    }

                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where room_no = '"+textField.getText()+"'");
                    while(resultSet1.next())
                    {
                        String price = resultSet1.getString("Price");
                        int paid = Integer.parseInt(textFieldITK.getText()); // amount paid
                        int total = Integer.parseInt(price);                 // total price from room table
                        int pending = total - paid;                          // pending = total - paid
                        textFieldITKPENDING.setText("" + pending);

                    }

                }catch (Exception E)
                {
                    E.printStackTrace();
                }

            }

        });



        JButton Update = new JButton("UPDATE");
        Update.setBounds(56,378,150,25);
        Update.setBackground(Color.BLACK);
        Update.setForeground(Color.WHITE);
        panel.add(Update);
        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conn c = new conn();
                    String q = choice.getSelectedItem();
                    String room = textField.getText();
                    String time = textFieldIntime.getText();
                    String amount = textFieldITK.getText();
                    c.statement.executeUpdate("update patient_info set Room_Number = '"+room+"', Time = '"+time+"', Deposite = '"+amount+"' where name = '"+q+"'");
                    JOptionPane.showMessageDialog(null,"Updated Successful");
                    setVisible(true);

                }catch (Exception q)
                {
                    q.printStackTrace();
                }
            }
        });


        JButton BACK = new JButton("BACK");
        BACK.setBounds(500,378,150,25);
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
        setSize(1000,600);
        setLayout(null);
        setLocation(300,150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Update_patient_details();
    }
}
