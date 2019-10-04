package main.ui;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LibraryApplication {


    private Saver saver;
    private Loader loader;
    private Scanner scanner;
    private Library library = new Library();
    private List<Book> myBooks = new ArrayList();
    private Book book = new Book("", "");

    public LibraryApplication() throws IOException {

        scanner = new Scanner(System.in);
        processOperations();
        library.getBooks();
        loader.load(library.availablebook);
    }

    private void processOperations() throws IOException {

        String identity = "";
        while (true) {
            System.out.println("Are you a customer? or a librarian?: "
                    + "\n[1] I am a customer "
                    + "\n[2] I am a librarian "
                    + "\n[3] Quit."
            );

            identity = scanner.nextLine();
            identityHelper(identity);
            saver.save(library.availablebook);
            break;

        }

    }



    private void identityHelper(String identity) {

        if (identity.equals("1")) {
            customer();
        } else if (identity.equals("2")) {
            librarian();
        }
    }


    private void customer() {
        String operation;
        System.out.println("What are you going to do today?"
                + "\n [1] I want to borrow a book"
                + "\n [2] I want to return a book");
        operation = scanner.nextLine();
        if (operation.equals("1")) {
            loanABook();

        } else if (operation.equals("2")) {
            returnABook();
        }
    }


    private void librarian() {
        String operation;
        System.out.println("What are you going to do today?"
                + "\n[1] I want to add a book"
                + "\n[2] I want to see all the books");
        operation = scanner.nextLine();
        if (operation.equals("1")) {
            addABook();
        } else if (operation.equals("2")) {
            seeAllBooks();
        }

    }

    private void addABook() {
        System.out.println("Please enter the name of the book: ");
        book.name = scanner.nextLine();
        System.out.println("Please enter the author's name: ");
        book.author = scanner.nextLine();
        System.out.println("The book: " + "<" + book.name + ">" + " is added to the library.");
        library.addABook(book);





    }

    private void loanABook() {

        Customer customer = new Customer("", 0, myBooks);
        System.out.println("Please enter the name of the book: ");
        book.name = scanner.nextLine();
        System.out.println("Please enter the author's name: ");
        book.author = scanner.nextLine();
        System.out.println("Please enter your name: ");
        customer.name = scanner.nextLine();
        System.out.println("Please enter your phone: ");
        customer.phoneNumber = scanner.nextInt();
        System.out.println("Thank you! " + "\n You can keep the book for 20 days");
        customer.borrow(book);

    }

    private void returnABook() {

        Customer customer = new Customer("", 0, myBooks);

        System.out.println("Please enter the name of the book: ");
        book.name = scanner.nextLine();
        System.out.println("Please enter the author's name: ");
        book.author = scanner.nextLine();
        System.out.println("Please enter the name of the customer: ");
        customer.name = scanner.nextLine();
        System.out.println("Please enter the phone number of the customer: ");
        customer.phoneNumber = scanner.nextInt();
        System.out.println("This book is returned to the library. Thank you! ");

        customer.returnBook(book);
    }


    private void seeAllBooks() {
        if (library.size == 0) {
            System.out.println("Sorry, no books are in the library right now");
        } else {
            System.out.println("These books are in the library: ");
            library.getBooks();

        }
    }




}

