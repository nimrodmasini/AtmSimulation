package GUIPROJECT;

import javax.swing.*;



public class Authentication{
    private JMenuBar menuBar = new JMenuBar();
    private static JMenu menuEdit = new JMenu("Edit");
    private static JMenu menuHelp = new JMenu("Help");
    private static int pin = 0000;
    private static int pinAttempts = 3;

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public static JMenu getMenuEdit() {
        return menuEdit;
    }

    public static void setMenuEdit(JMenu menuEdit) {
        Authentication.menuEdit = menuEdit;
    }

    public static JMenu getMenuHelp() {
        return menuHelp;
    }

    public static void setMenuHelp(JMenu menuHelp) {
        Authentication.menuHelp = menuHelp;
    }

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



    public static void authentication(){

        JOptionPane.showMessageDialog(null,"Enter Your PIN number \n You ONLY have three attempts" );
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


}
