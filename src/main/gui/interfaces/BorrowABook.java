package gui.interfaces;

import gui.Button;
import gui.Label;
import gui.TextField;
import model.*;

import javax.swing.*;

class BorrowABook {

    BorrowABook(String title, Library library, Customers customers) {
        JFrame frame = new JFrame(title);

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

        //A customer borrow a book
        enter.addActionListener(e -> {
            try {
                Book book = new NormalBook(name.getText(),author.getText());
                Customer customer = new Customer(customerName.getText(),phoneNumber.getText());

                library.findABook(name.getText(),author.getText());
                customers.findACustomer(customerName.getText(),phoneNumber.getText());
                book.setCustomer(customer);
                customer.borrow(book);
                new InformationConfirmation("Now you can enjoy your reading !",
                        "You can keep this book for 20 days !",library,customers);


                frame.dispose();
            } catch (Exception exception) {

                JLabel label = new Label("Please enter the correct information!",
                        20,180,350,30);
                frame.add(label);
            }



        });

        frame.add(label1);
        frame.add(label2);


        frame.add(name);
        frame.add(author);
        frame.add(customerName);
        frame.add(phoneNumber);



        frame.add(nameLabel);
        frame.add(authorLabel);
        frame.add(customerNameLabel);
        frame.add(phoneNumberLabel);


        frame.add(enter);
        frame.setLocationRelativeTo(null);


    }


}
