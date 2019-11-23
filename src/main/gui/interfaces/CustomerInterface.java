package gui.interfaces;

import gui.Button;
import gui.Label;
import gui.StandardFrame;

import javax.swing.*;


class CustomerInterface extends JFrame {


    CustomerInterface(String title) {
        JFrame frame = new StandardFrame(title);

        JLabel label = new Label("Hi, what are you going to do today?",50,10,300,40);
        JButton borrowABook = new Button("I want to borrow a book!",50,50,300,40);
        JButton returnABook = new Button("I want to return a book!",50,100,300,40);


        borrowABook.addActionListener(e -> {
            new RegisteredOrNot();
            frame.dispose();
        });

        returnABook.addActionListener(e -> new ReturnABook());


        frame.add(label);
        frame.add(borrowABook);
        frame.add(returnABook);

    }



}