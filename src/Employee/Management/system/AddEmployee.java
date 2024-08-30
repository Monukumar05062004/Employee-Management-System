package Employee.Management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class AddEmployee extends JFrame implements ActionListener {

    Random random=new Random();
    long number=random.nextLong(9999);
    JButton Back,Add;

    JComboBox BoxEducation;
    JDateChooser dateChooser;
    JLabel JEId;
    JTextField tName,tFName,tAddress,tPhone,tAadhaar,tEmail,tSalary,tDesignation;
    AddEmployee(){
        getContentPane().setBackground(new Color(163,255,188));
        JLabel heading=new JLabel("Add Employee Detail");
        heading.setBounds(250,30,500,50);
        heading.setFont(new Font("Railways",Font.ROMAN_BASELINE,40));
        add(heading);

        JLabel name=new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        tName=new JTextField();
        tName.setBounds(200,150,150,30);
        tName.setBackground(new Color(177,252,197));
        add(tName);

        JLabel JLFName=new JLabel("Father's Name");
        JLFName.setBounds(400,150,150,30);
        JLFName.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(JLFName);

        tFName=new JTextField();
        tFName.setBounds(600,150,150,30);
        tFName.setBackground(new Color(177,252,197));
        add(tFName);

        JLabel JLDob=new JLabel("Date Of Birth");
        JLDob.setBounds(50,200,150,30);
        JLDob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(JLDob);

        dateChooser=new JDateChooser();
        dateChooser.setBounds(200,200,150,30);
        dateChooser.setBackground(new Color(177,252,197));
        add(dateChooser);

        JLabel salary=new JLabel("Salary");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(salary);

        tSalary=new JTextField();
        tSalary.setBounds(600,200,150,30);
        tSalary.setBackground(new Color(177,252,197));
        add(tSalary);

        JLabel JLAddress=new JLabel("Address");
        JLAddress.setBounds(50,250,150,30);
        JLAddress.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(JLAddress);

        tAddress=new JTextField();
        tAddress.setBounds(200,250,150,30);
        tAddress.setBackground(new Color(177,252,197));
        add(tAddress);

        JLabel JLPhone=new JLabel("Phone No");
        JLPhone.setBounds(400,250,150,30);
        JLPhone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(JLPhone);

        tPhone=new JTextField();
        tPhone.setBounds(600,250,150,30);
        tPhone.setBackground(new Color(177,252,197));
        add(tPhone);

        JLabel JLEmail=new JLabel("Email");
        JLEmail.setBounds(50,300,150,30);
        JLEmail.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(JLEmail);

        tEmail=new JTextField();
        tEmail.setBounds(200,300,150,30);
        tEmail.setBackground(new Color(177,252,197));
        add(tEmail);


        JLabel JLEducation=new JLabel("Qualification");
        JLEducation.setBounds(400,300,150,30);
        JLEducation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(JLEducation);

        String items[]={"BTech","BCA","MCA","BA","BSC","B.COM","M.TECH","PHD","BBA"};
        BoxEducation=new JComboBox(items);
        BoxEducation.setBounds(600,300,150,30);
        BoxEducation.setBackground(new Color(177,252,197));
        add(BoxEducation);

        JLabel JLAadhaar=new JLabel("Aadhaar No");
        JLAadhaar.setBounds(400,350,150,30);
        JLAadhaar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(JLAadhaar);
        tAadhaar=new JTextField();
        tAadhaar.setBounds(600,350,150,30);
        tAadhaar.setBackground(new Color(177,252,197));
        add(tAadhaar);

        JLabel JLEmployeeId=new JLabel("Employee Id");
        JLEmployeeId.setBounds(50,400,150,30);
        JLEmployeeId.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(JLEmployeeId);
        JEId=new JLabel(""+number);
        JEId.setBounds(200,400,150,30);
        JEId.setForeground(Color.red);
        JEId.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        add(JEId);

        JLabel JLDesignation=new JLabel("Designation");
        JLDesignation.setBounds(50,350,150,30);
        JLDesignation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(JLDesignation);

        tDesignation=new JTextField();
        tDesignation.setBounds(200,350,150,30);
        tDesignation.setBackground(new Color(177,252,197));
        add(tDesignation);

        Add=new JButton("Add");
        Add.setBounds(450,550,150,40);
        Add.setForeground(Color.WHITE);
        Add.setBackground(Color.BLACK);
        Add.addActionListener(this);
        add(Add);

        Back=new JButton("Back");
        Back.setBounds(250,550,150,40);
        Back.setForeground(Color.WHITE);
        Back.setBackground(Color.BLACK);
        Back.addActionListener(this);
        add(Back);

        setBounds(300,50,900,700);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
    if(e.getSource()==Add){
        // tName,tFName,tAddress,tPhone,tAadhaar,tEmail,tSalary,tDesignation
        String name=tName.getText();
        String fatherName=tFName.getText();
        String address=tAddress.getText();
        String phoneNo=tPhone.getText();
        String aadhaar=tAadhaar.getText();
        String email=tEmail.getText();
        String salary=tSalary.getText();
        String designation=tDesignation.getText();
        String employeeId=JEId.getText();
        String dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String education= (String) BoxEducation.getSelectedItem();
        try{
            Conn conn =new Conn();
            String query="insert into employee values('"+name+"','"+fatherName+"','"+address+"','"+phoneNo+"','"+aadhaar+"','"+email+"','"+salary+"','"+designation+"','"+employeeId+"','"+dob+"','"+education+"')";
            conn.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Detail added successfully");
            setVisible(false);
            new MainClass();
        }catch(Exception E){
            E.printStackTrace();
        }
    }
    else{
        setVisible(false);
        new MainClass();
    }
    }

}
