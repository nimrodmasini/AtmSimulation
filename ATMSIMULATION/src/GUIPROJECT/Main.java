package GUIPROJECT;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main extends JFrame implements ActionListener{
    //Main Menu frame specs
    private static JLabel lblFirstName;
    private static JLabel lblLastName;
    private JLabel lblAccountNumber;
    private static JTextField txtFirstName;
    private static JTextField txtLastName;
    private JTextField txtAccountNumber;
    private JButton btnOk, btnClear;
    //default PIN
    private int pin = 0000;
    private int pinAttempts = 3;
    Random random = new Random();



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



    public void entryMenu(){
        JOptionPane.showMessageDialog(null,"Hello Customer, Welcome to MMU's Bank ATM");
    }


    public Main() {

    }
    public void userDetails(){
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,400);
        setTitle("Account Details Capture");
        setLayout(new FlowLayout());



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
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authentication();
               setVisible(false);
            }
        });
    }

    public void authentication(){

        JOptionPane.showMessageDialog(this,"Enter Your PIN number \n You ONLY have three attempts" );
        while ((pinAttempts>=3) || (pinAttempts!=0)){
            pinAttempts--;

            pin = Integer.parseInt(JOptionPane.showInputDialog(null,"PIN Capture",JOptionPane.WARNING_MESSAGE));

            if (pin == 0000) {
                new Services();
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

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnClear){
            txtFirstName.setText("Cleared");
            txtLastName.setText("Cleared");
            txtAccountNumber.setText("Cleared");
        }

    }
    public static void afterEntryMenu(){
        JOptionPane.showMessageDialog(null, "Select an Option to continue; \n 1.Deposit\n 2.Withdraw");
        int option =Integer.parseInt(JOptionPane.showInputDialog(null,txtFirstName.getText() + " Write: \n 1. for Deposit \n or \n 2. for withdrawal"));
        if(option == 1){
            Main options = new Main();


        } else if (option == 2) {
            Main options = new Main();


        }
    }

    public static void main(String[] args) {
        Main menu = new Main();
        menu.entryMenu();
        Main userInterface = new Main();
        userInterface.userDetails();


    }
}