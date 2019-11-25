package gui.interfaces;

import gui.Button;
import gui.Label;
import gui.StandardFrame;
import gui.TextField;
import model.Customers;
import model.Library;

import javax.swing.*;

public class CustomerRegistration {

    public CustomerRegistration(Library library, Customers customers) {
        JFrame frame = new StandardFrame("Registration");

        JLabel instruction1 = new Label("Could you please ",50,50,300,30);
        JLabel instruction2 = new Label("complete your information below?",120,65,300,30);



        JLabel nameLabel = new Label("Name: ",50,100,100,30);
        JLabel phoneNumberLabel = new Label("Phone Number: ",50,130,100,30);
        JTextField name = new TextField(200,100,100,30);
        JTextField phoneNumber = new TextField(200,130,100,30);
        JButton ok = new Button("OK",300,130,50,30);

        ok.addActionListener(e -> {
            new InformationConformation("You are registered the library System !",
                    " Now try again ! ",library,customers);
            frame.dispose();
        });

        frame.add(instruction1);
        frame.add(instruction2);
        frame.add(nameLabel);
        frame.add(phoneNumberLabel);
        frame.add(name);
        frame.add(phoneNumber);
        frame.add(ok);


    }



}
