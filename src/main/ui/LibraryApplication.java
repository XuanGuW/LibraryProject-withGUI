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
    private List<Book> myBooks;
    private List<Customer> customerList = new ArrayList<>();

    private Book book = new NormalBook("", "");
    private String text;


    // not know how to store boolean and number value and return it
    public LibraryApplication() throws IOException {

        text = "books.txt";
        scanner = new Scanner(System.in);

        myBooks = loader.load(library.getAvailableBooksList(), text);
        library.setAvailableBooksList(myBooks);
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

            identity = scanner.nextLine();
            identityHelper(identity);
            saver.save(library.getAvailableBooksList(), text);
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
            if (scanner.nextLine() == "2") {
                loanABook();
            } else {
                completeCustomerInformation();
            }
        } else if (operation.equals("2")) {
            returnABook();
        }
    }

    // create a new customer object with information, add it to customer list
    private void completeCustomerInformation() {
        myBooks = new ArrayList<>();
        System.out.println("what is your name?");
        String customerName = scanner.nextLine();
        System.out.println("what is your phoneNumber");
        String customerPhoneNumber = scanner.nextLine();
        Customer customer = new Customer(customerName,customerPhoneNumber, myBooks);
        customerList.add(customer);

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
        book.setName(scanner.nextLine());
        System.out.println("Please enter the author's name: ");
        book.setName(scanner.nextLine());
        System.out.println("The book: " + "<" + book.getName() + ">" + " is added to the library.");
        library.addABook(book);

    }

    //
    private void loanABook() {

        Customer customer;
        System.out.println("Please enter the name of the book: ");
        String bookName = scanner.nextLine();
        System.out.println("Please enter the author's name: ");
        String authorName = scanner.nextLine();
        System.out.println("Please enter your name: ");
        String customerName = scanner.nextLine();
        System.out.println("Please enter your phone: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Thank you! " + "\n You can keep the book for 20 days");
        customer = library.findACustomer(customerName, phoneNumber);
        book = library.findABook(bookName, authorName);
        book.setBorrower(customer);
        book.setAvailability(false);
        customer.borrow(book);


    }

    //assuming there is only one book with a name and a author's name
    //   and a customer has a unique name

    private void returnABook() {



        System.out.println("Please enter the name of the book: ");
        String bookName = scanner.nextLine();
        System.out.println("Please enter the author's name: ");
        String authorName = scanner.nextLine();
        System.out.println("Please enter your name: ");
        String customerName = scanner.nextLine();
        System.out.println("Please enter your telephone number");
        String phoneNumber = scanner.nextLine();

        Customer customer = library.findACustomer(customerName, phoneNumber);
        Book normalBook = library.findABook(bookName, authorName);

        System.out.println("This book is returned to the library. Thank you! ");

        customer.returnBook(normalBook);
        normalBook.setBorrower(null);
        normalBook.setAvailability(true);

    }


    private void seeAllBooks() {
        if (library.size == 0) {
            System.out.println("Sorry, no books are in the library right now");
        } else {
            System.out.println("These books are in the library: ");
            library.getAvailableBooksList();

        }
    }




}

