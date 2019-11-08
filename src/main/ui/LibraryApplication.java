package ui;


import exceptions.NameIsEmptyString;
import exceptions.NothingFoundExceptions;
import model.*;

import java.io.IOException;
import java.util.*;

import static ui.Loader.splitOnSpace;


class LibraryApplication {

    private Scanner scanner;
    private Library library = new Library();
    private Customers customers = new Customers();
    private Book book;
    private String text1;
    private String text2;



    LibraryApplication() throws IOException {

        try {
            book = new NormalBook("name","author");
        } catch (NameIsEmptyString nameIsEmptyString) {
            System.out.println("the name of the book should not be empty");
        }
        text1 = "books.txt";
        text2 = "customers.txt";
        library.setLibraryBooks(Loader.loadBooks(library.getLibraryBooks(), text1));
        customers.setCustomers(Loader.loadCustomers(customers.getCustomers(),text2));
        processOperations();
    }

    private void processOperations() throws IOException {

        String identity = "";
        while (true) {
            System.out.println("Are you a customer? or a librarian?: "
                    + "\n[1] I am a customer "
                    + "\n[2] I am a librarian "
                    + "\n[3] Quit."
            );
            scanner = new Scanner(System.in);
            identity = scanner.nextLine();
            identityHelper(identity);
            Saver.saveBook(library.getLibraryBooks(), text1);
            Saver.saveCustomer(customers.getCustomers(), text2);
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

    //EFFECTS: create a new customer object with information, add it to customer list
    private void completeCustomerInformation() {

        System.out.println("what is your name?");
        String customerName = scanner.nextLine();
        System.out.println("what is your phoneNumber");
        String customerPhoneNumber = scanner.nextLine();
        Customer customer = new Customer(customerName,customerPhoneNumber);

        customers.getCustomers().put(customerName + " " + customerPhoneNumber,customer);

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
        String bookName = scanner.nextLine();
        book.setName(bookName);
        System.out.println("Please enter the author's name: ");
        String authorName = scanner.nextLine();
        book.setAuthor(authorName);
        library.getLibraryBooks().put(bookName + " " + authorName,book);
        System.out.println("The book: " + "<" + book.getName() + ">" + " is added to the library.");



    }

    //EFFECTS: get information for future operation between a book and a customer
    private String getInformation() {

        String bookInformation = getBookInformation();
        String customerInformation = getCustomerInformation();
        return  bookInformation + " " + customerInformation;

    }

    private String getBookInformation() {
        System.out.println("Please enter the name of the book: ");
        String bookName = scanner.nextLine();
        System.out.println("Please enter the author's name: ");
        String authorName = scanner.nextLine();
        return " " + bookName + " " + authorName;
    }

    private String getCustomerInformation() {

        System.out.println("Please enter your name: ");
        String customerName = scanner.nextLine();
        System.out.println("Please enter your phone number: ");
        String phoneNumber = scanner.nextLine();
        return customerName + phoneNumber;

    }




    private void loanABook() {

        ArrayList<String> partOfLine = splitOnSpace(getInformation());
        String bookName = partOfLine.get(0);
        String authorName = partOfLine.get(1);
        String customerName = partOfLine.get(2);
        String phoneNumber = partOfLine.get(3);
        Customer customer;

        try {
            customer = customers.findACustomer(customerName, phoneNumber);
            book = library.findABook(bookName, authorName);
            book.setCustomer(customer);
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

    private void returnABook() {

        ArrayList<String> partOfLine = splitOnSpace(getInformation());
        String bookName = partOfLine.get(0);
        String authorName = partOfLine.get(1);
        String customerName = partOfLine.get(2);
        String phoneNumber = partOfLine.get(3);
        try {
            Customer customer = customers.findACustomer(customerName, phoneNumber);
            Book normalBook;
            normalBook = library.findABook(bookName, authorName);
            customer.returnBook(normalBook);
            normalBook.setCustomer(null);
            normalBook.setAvailability(true);

        } catch (NothingFoundExceptions nothingFoundExceptions) {
            System.out.println("sorry, you seem not to be registered in the library yet or this book can not be found!")
            ;
        } finally {
            System.out.println("Thank you!");
        }

    }

    private void seeAllBooks() {
        if (library.getLibraryBooks().size() == 0) {
            System.out.println("Sorry, no books are in the library right now");
        } else {
            System.out.println("These books are in the library: ");
            System.out.println(library.getBooksNames());;
        }
    }


}

