package GUIPROJECT;

import javax.swing.*;
import static GUIPROJECT.Main.txtFirstName;

public class Menus {
    public Menus() {
        System.out.println("Menu Constructor");
    }

    public void entryMenu(){

        JOptionPane.showMessageDialog(null,"Hello Customer, Welcome to MMU's Bank ATM");
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

}
