package main.ui;


import java.util.List;
import java.util.Scanner;


public class LibraryApplication {
    /* following B04 leclab */

    private Scanner scanner;
    private Library library = new Library();

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
                    + "\n[3] return a book"
                    + "\n[4] see all the books. ");
            operation = scanner.nextLine();
            System.out.println("You selected: " + operation);
            addABook(operation);
        }
    }

    private void addABook(String operation) {
        Book book = new Book("", "");
        if (operation.equals("1")) {
            System.out.println("Please enter the name of the book: ");
            book.name = scanner.nextLine();
            System.out.println("Please enter the author's name: ");
            book.author = scanner.nextLine();
            System.out.println("The book: " + "<" + book + ">" + " is added.");
            library.addABook(book);
        } else {
            loanABook(operation);
        }
    }

    private void loanABook(String operation) {
        if (operation.equals("2")) {
            Book book = new Book("", "");
            Customer customer = new Customer("", 0);

            System.out.println("Please enter the name of the book: ");
            book.name = scanner.nextLine();
            System.out.println("Please enter the author's name: ");
            book.author = scanner.nextLine();
            System.out.println("Please enter the name of the customer: ");
            customer.name = scanner.nextLine();
            System.out.println("Please enter the phone number of the customer: ");
            customer.phonenumber = scanner.nextInt();
            System.out.println("<" + book + ">" + " is removed from Available List.");
            int t = howLongAllowed();
            System.out.println("You are allowed to keep this book for " + t + " days.");
            customer.borrow(book);
        } else {
            returnABook(operation);
        }
    }

    private void returnABook(String operation) {
        if (operation.equals("3")) {
            Book book = new Book("","");
            Customer customer = new Customer("",0);

            System.out.println("Please enter the name of the book: ");
            book.name = scanner.nextLine();
            System.out.println("Please enter the author's name: ");
            book.author = scanner.nextLine();
            System.out.println("Please enter the name of the customer: ");
            customer.name = scanner.nextLine();
            System.out.println("Please enter the phone number of the customer: ");
            customer.phonenumber = scanner.nextInt();
            System.out.println("This book is returned to the library. Thank you! ");

            customer.returnBook(book);

        } else {
            seeAllBooks(operation);
        }
    }


    private void seeAllBooks(String operation) {

        if (operation.equals("4")) {
            System.out.println("These books are available: ");
            library.getBooks();

        }
    }
}

