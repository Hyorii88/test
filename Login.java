package project;

import java.util.HashMap;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.*;
public class Login implements ActionListener {
    JFrame frame = new JFrame();
    JButton dangnhap = new JButton("Dang nhap");
    JTextField user = new JTextField();
    JPasswordField pass = new JPasswordField();
    JLabel userlabel= new JLabel("Ten dang nhap");
    JLabel passLabel= new JLabel("Mat khau");
    JLabel message= new JLabel("");

    HashMap<String, String> login4 = new HashMap<String, String>();
    Login(HashMap<String,String> logininfor)
    {
        userlabel.setBounds(30,250,100,30);
        passLabel.setBounds(50,300,60,30);
        message.setBounds(200,40,190,50);
        frame.add(userlabel);
        frame.add(passLabel);
        frame.add(message);
        

        user.setBounds(115,250,150,40);
        pass.setBounds(115,300,150,40);
        frame.add(user);
        frame.add(pass);

        dangnhap.setBounds(105,350,100,60);
        dangnhap.addActionListener(this);
        frame.add(dangnhap);


        login4=logininfor;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

 @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == dangnhap)
        {
            String userid = user.getText();
            String passwords = String.valueOf(pass.getPassword());
            if (login4.containsKey(userid))
            {
                if (login4.get(userid).equals("admin") && userid.equals("admin"))
                {
                    message.setForeground(Color.GREEN);
                    message.setText("Dang nhap thanh cong");
                    Quanlysinhvien newpage = new Quanlysinhvien();
                    newpage.setVisible(true);
                    frame.setVisible(false);
                }
                else
        		{
        			Dangkymon newpage = new Dangkymon();
        			newpage.setVisible(true);
        		}
            }

        }
    }
}

