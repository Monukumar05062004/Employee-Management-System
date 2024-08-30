package Employee.Management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice choiceEId;
    JButton delete,back;
    RemoveEmployee(){
        JLabel  label=new JLabel("Employee Id");
        label.setBounds(50,50,100,30);
        label.setFont(new Font("Tahoma",Font.BOLD,15));
        add(label);

        choiceEId=new Choice();
        choiceEId.setBounds(200,50,100,30);
        choiceEId.setFont(new Font("Tahoma",Font.BOLD,15));
        add(choiceEId);

        try{
            Conn c=new Conn();
            ResultSet resultSet=c.statement.executeQuery("select * from employee");
            while(resultSet.next()){
                choiceEId.addItem(resultSet.getString("employeeId"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        JLabel JLName=new JLabel("Name");
        JLName.setBounds(50,100,100,30);
        JLName.setFont(new Font("Tahoma",Font.BOLD,15));
        add(JLName);

        JLabel tName=new JLabel("Name");
        tName.setBounds(200,100,100,30);
        tName.setFont(new Font("Tahoma",Font.BOLD,15));
        add(tName);

        JLabel jlPhone=new JLabel("Phone No");
        jlPhone.setBounds(50,150,100,30);
        jlPhone.setFont(new Font("Tahoma",Font.BOLD,15));
        add(jlPhone);

        JLabel tPhone=new JLabel();
        tPhone.setBounds(200,150,100,30);
        tPhone.setFont(new Font("Tahoma",Font.BOLD,15));
        add(tPhone);

        JLabel jlEmail=new JLabel("Email Id");
        jlEmail.setBounds(50,200,100,30);
        jlEmail.setFont(new Font("Tahoma",Font.BOLD,15));
        add(jlEmail);

        JLabel tEmail=new JLabel();
        tEmail.setBounds(200,200,100,30);
        tEmail.setFont(new Font("Tahoma",Font.BOLD,15));
        add(tEmail);

        try{
            Conn conn =new Conn();
            ResultSet resultSet=conn.statement.executeQuery("select * from employee where employeeId='"+choiceEId.getSelectedItem()+"'");
            while(resultSet.next()) {
                tName.setText(resultSet.getString("name"));
                tPhone.setText(resultSet.getString("phoneNo"));
                tEmail.setText(resultSet.getString("email"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        choiceEId.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent E1){
            try {
                if (E1.SELECTED == E1.getStateChange()) {
                    Conn conn =new Conn();
                    ResultSet resultSet=conn.statement.executeQuery("select * from employee where employeeId='"+choiceEId.getSelectedItem()+"'");
                    while(resultSet.next()) {
                        tName.setText(resultSet.getString("name"));
                        tPhone.setText(resultSet.getString("phoneNo"));
                        tEmail.setText(resultSet.getString("email"));
                    }
                    }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        });
        delete =new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back =new JButton("Back");
        back.setBounds(200,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel j1=new JLabel(i3);
        j1.setBounds(700,80,200,200);
        add(j1);

        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i22=i11.getImage().getScaledInstance(1000,400,Image.SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel j2=new JLabel(i33);
        j2.setBounds(0,0,1000,400);
        add(j2);

        setBounds(300,150,1000,400);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==delete){
            try{
                Conn conn3=new Conn();
                conn3.statement.executeUpdate("delete from employee where employeeId='"+choiceEId.getSelectedItem()+"'");
                JOptionPane.showMessageDialog(null,"Employee deleted successful");
                setVisible(false);
                new MainClass();
                }
               catch(Exception exception){
                exception.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new MainClass();
        }
    }

}
