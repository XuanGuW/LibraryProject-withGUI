package gui.interfaces;

import exceptions.NameIsEmptyString;
import gui.Button;
import gui.Label;
import gui.StandardFrame;
import gui.TextField;
import model.Book;
import model.Customers;
import model.Library;
import model.NormalBook;

import javax.swing.*;

class AddABook {

    AddABook(String title, Library library, Customers customers) {



        JFrame frame = new StandardFrame(title);

        JTextField name = new TextField(150,70,100,30);
        JTextField author = new TextField(150,100,100,30);
        JLabel label1 = new Label("Could you please ",50,10,300,50);
        JLabel label2 = new Label("Complete the information for the book?",50,30,300,50);
        JLabel nameLabel = new Label("Name  :  ",70,70,100,30);
        JLabel authorLabel = new Label("Author  :  ",70,100,100,30);
        JButton enter = new Button("Enter",300,130,80,40);


        //add a book to the library
        enter.addActionListener(e -> {
            try {
                Book book = new NormalBook(name.getText(),author.getText());
                library.addABook(book);
                new InformationConfirmation("The book is successfully added to the library!", library,customers);
                frame.dispose();
            } catch (NameIsEmptyString emptyString) {
                JLabel label = new Label("Please enter the right information!",
                        10,150,300,10);
                frame.add(label);

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
