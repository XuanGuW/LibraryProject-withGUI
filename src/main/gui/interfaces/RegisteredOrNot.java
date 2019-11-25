package gui.interfaces;

import gui.Button;
import gui.Label;
import gui.StandardFrame;
import model.Customers;
import model.Library;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisteredOrNot {

    RegisteredOrNot(Library library, Customers customers) {
        JFrame frame = new StandardFrame("Registered?");
        JLabel label = new Label("Have you registered in the library System?",50,20,300,30);
        JButton yes = new Button("Yes!",50,80,300,40);
        JButton no = new Button("No, I need to register first.",50,120,300,40);

        yes.addActionListener(e -> {
            new BorrowABook("Book Information",library,customers);
            frame.dispose();

        });

        no.addActionListener(e -> {





            new CustomerRegistration(library,customers);
            frame.dispose();
        });

        frame.add(label);
        frame.add(yes);
        frame.add(no);


    }
}
