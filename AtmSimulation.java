package JavaGroupProject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AtmSimulation{
    private JFrame frlogin=new JFrame("Log in/Sign up");
    private JLabel lblwelcome, lblusername, lblpassword;
    private JTextField txtname;
    private JPasswordField pwdpass;
    private JButton btnlogin, btnsignup, btnexit;
    public AtmSimulation(){
        lblwelcome = new JLabel("Welcome to ATM");
        lblusername = new JLabel("Username: ");
        lblpassword = new JLabel("Password");
        txtname = new JTextField(30);
        pwdpass = new JPasswordField(20);
        btnlogin = new JButton("Log in");
        btnsignup = new JButton("Sign up");
        btnexit = new JButton("Exit");
        frlogin.setVisible(true);
        frlogin.setSize(400,400);
        frlogin.setLayout(null);
        frlogin.setTitle("Log in/Sign up");

        lblwelcome.setBounds(130,50,100,50);
        frlogin.add(lblwelcome);
        lblusername.setBounds(50,110,100,20);
        frlogin.add(lblusername);
        txtname.setBounds(160,110,100,20);
        frlogin.add(txtname);
        lblpassword.setBounds(50,140,100,20);
        frlogin.add(lblpassword);
        pwdpass.setBounds(160,140,100,20);
        frlogin.add(pwdpass);
        btnlogin.setBounds(30,200,80,20);
        frlogin.add(btnlogin);
        btnsignup.setBounds( 130,200,80,20 );
        frlogin.add(btnsignup);
        btnexit.setBounds(230,200,80,20);
        frlogin.add(btnexit);

        btnexit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        btnlogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frlogin.dispose();
                new Services();
            }
        });
    }
    public static void main(String[] S){
        new AtmSimulation();
    }
}
