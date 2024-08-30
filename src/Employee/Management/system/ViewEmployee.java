package Employee.Management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener {
    Choice choiceEmp;
    JTable table ;
    JButton search1,print,update,back;
    ViewEmployee(){
        getContentPane().setBackground(new Color(255,131,122));
        JLabel search=new JLabel("Search Employee By Employee Id");
        search.setBounds(20,20,350,22);
        search.setFont(new Font("Railway",Font.BOLD,18));
        add(search);

        choiceEmp=new Choice();
        choiceEmp.setBounds(380,20,150,20);
        add(choiceEmp);

        try{
            Conn conn=new Conn();
            ResultSet resultSet =conn.statement.executeQuery("select *from employee");
            while(resultSet.next()){
                choiceEmp.add(resultSet.getString("employeeId"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        table=new JTable();

        try{
            Conn conn1=new Conn();
            ResultSet resultSet1=conn1.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet1));
        }
        catch(Exception E){
            E.printStackTrace();
        }

        JScrollPane jp=new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);


        search1 =new JButton("Serach");
        search1.setBounds(20,70,80,20);
        search1.addActionListener(this);
        add(search1);


        print =new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        update =new JButton("update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        back =new JButton("Back");
        back.setBounds(320,70,80,20);
        back .addActionListener(this);
        add(back);


        setBounds(300,100,900,700);
        setLayout(null);
        setVisible(true);
    }
    Conn conn=new Conn();
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search1){
            try{

                ResultSet res=conn.statement.executeQuery("select * from employee where employeeId='"+choiceEmp.getSelectedItem()+"'");
                table.setModel(DbUtils.resultSetToTableModel(res));
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
        else if(ae.getSource()==print){
            try{
                table.print();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new UpdateEmployee(choiceEmp.getSelectedItem());
            //conn.statement.executeUpdate("insert into employee")
        }
        else{
            setVisible(false);
            new MainClass();
        }
    }

}
