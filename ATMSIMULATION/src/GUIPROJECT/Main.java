package GUIPROJECT;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class Main extends JFrame implements ActionListener{
    private JLabel lblFirstName, lblLastName, lblAccountNumber;
    private JTextField txtFirstName,txtLastName,txtAccountNumber;
    private JButton btnOk, btnClear;
    private int pin = 0000;
    private int pinAttempts = 3;

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getPinAttempts() {
        return pinAttempts;
    }

    public void setPinAttempts(int pinAttempts) {
        this.pinAttempts = pinAttempts;
    }

    public Main() {
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,200);
        setTitle("Account Details Capture");
        setLayout(new FlowLayout());

        JOptionPane.showMessageDialog(null,"Hello Customer, Welcome to MMU's Bank ATM");

        lblFirstName = new JLabel("Firstname: ");
        add(lblFirstName);
        txtFirstName = new JTextField(20);
        add(txtFirstName);

        lblLastName = new JLabel("Lastname: ");
        add(lblLastName);
        txtLastName = new JTextField(20);
        add(txtLastName);

        lblAccountNumber = new JLabel("Account Number: ");
        add(lblAccountNumber);
        txtAccountNumber = new JTextField(20);
        add(txtAccountNumber);

        btnOk = new JButton("OK");
        add(btnOk);
        btnClear = new JButton("Clear");
        add(btnClear);

        btnClear.addActionListener(this);
        btnOk.addActionListener(this);
    }

    public void authentication(){

        Scanner input = new Scanner(System.in);
        while ((pinAttempts>=3) || (pinAttempts!=0)){
            pinAttempts--;
            JOptionPane.showMessageDialog(this,"Enter Your PIN number \n You ONLY have three attempts" );
            pin = Integer.parseInt(JOptionPane.showInputDialog(null,"PIN Capture",JOptionPane.WARNING_MESSAGE));

            if (pin == 0000) {
                break;
            }
            else {
                JOptionPane.showMessageDialog(null,"Incorrect PIN," + pinAttempts+" attempts remaining");

            }
        }
        if (pinAttempts==0){
            JOptionPane.showMessageDialog(null,"You entered 3 wrong PINs in a row,\nYour Account is locked" );

        }

    }
    public static void deposit(){

        int deposit= Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the Amount you wish to Deposit"));
        JOptionPane.showMessageDialog(null,"You have deposited KSh(s): " + deposit + " into your account");
        int x = JOptionPane.showConfirmDialog(null,"Do you wish to terminate the process");

        if (x==0){
            JOptionPane.showMessageDialog(null,"Thank you for choosing MMU Bank ATM");
            System.exit(0);
        } else if (x==1) {
            Main option = new Main();
            option.afterEntryMenu();
        }
    }

    public static void withdraw(){
        int withdrawal = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the Amount you wish to withdraw"));
        JOptionPane.showMessageDialog(null,"You have withdrawn KSh(s): " + withdrawal + " from your account");
        int x = JOptionPane.showConfirmDialog(null,"Do you wish to terminate the process");

        if (x==0){
            JOptionPane.showMessageDialog(null,"Thank you for choosing MMU Bank ATM");
            System.exit(0);
        } else if (x==1) {
            Main option = new Main();
            option.afterEntryMenu();
        }

    }

    public void afterEntryMenu(){
        JOptionPane.showMessageDialog(null, "Select an Option to continue; \n 1.Deposit\n 2.Withdraw");
        int option =Integer.parseInt(JOptionPane.showInputDialog(null,txtFirstName.getText() + " write 1 for Deposit or 2 for withdrawal"));
        if(option == 1){
           Main options = new Main();
           options.deposit();

        } else if (option == 2) {
            Main options = new Main();
            options.withdraw();

        }
    }


    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnClear){
            txtFirstName.setText("Cleared");
            txtLastName.setText("Cleared");
            txtAccountNumber.setText("Cleared");
        }
        if(e.getSource() == btnOk){
            Main Authentication = new Main();
            Authentication.authentication();
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Main();
        Main options = new Main();
        options.afterEntryMenu();

    }
}