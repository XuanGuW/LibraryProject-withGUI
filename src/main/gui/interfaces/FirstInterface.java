package gui.interfaces;

import gui.Button;
import gui.Label;
import gui.StandardFrame;
import model.Library;

import javax.swing.*;

public class FirstInterface {


    public FirstInterface(String title) {
        JFrame frame = new StandardFrame(title);


        JButton b1 = new Button("Yes!",100,80,200,40);
        JButton b2 = new Button("No, I am a customer",100,120,200,40);

        b1.addActionListener(e -> {
            new LibrarianInterface("Librarian Interface");
            frame.dispose();
        });

        b2.addActionListener(e -> {
            new CustomerInterface("Customer Interface");
            frame.dispose();
        });

        JLabel label1 = new Label(" Hello! Are you a librarian?",100,10,300,100);


        frame.add(b1);
        frame.add(b2);
        frame.add(label1);





    }
}
