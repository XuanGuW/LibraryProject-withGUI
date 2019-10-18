package ui;


import exceptions.CustomerNotFoundException;
import exceptions.NameIsEmptyString;
import exceptions.NoBookIsFound;
import exceptions.NothingFoundExceptions;
import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ui.Loader.splitOnSpace;


public class LibraryApplication {


    private Saver saver = new Saver();
    private Loader loader = new Loader();
    private Scanner scanner;
    private Library library = new Library();
    private List<Book> myBooks;
    private List<Customer> customerList = new ArrayList<>();

    private Book book;
    private String text;


    // not know how to store boolean and number value and return it
    public LibraryApplication() throws IOException {

        try {
            book = new NormalBook("name","author");
        } catch (NameIsEmptyString nameIsEmptyString) {
            System.out.println("the name of the book should not be empty");
        }

        text = "books.txt";
        scanner = new Scanner(System.in);

        myBooks = loader.load(library.getAvailableBooksList(), text);
        library.setAvailableBooksList(myBooks);
        processOperations();
    }

    public void processOperations() throws IOException {

        String identity = "";
        while (true) {
            System.out.println("Are you a customer? or a librarian?: "
                    + "\n[1] I am a customer "
                    + "\n[2] I am a librarian "
                    + "\n[3] Quit."
            );

            identity = scanner.nextLine();
            identityHelper(identity);
            saver.save(library.getAvailableBooksList(), text);
            break;

        }

    }



    public void identityHelper(String identity) {

        if (identity.equals("1")) {
            customer();
        } else if (identity.equals("2")) {
            librarian();
        }
    }


    public void customer() {
        String operation;
        System.out.println("What are you going to do today?"
                + "\n [1] I want to borrow a book"
                + "\n [2] I want to return a book");
        operation = scanner.nextLine();
        if (operation.equals("1")) {
            System.out.println("Are you a new customer?" + "\n[1]Yes" + "\n[2]No");
            if (scanner.nextLine().equals("2")) {
                loanABook();
            } else {
                completeCustomerInformation();
            }
        } else if (operation.equals("2")) {
            returnABook();
        }
    }

    // create a new customer object with information, add it to customer list
    public void completeCustomerInformation() {
        myBooks = new ArrayList<>();
        System.out.println("what is your name?");
        String customerName = scanner.nextLine();
        System.out.println("what is your phoneNumber");
        String customerPhoneNumber = scanner.nextLine();
        Customer customer = new Customer(customerName,customerPhoneNumber, myBooks);
        customerList.add(customer);

    }


    public void librarian() {
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

    public void addABook() {

        System.out.println("Please enter the name of the book: ");
        book.setName(scanner.nextLine());
        System.out.println("Please enter the author's name: ");
        book.setName(scanner.nextLine());
        System.out.println("The book: " + "<" + book.getName() + ">" + " is added to the library.");
        library.addABook(book);

    }

    //
    public String getTheInformation() {

        System.out.println("Please enter the name of the book: ");
        String bookName = scanner.nextLine();
        System.out.println("Please enter the author's name: ");
        String authorName = scanner.nextLine();
        System.out.println("Please enter your name: ");
        String customerName = scanner.nextLine();
        System.out.println("Please enter your phone number: ");
        String phoneNumber = scanner.nextLine();
        return bookName + " " + authorName + " " + customerName + " " + phoneNumber + " ";


    }


    public void loanABook() {

        ArrayList<String> partOfLine = splitOnSpace(getTheInformation());
        String bookName = partOfLine.get(0);
        String authorName = partOfLine.get(1);
        String customerName = partOfLine.get(2);
        String phoneNumber = partOfLine.get(3);
        Customer customer;

        try {
            customer = library.findACustomer(customerName, phoneNumber);
            book = library.findABook(bookName, authorName);
            book.setBorrower(customer);
            book.setAvailability(false);
            customer.borrow(book);
            System.out.println("Thank you! " + "\n You can keep the book for 20 days");
        } catch (NothingFoundExceptions e) {
            System.out.println("sorry, you seem not to be registered in the library yet or this book can not be found!")
            ;
        }
    }


    //assuming there is only one book with a name and a author's name
    //   and a customer has a unique name

    public void returnABook() {

        ArrayList<String> partOfLine = splitOnSpace(getTheInformation());
        String bookName = partOfLine.get(0);
        String authorName = partOfLine.get(1);
        String customerName = partOfLine.get(2);
        String phoneNumber = partOfLine.get(3);
        try {
            Customer customer = library.findACustomer(customerName, phoneNumber);
            Book normalBook;
            normalBook = library.findABook(bookName, authorName);
            customer.returnBook(normalBook);
            normalBook.setBorrower(null);
            normalBook.setAvailability(true);

        } catch (NothingFoundExceptions nothingFoundExceptions) {
            System.out.println("sorry, you seem not to be registered in the library yet or this book can not be found!")
            ;
        } finally {
            System.out.println("Thank you and have a good day!");
        }





    }


    public void seeAllBooks() {
        if (library.size == 0) {
            System.out.println("Sorry, no books are in the library right now");
        } else {
            System.out.println("These books are in the library: ");
            library.getBooksNames();

        }
    }




}

