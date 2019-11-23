package gui.interfaces;

import gui.Label;
import gui.StandardFrame;

import javax.swing.*;

public class InformationCompleteInterface {

    public InformationCompleteInterface(String message) {
        JFrame frame = new StandardFrame("Message Confirm");

        JLabel label = new Label(message,200,150,300,50);


        frame.add(label);
        new TheEnd();

    }
}
