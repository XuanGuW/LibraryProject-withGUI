package gui.interfaces;

import gui.Button;
import gui.Label;
import gui.StandardFrame;
import model.Customers;
import model.Library;

import javax.swing.*;


class CustomerInterface {


    CustomerInterface(String title, Library library, Customers customers) {
        JFrame frame = new StandardFrame(title);

        JLabel label = new Label("Hi, what are you going to do today?",50,10,300,40);
        JButton borrowABook = new Button("I want to borrow a book!",50,80,300,40);
        JButton returnABook = new Button("I want to return a book!",50,120,300,40);


        borrowABook.addActionListener(e -> {
            new RegisteredOrNot(library,customers);
            frame.dispose();
        });

        returnABook.addActionListener(e -> new ReturnABook(library,customers));


        frame.add(label);
        frame.add(borrowABook);
        frame.add(returnABook);

    }



}
