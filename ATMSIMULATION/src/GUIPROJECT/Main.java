package GUIPROJECT;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static GUIPROJECT.Authentication.authentication;


public class Main extends JFrame implements ActionListener{
    //Main Menu frame specs
    private JMenuBar  menuBar = new JMenuBar();
    private JMenu menuHelp = new JMenu("Help");
    private JMenuItem navigationHelp = new JMenuItem("Nav Help");
    protected static JLabel lblFirstName;
    protected static JLabel lblLastName;
    protected JLabel lblAccountNumber;
    protected static JTextField txtFirstName;
    protected static JTextField txtLastName;
    protected JTextField txtAccountNumber;
    private JButton btnOk, btnClear;
    //default PIN
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
        System.out.println("Main constructor");

    }
    public void userDetails(){
        setJMenuBar(menuBar);
        menuBar.add(menuHelp);
        menuHelp.add(navigationHelp);
        navigationHelp.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,400);
        setTitle("Account Details Capture");
        setLayout(null);



        lblFirstName = new JLabel("Firstname: ");
        lblFirstName.setBounds(50,40,70,25);
        add(lblFirstName);
        txtFirstName = new JTextField(20);
        txtFirstName.setBounds(185,40,170,25);
        add(txtFirstName);

        lblLastName = new JLabel("Lastname: ");
        lblLastName.setBounds(50,80,70,25);
        add(lblLastName);
        txtLastName = new JTextField();
        txtLastName.setBounds(185,80,170,25);
        add(txtLastName);

        lblAccountNumber = new JLabel("Account Number: ");
        lblAccountNumber.setBounds(50,120,107,25);
        add(lblAccountNumber);
        txtAccountNumber = new JTextField(20);
        txtAccountNumber.setBounds(185,120,170,25);
        add(txtAccountNumber);

        btnOk = new JButton("OK");
        btnOk.setBounds(110,190,75,25);
        add(btnOk);

        btnClear = new JButton("Clear");
        btnClear.setBounds(185,190,75,25);
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






    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnClear){
            txtFirstName.setText("Cleared");
            txtLastName.setText("Cleared");
            txtAccountNumber.setText("Cleared");
        }
        if(e.getSource() == navigationHelp){
            JOptionPane.showMessageDialog(null,"On this window you're supposed to enter: \n 1. First and Last Name \n 2.Account Number \n  or \n use the link www.MMUBank.ac.ke/help");
        }

    }

       public static void main(String[] args) {
        Menus menu = new Menus();
        menu.entryMenu();
        Main userInterface = new Main();
        userInterface.userDetails();


    }
}