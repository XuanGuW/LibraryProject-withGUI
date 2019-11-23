
package gui.interfaces;

import gui.Button;
import gui.Label;
import gui.StandardFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianInterface {

    public LibrarianInterface(String title) {
        JFrame frame = new StandardFrame(title);

        JLabel label = new Label("So, what are you going to do today?",50,10,300,100);
        JButton addABook = new Button("I want to add a book",50,80,300,40);
        JButton seeAllBooks = new Button("I want to see all the books in library",50,120,300,40);

        addABook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddABookInterface("Add A New Book");
                frame.dispose();
            }
        });

        seeAllBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });




        frame.add(label);
        frame.add(addABook);
        frame.add(seeAllBooks);













    }
}
