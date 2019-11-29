package gui.interfaces;

import model.Customers;
import model.Library;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;


class SeeAllBooks {

    SeeAllBooks(Library library, Customers customers) {
        JFrame frame = new JFrame("Library Books");
        frame.setSize(350, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);



//        try {
//            library.addABook(new NormalBook("name1","author"));
//            library.addABook(new NormalBook("name2","author"));
//            library.addABook(new NormalBook("name3","author"));
//            library.addABook(new NormalBook("name4","author"));
//            library.addABook(new NormalBook("name5","author"));
//            library.addABook(new NormalBook("name6","author"));
//
//            library.addABook(new NormalBook("name11","author"));
//            library.addABook(new NormalBook("name22","author"));
//            library.addABook(new NormalBook("name33","author"));
//            library.addABook(new NormalBook("name44","author"));
//            library.addABook(new NormalBook("name56","author"));
//            library.addABook(new NormalBook("name66","author"));
//            library.addABook(new NormalBook("name16","author"));
//            library.addABook(new NormalBook("name24","author"));
//            library.addABook(new NormalBook("name36","author"));
//            library.addABook(new NormalBook("name46","author"));
//            library.addABook(new NormalBook("name56","author"));
//            library.addABook(new NormalBook("name67","author"));
//            library.addABook(new NormalBook("name18","author"));
//            library.addABook(new NormalBook("name29","author"));
//            library.addABook(new NormalBook("name30","author"));
//            library.addABook(new NormalBook("name40","author"));
//            library.addABook(new NormalBook("name53","author"));
//            library.addABook(new NormalBook("name64","author"));
//            library.addABook(new NormalBook("name13","author"));
//            library.addABook(new NormalBook("name23","author"));
//            library.addABook(new NormalBook("name33","author"));
//            library.addABook(new NormalBook("name43","author"));
//            library.addABook(new NormalBook("name53","author"));
//            library.addABook(new NormalBook("name63","author"));
//
//
//
//        } catch (NameIsEmptyString emptyString) {
//            emptyString.printStackTrace();
//        }


        JTextPane pane = new JTextPane();
        pane.setEditable(false);
        pane.setText(library.booksToString());
        pane.setSize(300,100);

        JScrollPane scrollPane = new JScrollPane(pane);


        JButton returnButton = new JButton("Return");

        // go to the first interface
        returnButton.addActionListener(e -> {
            try {
                new FirstInterface("Library",library,customers);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            frame.dispose();
        });

        frame.getContentPane().add(returnButton, BorderLayout.SOUTH);
        frame.getContentPane().add(scrollPane);






    }


}




