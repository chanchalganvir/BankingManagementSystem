package banking.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Transaction extends  JFrame implements ActionListener{
    
    JButton deposit, withdrawl, miniStatement, pinchange, fastcash, balanceenquiry, exit;
    String pinnumber;
    
    Transaction(String pinnumber){
        this.pinnumber = pinnumber;
        
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,-50,900,900);
        add(image);
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(210,330,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170,410,150,22);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,410,150,22);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,439,150,22);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355,439,150,22);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,466,150,22);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355,466,150,22);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        
        exit = new JButton("Exit");
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
            System.exit(0);
        }else if(ae.getSource()== deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()== withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()== fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if(ae.getSource()== pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if(ae.getSource()== balanceenquiry){
            setVisible(false);
            new BalnceEnquiry(pinnumber).setVisible(true);
        } else if(ae.getSource()== miniStatement){
            new MiniStatement(pinnumber).setVisible(true);
        } 
    }

    public static void main(String args[]) {
        new Transaction("");
    }
}
