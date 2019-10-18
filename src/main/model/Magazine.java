package model;

public class Magazine extends AbstractBook {

    String publicationYear;

    public Magazine(String name, String publicationYear) {
        this.name = name;
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return  name + " " + publicationYear;
    }


}
