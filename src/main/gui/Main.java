package gui;

import gui.interfaces.FirstInterface;
import model.Customers;
import model.Library;

import java.io.IOException;

public class Main {

    private static Library library = new Library();

    private static Customers customers = new Customers();

    public static void main(String[] args) throws IOException {
        new FirstInterface("Library",library,customers);



    }






}
