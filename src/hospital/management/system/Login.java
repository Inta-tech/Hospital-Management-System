package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1,b2;


    Login()
    {

        JLabel namelabel = new JLabel("Username : ");
        namelabel.setBounds(40,20,100,30);
        namelabel.setFont(new Font("tahoma", Font.BOLD,16));
        namelabel.setForeground(Color.BLACK); // sets text color
        add(namelabel);

        JLabel password = new JLabel("Password : ");
        password.setBounds(40,60,100,30);
        password.setFont(new Font("tahoma", Font.BOLD,16));
        password.setForeground(Color.BLACK); // sets text color
        add(password);

        textField = new JTextField();
        textField.setBounds(150,20,150,30);
        textField.setFont(new Font("Tahoma",Font.BOLD,15));
        textField.setBackground(new Color(255, 255, 255));
        add(textField);  // for text Box.

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(150,60,150,30);
        jPasswordField.setFont(new Font("tahoma",Font.BOLD,15));
        jPasswordField.setBackground(new Color(255,255,255));
        add(jPasswordField);


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Hello Wolrd.jpeg"));
        Image i1 = imageIcon.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel((imageIcon1));
        label.setBounds(320,-30,400,300);
        add(label);



        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);


        getContentPane().setBackground(new Color(109, 164, 170));
        setSize(750,300);
        setLocation(400,270); // to fix the flame in the middle
        setLayout(null);  // layout
        setVisible(true);  // show korbe kina
    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b1 )  // if touched to bq
        {
            try{
                conn c = new conn();
                String user = textField.getText();
                String password = jPasswordField.getText();
                String q = "select * from login where ID = '"+user+"' and Password = '"+password+"'";
                ResultSet resultset = c.statement.executeQuery(q);

                if(resultset.next())
                {
                    new Reception();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid");
                }

            }catch(Exception E)
            {
                E.printStackTrace();
            }
        }else {
            System.exit(10);
        }

    }
}
/*

 Intasar Mostafiz

 */
