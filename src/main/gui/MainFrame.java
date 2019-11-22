package gui;

import javax.swing.*;
import javax.xml.soap.Detail;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame(String title) {
        super(title);

        setLayout(new BorderLayout());
        JTextArea textArea = new JTextArea();
        JButton button = new JButton("enter");
        DetailsPanel detailsPanel = new DetailsPanel();


        Container c = getContentPane();


        c.add(textArea,BorderLayout.CENTER);
        c.add(button, BorderLayout.SOUTH);
        c.add(detailsPanel,BorderLayout.WEST);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Hello\n");
            }
        });
    }
}
