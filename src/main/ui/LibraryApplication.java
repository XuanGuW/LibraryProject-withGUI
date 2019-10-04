package main.ui;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LibraryApplication {


    private Saver saver = new Saver();
    private Loader loader = new Loader();
    private Scanner scanner;
    private Library library = new Library();
    private List<NormalBook> myNormalBooks = new ArrayList();
    private NormalBook normalBook = new NormalBook("", "");
    private String text;

    public LibraryApplication() throws IOException {
        text = "books.text";
        scanner = new Scanner(System.in);
        processOperations();
        loader.load(library.availableNormalBooks,text);
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
            text = "booksNew";
            saver.save(library.availableNormalBooks,text);
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
        normalBook.name = scanner.nextLine();
        System.out.println("Please enter the author's name: ");
        normalBook.author = scanner.nextLine();
        System.out.println("The book: " + "<" + normalBook.name + ">" + " is added to the library.");
        library.addABook(normalBook);





    }

    private void loanABook() {

        Customer customer = new Customer("", 0, myNormalBooks);
        System.out.println("Please enter the name of the book: ");
        normalBook.name = scanner.nextLine();
        System.out.println("Please enter the author's name: ");
        normalBook.author = scanner.nextLine();
        System.out.println("Please enter your name: ");
        customer.name = scanner.nextLine();
        System.out.println("Please enter your phone: ");
        customer.phoneNumber = scanner.nextInt();
        System.out.println("Thank you! " + "\n You can keep the book for 20 days");
        customer.borrow(normalBook);

    }

    private void returnABook() {

        Customer customer = new Customer("", 0, myNormalBooks);

        System.out.println("Please enter the name of the book: ");
        normalBook.name = scanner.nextLine();
        System.out.println("Please enter the author's name: ");
        normalBook.author = scanner.nextLine();
        System.out.println("Please enter the name of the customer: ");
        customer.name = scanner.nextLine();
        System.out.println("Please enter the phone number of the customer: ");
        customer.phoneNumber = scanner.nextInt();
        System.out.println("This book is returned to the library. Thank you! ");

        customer.returnBook(normalBook);
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

