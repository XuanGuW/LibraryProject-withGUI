
package gui.interfaces;

import gui.Button;
import gui.Label;
import gui.StandardFrame;

import javax.swing.*;

class LibrarianInterface {

    LibrarianInterface(String title) {
        JFrame frame = new StandardFrame(title);

        JLabel label = new Label("So, what are you going to do today?",50,10,300,100);
        JButton addABook = new Button("I want to add a book",50,80,300,40);
        JButton seeAllBooks = new Button("I want to see all the books in library",50,120,300,40);

        addABook.addActionListener(e -> {
            new AddABook("Add A New Book");
            frame.dispose();
        });

        seeAllBooks.addActionListener(e -> {
            new SeeAllBooks();
            frame.dispose();
        });




        frame.add(label);
        frame.add(addABook);
        frame.add(seeAllBooks);













    }
}
