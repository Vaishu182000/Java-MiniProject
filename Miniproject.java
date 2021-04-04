/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
public class Miniproject{
    JFrame f;
    JPanel p1,p2,p3,p4;
    JTabbedPane tp;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l,l11,l12,emp1,emp2,emp3,emp4,emp5,emp6,name,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,ll1,ll2,ll3,ll4,ll5,cn,cp,ca,ce,cg,cd,f1,f2,f3,f4,f5,f6;
    JComboBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,d1,d2,d3;
    JTextField t1,tt1,t2,ta,cusname,cusphone,cusemail,feedname,feedemail,feedphone;
    JCheckBox agree;
    JRadioButton r1,r2;
    ButtonGroup bg;
    JTextArea cusadd,feedmsg;
    JButton b1,bb1,sub,feed;
    Miniproject(){
        f=new JFrame("Billing System");
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();
        p1.setLayout(new GridLayout(15,3));
        p2.setLayout(new GridLayout(14,2));
        p3.setLayout(null);
        p4.setLayout(null);
        ll1=new JLabel("Enter User Name To Get there Purchase Details :");
        ll2=new JLabel();
        ll3=new JLabel();
        ll4=new JLabel();
        ll5=new JLabel();
        tt1=new JTextField();
        bb1=new JButton("G0");
        p2.add(ll1);
        p2.add(tt1);
        p2.add(bb1);
        p2.add(ll2);
        p2.add(ll3);
        p2.add(ll4);
        p2.add(ll5);
        tp=new JTabbedPane();
        l=new JLabel("Products Available");
        emp1=new JLabel("");
        emp2=new JLabel("");
        emp3=new JLabel("");
        emp4=new JLabel("Amount");
        emp5=new JLabel("");
        emp6=new JLabel("");
        String num[]={"0","1","2","3","4","5","6","7","8","9","10"};
        name=new JLabel("Enter Name:");
        l11=new JLabel("Phone Number :");
        l12=new JLabel("Address");
        ta=new JTextField();
        t2=new JTextField();
        t1=new JTextField();
        cb1=new JComboBox(num);
        cb2=new JComboBox(num);
        cb3=new JComboBox(num);
        cb4=new JComboBox(num);
        cb5=new JComboBox(num);
        cb6=new JComboBox(num);
        cb7=new JComboBox(num);
        cb8=new JComboBox(num);
        cb9=new JComboBox(num);
        cb10=new JComboBox(num);
        //cb1.setBounds(5,5,9,2);
        l1=new JLabel("Rice");
        l2=new JLabel("Chocolate");
        l3=new JLabel("Biscuits");
        l4=new JLabel("Dhal");
        l5=new JLabel("Sugar");
        l6=new JLabel("Tea");
        l7=new JLabel("Coffee");
        l8=new JLabel("Water");
        l9=new JLabel("Milk");
        l10=new JLabel("Soap"); 
        a1=new JLabel("Rs.50");
        a2=new JLabel("Rs.10");
        a3=new JLabel("Rs.20");
        a4=new JLabel("Rs.45");
        a5=new JLabel("Rs.55");
        a6=new JLabel("Rs.25");
        a7=new JLabel("Rs.60");
        a8=new JLabel("Rs.15");
        a9=new JLabel("Rs.25");
        a10=new JLabel("Rs.27");
        b1=new JButton("Place Order");
        b1.setToolTipText("Press to Place Order");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String msg="Your Order has been Placed\n";
                String user=t1.getText();
                String ph=t2.getText();
                String add=ta.getText();
                float amount=0; 
                msg+="Name :"+user+"\nOrders Placed are\n";
                int c1=Integer.parseInt((String) cb1.getItemAt(cb1.getSelectedIndex()));
                int c2=Integer.parseInt((String) cb2.getItemAt(cb2.getSelectedIndex()));
                int c3=Integer.parseInt((String) cb3.getItemAt(cb3.getSelectedIndex()));
                int c4=Integer.parseInt((String) cb4.getItemAt(cb4.getSelectedIndex()));
                int c5=Integer.parseInt((String) cb5.getItemAt(cb5.getSelectedIndex()));
                int c6=Integer.parseInt((String) cb6.getItemAt(cb6.getSelectedIndex()));
                int c7=Integer.parseInt((String) cb7.getItemAt(cb7.getSelectedIndex()));
                int c8=Integer.parseInt((String) cb8.getItemAt(cb8.getSelectedIndex()));
                int c9=Integer.parseInt((String) cb9.getItemAt(cb9.getSelectedIndex()));
                int c10=Integer.parseInt((String) cb10.getItemAt(cb10.getSelectedIndex()));
                if(c1>=1){
                msg+="Rice :" + cb1.getItemAt(cb1.getSelectedIndex());
                amount+=50*c1;
                }
                if(c2>=1){
                msg+="\nChocolate :"+cb2.getItemAt(cb2.getSelectedIndex());
                amount+=10*c2;
                }
                if(c3>=1){
                msg+="\nBiscuits :"+cb3.getItemAt(cb3.getSelectedIndex());
                amount+=20*c3;
                }
                if(c4>=1){
                msg+="\nDhal :"+cb4.getItemAt(cb4.getSelectedIndex());
                amount+=45*c4;
                }
                if(c5>=1){
                msg+="\nSugar :"+cb5.getItemAt(cb5.getSelectedIndex());
                amount+=55*c5;
                }
                if(c6>=1){
                msg+="\nTea :"+cb6.getItemAt(cb6.getSelectedIndex());
                amount+=25*c6;
                }
                if(c7>=1){
                msg+="\nCoffee :"+cb7.getItemAt(cb7.getSelectedIndex());
                amount+=60*c7;
                }
                if(c8>=1){
                msg+="\nWater :"+cb8.getItemAt(cb8.getSelectedIndex());
                amount+=15*c8;
                }
                if(c9>=1){
                msg+="\nMilk :"+cb9.getItemAt(cb9.getSelectedIndex());
                amount+=25*c9;
                }
                if(c10>=1){
                msg+="\nSoap :"+cb10.getItemAt(cb10.getSelectedIndex());
                amount+=27*c10;
                }
                msg+="\nTotal Amount :"+amount;
                JOptionPane.showMessageDialog(p1,msg);
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String connectString="jdbc:mysql://localhost:3306/vaishnavi?zeroDateTimeBehavior=convertToNull";
                    Connection conn =DriverManager.getConnection(connectString,"Vaishnavi", "Vaish2000*");
                    Statement stmt=conn.createStatement();
                    String q="insert into details values('"+user+"','"+ph+"','"+add+"',"+c1+","+c2+","+c3+","+c4+","+c5+","+c6+","+c7+","+c8+","+c9+","+c10+","+amount+")";
                    stmt.executeUpdate(q);
                    conn.close();
                } 
                catch(Exception e1){
                    System.out.println("Error : "+e1.getMessage());
                }
                    
