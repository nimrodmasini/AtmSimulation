package GUIPROJECT;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener{
    private JLabel lblFirstName, lblLastName, lblAccountNumber;
    private JTextField txtFirstName,txtLastName,txtAccountNumber;
    private JButton btnOk, btnClear;
    private int pin = 0000;
    private int pinAttempts;

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

        JOptionPane.showMessageDialog(this,"Enter Your PIN number \n You ONLY have three attempts" );
        for(int pinAttempts = 1; pinAttempts <= 3; pinAttempts++){

            pin = Integer.parseInt(JOptionPane.showInputDialog(null,"PIN Capture",JOptionPane.WARNING_MESSAGE));
            if (pin == 0000){
                JOptionPane.showMessageDialog(null,"You entered te correct PIN");
            }
        }
    }


    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnOk){
            btnOk.addActionListener(this);
        }

    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        new Main();
    }
}