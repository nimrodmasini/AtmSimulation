package JavaGroupProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Services {
    private int balance=0;
    private JFrame jfservices = new JFrame("Services");
    private Button btnwithdraw, btndeposit, btncheckBalance,btnback, btnexit;
    public Services(){
        jfservices.setLayout(null);
        jfservices.setVisible(true);
        jfservices.setSize(400,400);
        btndeposit=new Button("Deposit");
        btndeposit.setBounds(50,50,100,30);
        jfservices.add(btndeposit);
        btnwithdraw=new Button("Withdraw");
        btnwithdraw.setBounds(160,50,100,30);
        jfservices.add(btnwithdraw);
        btncheckBalance=new Button("Check Balance");
        btncheckBalance.setBounds(50,100,100,30);
        jfservices.add(btncheckBalance);
        btnback=new Button("Back");
        btnback.setBounds(160,100,100,30);
        jfservices.add(btnback);
        btnexit=new Button("Exit");
        btnexit.setBounds(50,200,200,40);
        jfservices.add(btnexit);
        btnexit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnback.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                jfservices.dispose();
                new AtmSimulation();
            }
        });
        btndeposit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                deposit();
            }
        });
        btncheckBalance.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
//                checkBalance();
            }
        });
        btnwithdraw.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                withdraw();
            }
        });
    }

    public static void withdraw() {
        int withdrawal = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the Amount you wish to withdraw"));
        JOptionPane.showMessageDialog(null, "You have withdrawn KSh(s): " + withdrawal + " from your account");
        int x = JOptionPane.showConfirmDialog(null, "Do you wish to terminate the process");
        if (x == 0) {
            System.exit(0);
        } else if (x == 1) {
            new Services();
        }
    }

    public static void deposit(){
        int deposit= Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the Amount you wish to Deposit"));
        JOptionPane.showMessageDialog(null,"You have deposited KSh(s): " + deposit + " into your account");
        int x = JOptionPane.showConfirmDialog(null,"Do you wish to terminate the process");
        if (x==0){
            System.exit(0);
        }
        else if (x==1) {
            new Services();
        }
    }
//    public static void checkBalance(){
//        JOptionPane.showMessageDialog(null,"Dear customer,your account balance is KSh(s): " +  balance + ".");
//    }

    public static void main(String[] P){
        new Services();
    }

}
