package project;


import java.util.HashMap;
import java.awt.Color;
import java.awt.*;
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

class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(Image image) {
        this.backgroundImage = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}

    
    HashMap<String, String> login4 = new HashMap<String, String>();
    Login(HashMap<String,String> logininfor)
    {
        Image backgroundImage = new ImageIcon("C:\\Users\\SV\\Pictures\\anh.jpg").getImage();
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        backgroundPanel.setLayout(null); // Đặt layout là null để sử dụng tọa độ tùy chỉnh

        userlabel.setBounds(30, 250, 100, 30);
        passLabel.setBounds(50, 300, 60, 30);
        message.setBounds(200, 40, 190, 50);
        backgroundPanel.add(userlabel);
        backgroundPanel.add(passLabel);
        backgroundPanel.add(message);

        user.setBounds(115, 250, 150, 40);
        pass.setBounds(115, 300, 150, 40);
        backgroundPanel.add(user);
        backgroundPanel.add(pass);

        dangnhap.setBounds(105, 350, 100, 60);
        dangnhap.addActionListener(this);
        backgroundPanel.add(dangnhap);

        login4 = logininfor;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setContentPane(backgroundPanel); // Thay thế contentPane bằng backgroundPanel
        frame.setVisible(true);
        
    }

 @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == dangnhap)
        {
            String userid = user.getText();
            String passwords = String.valueOf(pass.getPassword());
           
            
                if (userid.equals("admin")&&login4.get(userid).equals(passwords) )
                {
                    message.setForeground(Color.GREEN);
                    message.setText("Dang nhap thanh cong");
                    Quanlysinhvien newpage = new Quanlysinhvien();
                    newpage.setVisible(true);
                    frame.setVisible(false);
                }
                else{ 
                 if   (login4.containsKey(userid)&&passwords.equals(login4.get(userid)))
        		{
        			Dangkymon newpage = new Dangkymon();
        			newpage.setVisible(true);
        		}
                 else{
                  message.setText("Nhap lai tai khoan va mat khau");
                 }
                }
                
            

        }
    }
}

