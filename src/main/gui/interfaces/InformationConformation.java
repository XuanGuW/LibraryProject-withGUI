package gui.interfaces;

import gui.Button;
import gui.Label;
import gui.StandardFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class InformationConformation {

    InformationConformation(String message) {
        JFrame frame = new StandardFrame("Confirmation");

        JLabel label = new Label(message,50,50,300,50);
        JButton button = new Button("Next",100,100,200,50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TheEnd();
                frame.dispose();
            }
        });

        frame.add(label);
        frame.add(button);

    }

    InformationConformation(String message, String message2) {
        JFrame frame = new StandardFrame("Confirmation");

        JLabel label = new Label(message,50,20,300,50);
        JLabel label2 = new Label(message2,50,50,300,50);

        JButton button = new Button("Next",100,100,200,50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FirstInterface("Library");
                frame.dispose();
            }
        });

        frame.add(label);
        frame.add(label2);
        frame.add(button);

    }
}
