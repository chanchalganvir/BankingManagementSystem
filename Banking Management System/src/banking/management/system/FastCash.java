package banking.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;




public class FastCash extends  JFrame implements ActionListener{
    
    JButton deposit, withdrawl, fastcash2, fastcash3, fastcash, fastcash4, exit;
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,-50,900,900);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210,330,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Rs 100");
        deposit.setBounds(170,410,150,22);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(355,410,150,22);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170,439,150,22);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        fastcash2 = new JButton("Rs 2000");
        fastcash2.setBounds(355,439,150,22);
        fastcash2.addActionListener(this);
        image.add(fastcash2);
        
        fastcash3 = new JButton("Rs 5000");
        fastcash3.setBounds(170,466,150,22);
        fastcash3.addActionListener(this);
        image.add(fastcash3);
        
        fastcash4 = new JButton("Rs 10000");
        fastcash4.setBounds(355,466,150,22);
        fastcash4.addActionListener(this);
        image.add(fastcash4);
        
        
        exit = new JButton("BACK");
        exit.setBounds(355,492,150,22);
        exit.addActionListener(this);
        image.add(exit);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);//Rs 500
            Conn c = new Conn();
            try{
                ResultSet rs =  c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"', 'Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs"+ amount + " Debited Successfully");
                
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
            
            
        }
    }

    public static void main(String args[]) {
        new FastCash("");
    }
}
