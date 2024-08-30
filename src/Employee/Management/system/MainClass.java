package Employee.Management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass extends JFrame implements ActionListener {
    JButton add,view,rem;
    MainClass(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2=i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel imgComponent=new JLabel(i3);
        imgComponent.setBounds(0,0,1120,630);
        add(imgComponent);

        JLabel heading=new JLabel("Employee Management System");
        heading.setBounds(340,155,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        imgComponent.add(heading);

        add=new JButton("Add Employee");
        add.setBounds(355,270,150,40);
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.addActionListener(this);
        imgComponent.add(add);

        view=new JButton("View Employee");
        view.setBounds(565,270,150,40);
        view.setForeground(Color.white);
        view.setBackground(Color.black);
        view.addActionListener(this);
        imgComponent.add(view);

        rem=new JButton("Remove Employee");
        rem.setBounds(440,370,150,40);
        rem.setForeground(Color.white);
        rem.setBackground(Color.black);
        rem.addActionListener(this);
        imgComponent.add(rem);

        setBounds(250,100,1120,630);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==add){
            new AddEmployee();
            setVisible(false);
        }
        else if (e.getSource()==view) {
            new ViewEmployee();
            setVisible(false);
        }
        else  {
        new RemoveEmployee();
        setVisible(false);
        }
    }

}
