
package gui.interfaces;

import gui.Button;
import gui.Label;
import gui.StandardFrame;
import model.Customers;
import model.Library;

import javax.swing.*;

class LibrarianInterface {



    LibrarianInterface(String title, Library library, Customers customers) {

        JFrame frame = new StandardFrame(title);

        JLabel label = new Label("So, what are you going to do today?",50,10,300,100);
        JButton addABook = new Button("I want to add a book",50,80,300,40);
        JButton seeAllBooks = new Button("I want to see all the books in library",50,120,300,40);

        // go to add a book interface
        addABook.addActionListener(e -> {
            new AddABook("Add A New Book",library,customers);
            frame.dispose();
        });

        // go to see all books
        seeAllBooks.addActionListener(e -> {
            new SeeAllBooks(library,customers);
            frame.dispose();
        });




        frame.add(label);
        frame.add(addABook);
        frame.add(seeAllBooks);



    }
}
