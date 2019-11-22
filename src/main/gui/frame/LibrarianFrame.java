
package gui.frame;

import gui.Button;
import gui.Label;

import javax.swing.*;

public class LibrarianFrame extends JFrame {

    public LibrarianFrame(String name) {
        new JFrame(name);

        setSize(400,200);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel label = new Label("So, what are you going to do today?",50,10,300,100);
        JButton button1 = new Button("I want to add a book",100,80,300,40);
        JButton button2 = new Button("I want to see all the books in library",100,120,300,40);



        add(label);
        add(button1);
        add(button2);













    }
}
