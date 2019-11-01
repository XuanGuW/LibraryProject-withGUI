package model;

import exceptions.NameIsEmptyString;

public class NormalBook extends AbstractBook {


    public NormalBook(String name, String author) throws NameIsEmptyString {

        if (name.equals("")) {
            throw new NameIsEmptyString();
        }
        this.name = name;
        this.author = author;
        this.borrower = null;
        this.availability = true;
    }




}
