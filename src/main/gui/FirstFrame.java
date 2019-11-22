package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstFrame extends JFrame {

    public FirstFrame(String name) {
        super(name);
        setSize(400,200);
        setLayout(null);
        setVisible(true);

        JButton b = new Button("Enter");
        JTextField textField = new TextField(100,100,95,30);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enter = textField.getText();

                if (enter.equalsIgnoreCase("yes")) {
                    new LibrarianFrame("librarian interface");
                } else {
                    new CustomerFrame("Customer interface");
                }
            }
        });

        JLabel label1 = new Label(" Hello! Are you a librarian?");





        add(b);
        add(textField);
        add(label1);




    }
}
