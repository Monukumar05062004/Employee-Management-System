package Employee.Management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField tUserName;
    JPasswordField tPassword;
    JButton login,back;
    Login(){
        tUserName=new JTextField();
        tUserName.setBounds(150,20,150,30);
        add(tUserName);

        tPassword=new JPasswordField();
        tPassword.setBounds(150,70,150,30);
        add(tPassword);

        JLabel userName=new JLabel("User Name");
        userName.setBounds(40,20,100,20);
        add(userName);

        JLabel password=new JLabel("Password");
        password.setBounds(40,70,100,20);
        add(password);

        login=new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        back=new JButton("BACK");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22=i11.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel img1=new JLabel(i33);
        img1.setBounds(350,10,600,300);
        add(img1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,600,300);
        add(img);

        setBounds(450,200,600,300);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent event){
        if(event.getSource()==login){
            try{
            String userName=tUserName.getText();
            String password=tPassword.getText();
            Conn conn=new Conn();
            String query="select * from login where userName='"+userName+"' and password='"+password+"'";
            ResultSet resultSet=conn.statement.executeQuery(query);//In practice, it's common to use a PreparedStatement for executing parameterized
                // queries for enhanced security and performance.
                if(resultSet.next()){
                    setVisible(false);
                    new MainClass();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid userName or password");
                }
            }
            catch(Exception E){
                E.printStackTrace();
            }
        }
        else if(event.getSource()==back){
            System.exit(7);
        }
    }

}
