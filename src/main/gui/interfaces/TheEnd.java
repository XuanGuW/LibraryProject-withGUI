package gui.interfaces;

import gui.Button;
import gui.Label;
import gui.StandardFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TheEnd {

    TheEnd() {
        JFrame frame = new StandardFrame("The End");

        JLabel label1 = new Label("Thank you for using our system,",50,50,300,50);
        JLabel label2 = new Label("Have a nice day!",220,80,300,50);
        JButton button = new Button("OK",300,120,80,30);

        button.addActionListener(e -> {
            new FirstInterface("Library");
            frame.dispose();
        });
        frame.add(label1);
        frame.add(label2);
        frame.add(button);




    }



}
