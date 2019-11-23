package gui.interfaces;

import gui.Button;
import gui.Label;
import gui.StandardFrame;
import gui.TextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddABookInterface {

    public AddABookInterface(String title) {
        JFrame frame = new StandardFrame(title);

        JTextField name = new TextField(150,70,100,30);
        JTextField author = new TextField(150,100,100,30);
        JLabel label1 = new Label("Could you please ",50,10,300,50);
        JLabel label2 = new Label("Complete the information for the book?",50,30,300,50);
        JLabel nameLabel = new Label("Name  :  ",70,70,100,30);
        JLabel authorLabel = new Label("Author  :  ",70,100,100,30);
        JButton enter = new Button("Enter",300,130,80,40);

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InformationCompleteInterface("The book is successfully added to the library!");

                frame.dispose();
            }
        });

        frame.add(name);
        frame.add(author);
        frame.add(label1);
        frame.add(label2);
        frame.add(nameLabel);
        frame.add(authorLabel);
        frame.add(enter);















    }
}
