package gui;

import javax.swing.*;

public class Label extends JLabel {

    public Label(String message,int x,int y, int w,int h) {
        super(message);
        setBounds(x,y,w,h);
        setVisible(true);
    }
}
