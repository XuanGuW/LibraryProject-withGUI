package gui.interfaces;

import gui.Button;
import gui.Label;
import gui.StandardFrame;
import model.Customers;
import model.Library;
import ui.Loader;
import ui.Saver;

import javax.swing.*;
import java.io.IOException;

public class FirstInterface {


    //the first interface of the library
    public FirstInterface(String title, Library library, Customers customers) throws IOException {

        String text1 = "books.txt";
        String text2 = "customers.txt";
        library.setLibraryBooks(Loader.loadBooks(library.getLibraryBooks(), text1));
        customers.setCustomers(Loader.loadCustomers(customers.getCustomers(),text2));
        Saver.saveBooks(library.getLibraryBooks(), text1);
        Saver.saveCustomers(customers.getCustomers(), text2);

        JFrame frame = new StandardFrame(title);


        JButton b1 = new Button("Yes!",100,80,200,40);
        JButton b2 = new Button("No, I am a customer",100,120,200,40);

        // go to librarian interface
        b1.addActionListener(e -> {
            new LibrarianInterface("Librarian Interface", library,customers);
            frame.dispose();
        });

        // go to customer interface
        b2.addActionListener(e -> {
            new CustomerInterface("Customer Interface", library, customers);
            frame.dispose();
        });

        JLabel label1 = new Label(" Hello! Are you a librarian?",100,10,300,100);


        frame.add(b1);
        frame.add(b2);
        frame.add(label1);



    }
}