                t1.setText("");
                t2.setText("");
                ta.setText("");
                cb1.setSelectedIndex(0);
                cb2.setSelectedIndex(0);
                cb3.setSelectedIndex(0);
                cb4.setSelectedIndex(0);
                cb5.setSelectedIndex(0);
                cb6.setSelectedIndex(0);
                cb7.setSelectedIndex(0);
                cb8.setSelectedIndex(0);
                cb9.setSelectedIndex(0);
                cb10.setSelectedIndex(0);
            }
        });
        bb1.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            String name=tt1.getText();  
            try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String connectString="jdbc:mysql://localhost:3306/vaishnavi?zeroDateTimeBehavior=convertToNull";
                    Connection conn =DriverManager.getConnection(connectString,"Vaishnavi", "Vaish2000*");
                    Statement stmt=conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM details where Name='"+name+"'");
                    if(rs.next()){
                        float id = rs.getInt("amount");
                        String name1 = rs.getString("name");
                        String phone=rs.getString("Phone");
                        String add=rs.getString("Address");
                        String msg="User Name : "+name1;
                        String msg1="Phone Number : "+phone;
                        String msg2="Address : "+add;
                        String msg3="Total Amount : "+String.valueOf(id);
                        //JOptionPane.showMessageDialog(p2,msg);
                        ll2.setText(msg);
                        ll3.setText(msg1);
                        ll4.setText(msg2);
                        ll5.setText(msg3);
                    }
                    else{
                        System.out.println("False");
                    }
                    conn.close();
                    tt1.setText("");
                } 
                catch(Exception e1){
                    System.out.println("Error : "+e1.getMessage());
                }
        }  
    });  
        p1.add(name);
        p1.add(t1);
        p1.add(emp3);
        p1.add(l11);
        p1.add(t2);
        p1.add(emp5);
        p1.add(l12);
        p1.add(ta);
        p1.add(emp6);
        p1.add(l);
        p1.add(emp4);
        p1.add(emp1);
        p1.add(l1);
        p1.add(a1);
        p1.add(cb1);
        p1.add(l2);
        p1.add(a2);
        p1.add(cb2);
        p1.add(l3);
        p1.add(a3);
        p1.add(cb3);
        p1.add(l4);
        p1.add(a4);
        p1.add(cb4);
        p1.add(l5);
        p1.add(a5);
        p1.add(cb5);
        p1.add(l6);
        p1.add(a6);
        p1.add(cb6);
        p1.add(l7);
        p1.add(a7);
        p1.add(cb7);
        p1.add(l8);
        p1.add(a8);
        p1.add(cb8);
        p1.add(l9);
        p1.add(a9);
        p1.add(cb9);
        p1.add(l10);
        p1.add(a10);
        p1.add(cb10);
        p1.add(emp2);
        p1.add(b1);
        cn=new JLabel("Name");
        cn.setBounds(0,0,50,50);
        cp=new JLabel("Phone");
        cp.setBounds(0,35,50,50);
        ca=new JLabel("Address");
        ca.setBounds(0,75,50,50);
        ce=new JLabel("Email");
        ce.setBounds(0,130,50,50);
        cg=new JLabel("Gender");
        cg.setBounds(0,175,50,50);
        cd=new JLabel("Date-Of-Birth");
        cd.setBounds(0,230,100,50);
        cusname=new JTextField();
        cusname.setBounds(135,10,200,35);
        cusphone=new JTextField();
        cusphone.setBounds(135,45,200,35);
        cusemail=new JTextField();
        cusemail.setBounds(135,140,200,35);
        r1=new JRadioButton("Male",true);
        r1.setBounds(135,180,200,35);
        r2=new JRadioButton("Female");
        r2.setBounds(135,210,200,35);
        bg=new ButtonGroup();
        cusadd=new JTextArea();
        cusadd.setBounds(135,80,200,50);
        String day[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String month[]={"January","Febuary","March","April","May","June","July","August","September","October","November","December"};
        String year[]={"1990","1991","1992","1993","1994","1995","1996","1997","1998","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018"};
        d1=new JComboBox(day);
        d1.setBounds(135,245,50,35);
        d2=new JComboBox(month);
        d2.setBounds(190,245,75,35);
        d3=new JComboBox(year);
        d3.setBounds(270,245,60,35);
        agree=new JCheckBox("I accept the above details are true");
        agree.setBounds(50,290,250,35);
        sub=new JButton("Submit");
        sub.setBounds(50,350,250,35);
        sub.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String name=cusname.getText();
                String phone=cusphone.getText();
                String mail=cusemail.getText();
                String address=cusadd.getText();
                String gen;
                if(r1.isSelected()){
                    gen="Male";
                }
                else{
                    gen="Female";
                }
                String day=(String) d1.getItemAt(d1.getSelectedIndex());
                String month=(String) d2.getItemAt(d2.getSelectedIndex());
                String year=(String) d3.getItemAt(d3.getSelectedIndex());
                String dob=day+" "+month+" "+year;
                JOptionPane.showMessageDialog(p1,"Details Entered");
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String connectString="jdbc:mysql://localhost:3306/vaishnavi?zeroDateTimeBehavior=convertToNull";
                    Connection conn =DriverManager.getConnection(connectString,"Vaishnavi", "Vaish2000*");
                    Statement stmt=conn.createStatement();
                    String q="insert into customerdetails values('"+name+"','"+phone+"','"+mail+"','"+address+"','"+gen+"','"+dob+"')";
                    stmt.executeUpdate(q);
                    conn.close();
                } 
                catch(Exception e1){
                    System.out.println("Error : "+e1.getMessage());
                }
                cusname.setText("");
                cusphone.setText("");
                cusemail.setText("");
                cusadd.setText("");
                agree.setSelected(false);
                r1.setSelected(true);
                d1.setSelectedIndex(0);
                d2.setSelectedIndex(0);
                d3.setSelectedIndex(0);
        }  
    });  
        bg.add(r1);
        bg.add(r2);
        p3.add(cn);
        p3.add(cusname);
        p3.add(cp);
        p3.add(cusphone);
        p3.add(ca);
        p3.add(cusadd);
        p3.add(ce);
        p3.add(cusemail);
        p3.add(cg);
        p3.add(r1);
        p3.add(r2);
        p3.add(cd);
        p3.add(d1);
        p3.add(d2);
        p3.add(d3);
        p3.add(agree);
        p3.add(sub);
        f1=new JLabel("FeedBack Form");
        f1.setBounds(135,10,250,35);
        f2=new JLabel("Name");
        f2.setBounds(10,60,200,35);
        f3=new JLabel("Phone Number");
        f3.setBounds(10,120,200,35);
        f4=new JLabel("Email");
        f4.setBounds(10,180,200,35);
        f5=new JLabel("Feedback");
        f5.setBounds(10,260,200,35);
        f6=new JLabel();
        f6.setBounds(115,420,150,35);
        feedname=new JTextField();
        feedname.setBounds(115,60,200,35);
        feedphone=new JTextField();
        feedphone.setBounds(115,120,200,35);
        feedemail=new JTextField();
        feedemail.setBounds(115,180,200,35);
        feedmsg=new JTextArea();
        feedmsg.setBounds(115,240,200,100);
        feed=new JButton("Submit");
        feed.setBounds(90,370,150,35);
         feed.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                  String name=feedname.getText();
                  String phone=feedphone.getText();
                  String mail=feedemail.getText();
                  String msg=feedmsg.getText();
                  f6.setText("FeedBack Recived");
                  try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String connectString="jdbc:mysql://localhost:3306/vaishnavi?zeroDateTimeBehavior=convertToNull";
                    Connection conn =DriverManager.getConnection(connectString,"Vaishnavi", "Vaish2000*");
                    Statement stmt=conn.createStatement();
                    String q="insert into Feedback values('"+name+"','"+phone+"','"+mail+"','"+msg+"')";
                    stmt.executeUpdate(q);
                    conn.close();
                } 
                catch(Exception e1){
                    System.out.println("Error : "+e1.getMessage());
                }
        }  
    });  
        p4.add(f1);
        p4.add(f2);
        p4.add(feedname);
        p4.add(f3);
        p4.add(feedphone);
        p4.add(f4);
        p4.add(feedemail);
        p4.add(f5);
        p4.add(feedmsg);
        p4.add(feed);
        p4.add(f6);
        tp.add("Registration",p3);
        tp.add("Order",p1);
        tp.add("Details",p2);
        tp.add("FeedBack",p4);
        tp.setBounds(0,0,350,600);
        f.add(tp);  
        f.setSize(400,700);  
        f.setLayout(null);  
        f.setVisible(true);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Miniproject();
    }
}
