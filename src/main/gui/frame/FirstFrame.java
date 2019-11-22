package gui.frame;

import gui.Button;
import gui.Label;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstFrame extends JFrame {

    public FirstFrame(String name) {
        super(name);
        setSize(400,200);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);

        JButton b1 = new Button("Yes!",100,80,200,40);
        JButton b2 = new Button("No, I am a customer",100,120,200,40);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LibrarianFrame("Librarian Interface");
                dispose();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerFrame("Customer Interface");
                dispose();
            }
        });

        JLabel label1 = new Label(" Hello! Are you a librarian?",100,10,300,100);





        add(b1);
        add(b2);
        add(label1);





    }
}
