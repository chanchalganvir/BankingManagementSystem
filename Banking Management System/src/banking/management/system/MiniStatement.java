package banking.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class MiniStatement extends JFrame implements ActionListener {
    
    MiniStatement(String pinnumber){
        
       setTitle("Mini Statement");
       
       setLayout(null);
       
       setSize(500,700);
       setLocation(40,40);
       getContentPane().setBackground(Color.WHITE);
       //setUndecorated(true);
       setVisible(true);
       
       
        JLabel mini = new JLabel();
        mini.setBounds(20,140,500,200);
        add(mini);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+ rs.getString("cardnumber").substring(0,4)+ "xxxxxxxx" + rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){ 
            System.out.println(e);
        }
        
        
        try{
            Conn conn = new Conn();
            int bal = 0;
            
            ResultSet rs = conn.s.executeQuery("select * from bank where pin =  '"+pinnumber+"' ");

             while(rs.next()){
                 mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount") +"<br><br><html>");
                 
                 if(rs.getString("type").equals("Deposit")){
                        bal += Integer.parseInt(rs.getString("amount"));
                    }else {
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
             }
             
             balance.setText("Your current account balance is Rs "+ bal);
        }catch(Exception e){
            System.out.println(e);
        }
        
       
       
       
       
       
        
        
        
    
    }
    
    
    
    
    
       
        
    
    public void actionPerformed(ActionEvent ae){
    
    }

    public static void main(String args[]) {
        new MiniStatement("").setVisible(true);
    }
}

