package gui.interfaces;

import exceptions.NothingFoundExceptions;
import gui.Button;
import gui.Label;
import gui.StandardFrame;
import gui.TextField;
import model.Book;
import model.Customer;
import model.Customers;
import model.Library;

import javax.swing.*;


class ReturnABook {

    ReturnABook(Library library, Customers customers) {
        JFrame frame = new StandardFrame("Return A Book");

        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400,250);



        JTextField name = new gui.TextField(180,60,100,30);
        JTextField author = new gui.TextField(180,90,100,30);
        JTextField customerName = new TextField(180,120,100,30);
        JTextField phoneNumber = new TextField(180,150,100,30);


        JLabel label1 = new gui.Label("Could you please complete the ",50,5,300,50);
        JLabel label2 = new gui.Label("Information for the book and yourself?",50,20,300,50);
        JLabel nameLabel = new gui.Label("Name  :  ",50,60,150,30);
        JLabel authorLabel = new gui.Label("Author  :  ",50,90,150,30);
        JLabel customerNameLabel = new gui.Label("Your Name  :  ",50,120,150,30);
        JLabel phoneNumberLabel = new gui.Label("Phone Number  :  ",50,150,150,30);




        JButton enter = new Button("Enter",300,130,80,50);


        // return a book and go to confirmation interface
        enter.addActionListener(e -> {

            try {
                Customer customer = customers.findACustomer(customerName.getText(), phoneNumber.getText());
                Book normalBook;
                normalBook = library.findABook(name.getText(), author.getText());
                customer.returnBook(normalBook);
                normalBook.setCustomer(null);
                new InformationConfirmation("Process successfully !",library,customers);
                frame.dispose();

            } catch (NothingFoundExceptions nothingFoundExceptions) {
                JLabel label = new Label("Please enter the correct information!",
                        20,180,350,30);
                frame.add(label);

            }




        });


        frame.add(name);
        frame.add(author);
        frame.add(customerName);
        frame.add(phoneNumber);



        frame.add(label1);
        frame.add(label2);

        frame.add(nameLabel);
        frame.add(authorLabel);
        frame.add(customerNameLabel);
        frame.add(phoneNumberLabel);

        frame.add(enter);

    }
}
