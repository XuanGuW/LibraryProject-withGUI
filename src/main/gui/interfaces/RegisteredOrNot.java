package gui.interfaces;

import gui.Button;
import gui.Label;
import gui.StandardFrame;
import model.Customers;
import model.Library;

import javax.swing.*;

class RegisteredOrNot {

    RegisteredOrNot(Library library, Customers customers) {
        JFrame frame = new StandardFrame("Registered?");
        JLabel label = new Label("Have you registered in the library System?",50,20,300,30);
        JButton yes = new Button("Yes!",50,80,300,40);
        JButton no = new Button("No, I need to register first.",50,120,300,40);


        // click yes button and go to borrow book interface
        yes.addActionListener(e -> {
            new BorrowABook("Library",library,customers);
            frame.dispose();

        });

        //click no button and go to registration interface for a new customer
        no.addActionListener(e -> {
            new CustomerRegistration(library,customers);
            frame.dispose();
        });

        frame.add(label);
        frame.add(yes);
        frame.add(no);


    }
}
