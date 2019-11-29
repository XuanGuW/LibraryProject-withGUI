package gui.interfaces;

import gui.Button;
import gui.Label;
import gui.StandardFrame;
import model.Customers;
import model.Library;

import javax.swing.*;
import java.io.IOException;

class InformationConfirmation {


    // confirmation interface with one-line message
    InformationConfirmation(String message, Library library, Customers customers) {
        JFrame frame = new StandardFrame("Confirmation");

        JLabel label = new Label(message,50,50,300,50);
        JButton button = new Button("Next",100,100,200,50);
        button.addActionListener(e -> {
            new TheEnd(library,customers);
            frame.dispose();
        });

        frame.add(label);
        frame.add(button);

    }

    // confirmation interface with two-line message
    InformationConfirmation(String message, String message2, Library library, Customers customers) {
        JFrame frame = new StandardFrame("Confirmation");

        JLabel label = new Label(message,50,20,300,50);
        JLabel label2 = new Label(message2,50,50,300,50);

        JButton button = new Button("Next",100,100,200,50);
        button.addActionListener(e -> {
            try {
                new FirstInterface("Library",library,customers);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            frame.dispose();
        });

        frame.add(label);
        frame.add(label2);
        frame.add(button);

    }
}
