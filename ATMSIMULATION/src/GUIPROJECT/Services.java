package GUIPROJECT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUIPROJECT.Main.txtFirstName;


public class Services extends JFrame implements ActionListener {

    private static float accountBalance = 10000;
    private static float balanceAfterWithdrawal;
    private static float balanceAfterDeposit;
    private JButton btnDeposit, btnWithdraw, btnCheckBalance, btnExit;

    public Services() throws HeadlessException {
        //Services frame specs
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setTitle("ATM Services");
        setLayout(null);

        //adding JComponents onto the JFrame
        btnDeposit= new JButton("Deposit");
        btnDeposit.setBounds(50,50,100,30);
        add(btnDeposit);

        btnWithdraw= new JButton("Withdraw");
        btnWithdraw.setBounds(160,50,100,30);
        add(btnWithdraw);

        btnCheckBalance= new JButton("Check Balance");
        btnCheckBalance.setBounds(50,100,200,30);
        add(btnCheckBalance);


        btnExit= new JButton("Exit");
        btnExit.setBounds(50,200,200,40);
        add(btnExit);

        //Ope-rationalising Services Frame
        btnExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnDeposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deposit();
            }
        });
        btnWithdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdraw();
            }
        });

        
        btnCheckBalance.addActionListener(this);
        
    }
    //deposit method
    public static void deposit(){

        int deposit= Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the Amount you wish to Deposit"));
        JOptionPane.showMessageDialog(null,txtFirstName.getText() + ", You have deposited KSh(s): " + deposit + " into your account");
        balanceAfterDeposit = accountBalance + deposit;
        JOptionPane.showMessageDialog(null,txtFirstName.getText()+ ", Your new account balance is KSh(s): " + balanceAfterDeposit );
        int x = JOptionPane.showConfirmDialog(null,"Do you wish to terminate the process");

        if (x==0){
            JOptionPane.showMessageDialog(null,"Thank you for choosing MMU Bank ATM");
            System.exit(0);
        } else if (x==1) {
            new Services();
        }
    }

    //withdraw method
    public static void withdraw(){
        float withdrawal = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the Amount you wish to withdraw"));
        JOptionPane.showMessageDialog(null,txtFirstName.getText() +  ", You have withdrawn KSh(s): " + withdrawal + " from your account");
        balanceAfterWithdrawal = accountBalance - withdrawal;
        if(withdrawal < 10000) {
            JOptionPane.showMessageDialog(null, txtFirstName.getText() + ", Your Account Balance is KSh(s): " + balanceAfterWithdrawal);
        }
        else {
            JOptionPane.showMessageDialog(null, "Insufficient Account Balance to withdraw.");
        }
        int x = JOptionPane.showConfirmDialog(null,"Do you wish to terminate the process");

        if (x==0){
            JOptionPane.showMessageDialog(null,"Thank you for choosing MMU Bank ATM");
            System.exit(0);
        } else if (x==1) {
            new Services();
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btnCheckBalance){
                JOptionPane.showMessageDialog(null, txtFirstName.getText() + "Your Account Balance is KSh(s): " + accountBalance);
            }
    }
    public static void checkBalanceAfterWithdrawal(){
        JOptionPane.showMessageDialog(null, txtFirstName.getText() + ", Your new Account Balance is KSh(s): " + balanceAfterWithdrawal);


    }

    public static void checkBalanceAfterDeposit(){
        JOptionPane.showMessageDialog(null, txtFirstName.getText()  + ", Your new Account Balance is KSh(s): " + balanceAfterDeposit);


    }

}