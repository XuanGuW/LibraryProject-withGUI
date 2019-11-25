package gui;

import gui.interfaces.FirstInterface;
import model.Customers;
import model.Library;

public class Main {

    private static Library library = new Library();

    private static Customers customers = new Customers();

    public static void main(String[] args) {
        new FirstInterface("Library",library,customers);


    }






}
