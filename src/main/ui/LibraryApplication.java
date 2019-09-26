package main.ui;


import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class LibraryApplication {
    /* following B04 leclab */

    private Scanner scanner;
    private List<String> availablelist = new ArrayList<>();
    private List<String> loanedList = new ArrayList<>();


    public LibraryApplication() {

        scanner = new Scanner(System.in);
        processOperations();
    }

    private int howLongAllowed() {
        return 20;
    }

    private void processOperations() {
        String operation = "";
        while (true) {
            System.out.println("Please enter what you would like to do: "
                    + "\n[1] add a book "
                    + "\n[2] loan a book "
                    + "\n[3] see all the books. ");
            operation = scanner.nextLine();
            System.out.println("You selected: " + operation);
            helper(operation);
        }
    }

    private void helper(String operation) {
        String book;
        if (operation.equals("1")) {
            System.out.println("Please enter the name of the book: ");
            book = scanner.nextLine();
            System.out.println("The book: " + "<" + book + ">" + " is added.");
            availablelist.add(book);
        } else if (operation.equals("2")) {
            System.out.println("Please enter the name of the book: ");

            book = scanner.nextLine();
            System.out.println("<" + book + ">" + " is removed from Available List.");

            int t = howLongAllowed();

            System.out.println("You are allowed to keep this book for " + t + " days.");
            availablelist.remove(book);
            loanedList.add(book);
        } else if (operation.equals("3")) {
            System.out.println("These books are available: " + availablelist);
            System.out.println("These books are loaned: " + loanedList);
        }
    }


    public static void main(String[] args) {
        new LibraryApplication();


    }



}

