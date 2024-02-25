package banking.management.system;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, occupation, education, income;
    String formno;
    

   SignupTwo(String formno) {
       this.formno = formno;
       setLayout(null);
       
       setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
       
       JLabel additionalDetails = new JLabel("Page 2: Additional Details");
       additionalDetails.setFont(new Font("Raleway", Font.BOLD,22));
       additionalDetails.setBounds(290,80,400,30);
       add(additionalDetails);
       
       JLabel re = new JLabel("Religion:");
       re.setFont(new Font("Raleway", Font.BOLD,20));
       re.setBounds(100,140,100,30);
       add(re);
       
       String valReligion[] = {"","Buddhist", "Hindu", "Muslim", "Sikh", "Cristian", "Other"};
       religion = new JComboBox(valReligion);
       religion.setBounds(300,140,400,30);
       religion.setBackground(Color.WHITE);
       add(religion);
       
      
       
       JLabel ca = new JLabel("Categary:");
       ca.setFont(new Font("Raleway", Font.BOLD,20));
       ca.setBounds(100,190,200,30);
       add(ca);
       
       String valcategory[] = {"","SC", "ST", "OBC", "General", "others"};
       category = new JComboBox(valcategory);
       category.setBounds(300,190,400,30);
       category.setBackground(Color.WHITE);
       add(category);
       
       JLabel in = new JLabel("Income:");
       in.setFont(new Font("Raleway", Font.BOLD,20));
       in.setBounds(100,240,200,30);
       add(in);
       
       String incomecategory[] = {"NULL","< 1,50,000", "<2,50,000", "<5,00,000", "upto 10,00,000", ">10,00,000"};
       income = new JComboBox(incomecategory);
       income.setBounds(300,240,400,30);
       income.setBackground(Color.WHITE);
       add(income);
       
       
       
       JLabel ed = new JLabel("Educational");
       ed.setFont(new Font("Raleway", Font.BOLD,20));
       ed.setBounds(100,290,200,30);
       add(ed);
       
       
       JLabel qu = new JLabel("Qualification:");
       qu.setFont(new Font("Raleway", Font.BOLD,20));
       qu.setBounds(100,315,200,30);
       add(qu);
       
       String educationvalues[] = {"Non Graduate","Graduate", "Post Graduation", "Doctrate", "MBA", "Others"};
       education = new JComboBox(educationvalues);
       education.setBounds(300,315,400,30);
       education.setBackground(Color.WHITE);
       add(education);
       
       
       JLabel oc = new JLabel("Occupation:");
       oc.setFont(new Font("Raleway", Font.BOLD,20));
       oc.setBounds(100,390,200,30);
       add(oc);
       
       String occupationvalues[] = {"Salaried","Self-Employed", "Bussiness", "Student", "Retired", "Others"};
       occupation = new JComboBox(occupationvalues);
       occupation.setBounds(300,390,400,30);
       occupation.setBackground(Color.WHITE);
       add(occupation);
       
      
       JLabel pn = new JLabel("Pan Number:");
       pn.setFont(new Font("Raleway", Font.BOLD,20));
       pn.setBounds(100,440,200,30);
       add(pn);
       
       pan = new JTextField();
       pan.setFont(new Font("Raleway", Font.BOLD, 14));
       pan.setBounds(300,440,400,30);
       add(pan);
       
       JLabel ad = new JLabel("Adhar Number:");
       ad.setFont(new Font("Raleway", Font.BOLD,20));
       ad.setBounds(100,490,200,30);
       add(ad);
       
       aadhar = new JTextField();
       aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
       aadhar.setBounds(300,490,400,30);
       add(aadhar);
       
       JLabel sc = new JLabel("Senior Citizen:");
       sc.setFont(new Font("Raleway", Font.BOLD,20));
       sc.setBounds(100,540,200,30);
       add(sc);
       
       syes = new JRadioButton("Yes");
       syes.setBounds(300,540,100,30);
       syes.setBackground(Color.WHITE);
       add(syes);
       
       sno = new JRadioButton("No");
       sno.setBounds(450,540,100,30);
       sno.setBackground(Color.WHITE);
       add(sno);
       
       ButtonGroup sgroup = new ButtonGroup();
       sgroup.add(syes);
       sgroup.add(sno);
       
       
       JLabel ea = new JLabel("Existing Account:");
       ea.setFont(new Font("Raleway", Font.BOLD,20));
       ea.setBounds(100,590,200,30);
       add(ea);
       
       eyes = new JRadioButton("Yes");
       eyes.setBounds(300,590,100,30);
       eyes.setBackground(Color.WHITE);
       add(eyes);
       
       eno = new JRadioButton("No");
       eno.setBounds(450,590,100,30);
       eno.setBackground(Color.WHITE);
       add(eno);
       
       ButtonGroup egroup = new ButtonGroup();
       egroup.add(eyes);
       egroup.add(eno);
       
       next = new JButton("Next");
       next.setBackground(Color.BLACK);
       next.setForeground(Color.WHITE);
       next.setFont(new Font("Raleway", Font.BOLD,14));
       next.setBounds(620,625,77,30);
       next.addActionListener(this);
       add(next);
       
       
       getContentPane().setBackground(Color.WHITE);
       
       setSize(850,800);
       setLocation(100,5);
       setVisible(true);
       
   }
   
   public void actionPerformed(ActionEvent ae){
       String sreligion =(String)religion.getSelectedItem();
       String scategory = (String)category.getSelectedItem();
       String sincome = (String)income.getSelectedItem();
       String seducation = (String)education.getSelectedItem();
       String soccupation = (String)occupation.getSelectedItem();
       
       String span = pan.getText();
       String saadhar = aadhar.getText();
       
       
       String seniorcitizen = "";
       if(syes.isSelected()){
           seniorcitizen = "Yes";
       } else if(sno.isSelected()){
           seniorcitizen = "No";
       }
       
       
       
       String existingaccount = "";
       if(eyes.isSelected()){
           existingaccount = "Yes";
       } else if (eno.isSelected()){
           existingaccount = "No";
       } 
       
       

       
       try{
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
            c.s.executeUpdate(query);
           
            //Signup3 object
            setVisible(false);
            new SignupThree(formno).setVisible(true);
       }catch(Exception e){
           System.out.println(e);
       }
   }

    public static void main(String args[]) {
        new SignupTwo("");
    }
}

