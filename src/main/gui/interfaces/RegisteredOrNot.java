package gui.interfaces;

import gui.Button;
import gui.Label;
import gui.StandardFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisteredOrNot {

    RegisteredOrNot() {
        JFrame frame = new StandardFrame("Registered?");
        JLabel label = new Label("Have you registered in the library System?",50,20,300,30);
        JButton yes = new Button("Yes!",50,70,300,40);
        JButton no = new Button("No, I need to register first.",50,120,300,40);

        yes.addActionListener(e -> {
            new BorrowABook("Book Information");
            frame.dispose();

        });

        no.addActionListener(e -> {
            new CustomerRegistration();
            frame.dispose();
        });

        frame.add(label);
        frame.add(yes);
        frame.add(no);


    }
}
